import java.util.*;

public class Merging {
    // global temp
    private static int[] temp;

    public static void main(String[] args) {
        int[] data = {3, 1, 4, 2, 3, 5, 7, 9, 1, 1, 3, 4, 6, 6, 2, 9, 4};
        temp = new int[data.length];
        merge(data, 3, 7, 8, 13);
        System.out.println(Arrays.toString(data));
    }
    
    // preconditions: the sections array[startIndex1] to array[endIndex1]
    // and array[startIndex2] to array[endIndex2] are already sorted
    // startIndex2 == endIndex1 + 1
    private static void merge(int[] array, int startIndex1, int endIndex1, int startIndex2, int endIndex2) {
        int n = 0;

        //start
        for (; n<startIndex1; n++) {
            temp[n] = array[n];
        }

        // in between
        int e = endIndex2 - startIndex1 + 1;
        for (; n<e; n++) {
            // index1 is done, add index2
            if (startIndex1 == endIndex1) {
                temp[n] = array[startIndex2++];
            }
            // index2 is done, add index1
            else if (startIndex2 == endIndex2) {
                temp[n] = array[startIndex1++];
            } else {
                // if neither are done, compare the next items and add it up
                if (array[startIndex1] < array[startIndex2]) {
                    // index1 is greater, add index1
                    temp[n] = array[startIndex1++];
                } else {
                    // index2 is greater, add index2
                    temp[n] = array[startIndex2++];
                }
            }
        }

        // end
        for (; n<array.length; n++) {
            temp[n] = array[n];
        }

        // finally, copy it over
        for (int i=0; i<array.length; i++) {
            array[i] = temp[i];
        }
    }
}