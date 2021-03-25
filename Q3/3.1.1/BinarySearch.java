import java.util.Random;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate(10, 3, 20)));
        System.out.println(Arrays.toString(generateSorted(20)));

        int[] test = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i=0; i<10; i++) {
            System.out.println(binarySearch(test, i));
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
    public static int binarySearch(int[] array, int key) {
        int ss = array.length / 2;
        int i = ss;
        
        while (ss != 0) {
            //System.out.println(ss);
            if (array[i] == key) {
                return i;
            } else if (array[i] < key) {
                ss /= 2;
                i += ss;
            } else {
                ss /= 2;
                i -= ss;
            }
        }

        return -1;
    }
}