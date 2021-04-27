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
            System.out.println(Arrays.toString(test));
            selectionSort(test);
            System.out.println(Arrays.toString(test));
            System.out.println();
        }

        String[][] testCasesStrings = {
            {"a", "b", "c", "d", "e", "f"},
            {"f", "e", "d", "c", "b", "a"},
            {"apple", "autonomous", "annoying", "aptitude", "zealot", "peaches"},
            {"baaa", "abbb", "baab", "poop!", "yeah huh", "yee haw!"}
        };
        
        for (String[] test : testCasesStrings) {
            System.out.println(Arrays.toString(test));
            selectionSort(test);
            System.out.println(Arrays.toString(test));
            System.out.println();
        }
    }

    public static void selectionSort(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            int smallest = array[i];
            int indexOfSmallest = i;

            // find the smallest
            for (int o=i; o<array.length; o++) {
                if (array[o] < smallest) {
                    smallest = array[o];
                    indexOfSmallest = o;
                }
            }

            // swap
            int temp = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = temp;
        }
    }
    
    public static void selectionSort(String[] array) {
        for (int i=0; i<array.length-1; i++) {
            String smallest = array[i];
            int indexOfSmallest = i;

            // find the smallest
            for (int o=i; o<array.length; o++) {
                if (array[o].compareTo(smallest) < 0) {
                    smallest = array[o];
                    indexOfSmallest = o;
                }
            }

            // swap
            String temp = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = temp;
        }
    }
}