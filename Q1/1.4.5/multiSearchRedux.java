import java.util.Arrays;

public class multiSearchRedux {
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4 };
        
        System.out.println("Testing resize: ");
        System.out.println(Arrays.toString(resize(test, 10)));
        System.out.println(Arrays.toString(resize(test, 2)));
        
        System.out.println("\n\n\n");
        System.out.println("Testing multiSearch with resize: ");
        // Instantiate an array containing 10000 elements. Multisearch it for a key of zero. See how long this takes.
        // arrays default to being filled with 0s, I think
        int[] eeeeeee = new int[10000];
        System.out.println(Arrays.toString(multiSearch(eeeeeee, 0)));
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
    
    public static int[] multiSearch(int[] array, int key) {
        // to avoid resizing many times in interest of performance,
        // we can just make a really big array and resize it when we're done.
        int[] result = new int[array.length];
        
        // we need to track how big the resized array should be
        int occ = 0;
        
        // loop over the array, find results
        for (int i=0; i<array.length; i++) {
            if (array[i] == key) {
                // This could be split into result[occ]=i;occ++;, but this looks way cooler
                result[occ++] = i;
            }
        }
        
        // the end should be filled with tons of zeros, so we should resize it.
        return resize(result, occ);
    }
}