import java.util.*;

public class ArrayUtils {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(17);
        seed(nums, 10, 1, 10);
        
        System.out.println(nums);
        System.out.println(min(nums));
        System.out.println(max(nums));
    }
    
    public static void seed(ArrayList<Integer> list, int numElements, int minValue, int maxValue) {
        for (int i=0; i<numElements; i++) {
            int range = maxValue - minValue + 1;
            
            list.add((int)(Math.random()*range) + minValue);
        }
    }
    
    public static int min(ArrayList<Integer> list) {
        int min = list.get(0);
        
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        
        return min;
    }
    
    public static int max(ArrayList<Integer> list) {
        int max = list.get(0);
        
        for (int i=0; i<list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        
        return max;
    }
}