import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5, 6},
            {6, 5, 4, 3, 2, 1},
            {1, 6, 2, 5, 3, 4},
            {1, 7, 7, 0, 1, 3}
        };
        
        for (int[] test : testCases) {
            ArrayList<Integer> testAL = new ArrayList<Integer>();
            for (int v : test) testAL.add(v);
            
            System.out.println(testAL);
            sortList(testAL);
            System.out.println(testAL);
            System.out.println();
        }
    }
    
    public static void sortList(ArrayList<Integer> list) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        int listSize = list.size();
        
        for (int i=0; i<listSize; i++) {
            int smallest = list.get(0),
                index = 0;
            
            // find the smallest
            for (int o=0; o<list.size(); o++) {
                if(list.get(o) < smallest){
                    smallest = list.get(o);
                    index = o;
                }
            }
            
            // remove, and add it to temp list
            list.remove(index);
            tempList.add(smallest);
        }
        
        // set list to tempList.
        // java is bad
        for (int i=0; i<listSize; i++) {
            list.add(tempList.get(i));
        }
    }
}