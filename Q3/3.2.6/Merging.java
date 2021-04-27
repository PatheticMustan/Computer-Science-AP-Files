import java.util.*;

// a battle field, littered with the System.out.println's I used to debug
public class Merging {
    // global temp
    private static int[] temp;

    public static void main(String[] args) {
        int[] data = {3, 1, 4, 2, 3, 5, 7, 9, 1, 1, 3, 4, 6, 6, 2, 9, 4};
        //temp = new int[data.length];
        //merge(data, 3, 7, 8, 13);
        mergeSort(data);
        System.out.println(Arrays.toString(data));

        //int[] data1 = {9, 5};
        //temp = new int[data1.length];
        //merge(data1, 0, 0, 1, 1);
        //System.out.println(Arrays.toString(data1));
    }
    
    // preconditions: the sections array[startIndex1] to array[endIndex1]
    // and array[startIndex2] to array[endIndex2] are already sorted
    // startIndex2 == endIndex1 + 1
    private static void merge(int[] array, int startIndex1, int endIndex1, int startIndex2, int endIndex2) {
        int index1 = startIndex1;
        int index2 = startIndex2;
        int len = endIndex2 - startIndex1 + 1;

        for (int i=0; i<len; i++) {
            int n = startIndex1 + i;

            // ind1 is spent, start using ind2
            if (index1 > endIndex1) {
                temp[n] = array[index2++];
                //System.out.println("ind1 is filled up");
            }
            // ind2 is spent, start using ind1
            else if (index2 > endIndex2) {
                temp[n] = array[index1++];
                //System.out.println("ind2 is filled up");
            }
            // I'm genuinely sorry for the god awful formatting. Newlines before else/elseif?!?!
            else {
                //System.out.println("dice");
                if (array[index1] <= array[index2]) {
                    temp[n] = array[index1++];
                } else {
                    temp[n] = array[index2++];
                }
            }

            //System.out.println(Arrays.toString(temp));
        }
        
        //System.out.println("no more fun: " + Arrays.toString(temp));

        // copy it over
        for (int i=0; i<len; i++) {
            int n = startIndex1 + i;
            array[n] = temp[n];
        }
    }
    
    
    
    public static void mergeSort(int[] array) {
        // instantiate the static temp array to the same length as the array to be sorted
        temp = new int[array.length];
        
        // call the other mergeSort method, passing it the array, along with the first and last index of the array
        mergeSort(array, 0, array.length-1);
    }
    
    public static void mergeSort(int[] array, int start, int end) {
        int start1 = start,
            end1 = start + ((end-start)/2),
            start2 = end1 + 1,
            end2 = Math.max(start2, end); // workaround for when start2 > end2????!?!?!
        
        // i hate mergesort
        //System.out.println("s1: " + start1 + ",     e1: " + end1 + ",     s2: " + start2 + ",     e2: " + end2);
        
        // if there are only two items
        if (start1 == end1 && start2 == end2) {
            // just merge them
            merge(array, start1, end1, start2, end2);
        } else {
            // otherwise, recurse.
            // mergesort two branches, then merge
            mergeSort(array, start1, end1);
            mergeSort(array, start2, end2);
            merge(array, start1, end1, start2, end2);
        }
    }
}