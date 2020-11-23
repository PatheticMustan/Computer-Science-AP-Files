import java.util.Arrays;

public class resizeArray {
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4 };
        
        System.out.println(Arrays.toString(resize(test, 10)));
        System.out.println(Arrays.toString(resize(test, 2)));
                           
    }
    
    public static int[] resize(int[] array, int newLength) {
        int[] result = new int[newLength];
        
        for (int i=0; i<newLength; i++) {
            if (i < array.length) {
                result[i] = array[i];
            } else {
                result[i] = 0;
            }
        }
        
        return result;
    }
}