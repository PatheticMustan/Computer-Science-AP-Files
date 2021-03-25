import java.util.Arrays;
public class Sorting {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] { 5, 4, 3, 2, 1 };
        int[] arr3 = new int[] { 5, 1, 4, 2, 3 };
        int[] arr4 = new int[] { 999 };

        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
        System.out.println(isSorted(arr3));
        System.out.println(isSorted(arr4));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        bubbleSort(arr1);
        bubbleSort(arr2);
        bubbleSort(arr3);
        bubbleSort(arr4);

        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
        System.out.println(isSorted(arr3));
        System.out.println(isSorted(arr4));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
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