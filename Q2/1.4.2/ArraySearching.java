import java.util.Random;
import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args) {
        Random rand = new Random();
        
        int[][] testCases = {
            {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}
        };
        
        for (int i=0; i<100; i++) {
            int[] array = testCases[rand.nextInt(testCases.length)];
            int key = rand.nextInt(10);
            
            System.out.println("search(" + Arrays.toString(array) + ", " + key + "): " + search(array, key));
        }
        
        System.out.println("\n\n\n\n\n");
        
        for (int i=0; i<100; i++) {
            int[] array = testCases[rand.nextInt(testCases.length)];
            int key = rand.nextInt(10);
            int startIndex = rand.nextInt(array.length);
            
            System.out.println("search(" + Arrays.toString(array) + ", " + key + ", " + startIndex + "): " + search(array, key, startIndex));
        }
    }
    
    public static int search(int[] array, int key) {
        return search(array, key, 0);
    }
    
    public static int search(int[] array, int key, int startIndex) {
        for (int i=startIndex; i<array.length; i++) {
            if (array[i] == key) return i;
        }
        return -1;
    }
}