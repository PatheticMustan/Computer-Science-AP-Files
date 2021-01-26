import java.util.*;

public class ListSorting {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(1);
        nums.add(4);
        nums.add(1);
        nums.add(5);
        nums.add(9);
        nums.add(2);
        nums.add(6);
        nums.add(5);
        nums.add(3);
        System.out.println(nums);
        sortIAL(nums);
        System.out.println(nums);

        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        ArrayUtils.seed(nums1, 100, 1, 100);
        System.out.println(nums1);
        sortIAL(nums1);
        System.out.println(nums1);
    }



    public static void sortIAL(ArrayList<Integer> list) {
        // I don't want to do that weird temp sort thing, so I just did bubble sort
        for (int eeee=0; eeee<list.size(); eeee++) {
            for (int i=0; i<list.size()-1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    // swap the two
                    int t = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, t);
                }
            }
        }
    }
}
