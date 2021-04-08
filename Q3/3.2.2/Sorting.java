import java.util.Arrays;
public class Sorting {
    public static void main(String[] args) {
        int[][] testCases = new int[][] {
            { 1, 2, 3, 4, 5 },
            { 5, 4, 3, 2, 1 },
            { 5, 1, 4, 2, 3 },
            { 999 }
        }
        int[][] testCases1 = new int[][] {
            { 1, 2, 3, 4, 5 },
            { 5, 4, 3, 2, 1 },
            { 5, 1, 4, 2, 3 },
            { 999 }
        }

        /*for (int[] arr : testCases) {
            System.out.println(isSorted(arr));
            System.out.println(Arrays.toString(arr));
            bubbleSort(arr);
            System.out.println(isSorted(arr));
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }

        System.out.println("\n\n\n\n\n\n");*/

        for (int[] arr : testCases1) {
            System.out.println(isSorted(arr));
            System.out.println(Arrays.toString(arr));
            insertionSort(arr);
            System.out.println(isSorted(arr));
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }

    public static boolean isSorted(int[] array) {
        int highest = array[0];
        for (int v : array) {
            if (v < highest) return false;
            highest = v;
        }
        return true;
    }
    public static void bubbleSort(int[] array) {
        for (int i=0; i<array.length-1; i++) {
            for (int o=0; o<array.length-1; o++) {
                if (array[o] > array[o+1]) {
                    int temp = array[o];
                    array[o] = array[o+1];
                    array[o+1] = temp;
                }
            }
        }
    }
    public static void insertionSort(int[] arr) {
        for (int o=1; o<arr.length; o++) {  
            // badcode go wheeeee
            // I looked up a picture of insertion sort

            // shift everything to the right until we find the right place
            int key = arr[o];

            for (int i=o-1; (i==0)&&(arr[i]>arr[o]); i--) {
                arr[i+1] = arr[i];
            }
            // insert the thing into the right place
            arr[i+1] = key;  
        }  
    }

    public static int[] generate(int length, int low, int high) {
        int[] result = new int[length];
        Random randGen = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = randGen.nextInt(high - low + 1) + low;
        }
        return result;
    }
    public static int[] generateSorted(int length) {
        int[] result = new int[length];
        result[0] = 1;
        Random randGen = new Random();

        for (int i=1; i<length; i++) {
            // previous + [0,2]
            result[i] = result[i-1] + randGen.nextInt(3);
        }

        return result;
    }
}