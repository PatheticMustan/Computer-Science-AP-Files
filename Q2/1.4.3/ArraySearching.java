import java.util.Random;
import java.util.Arrays;

public class ArraySearching {
    public static void main(String[] args) {
        Random rand = new Random();
        
        for (int i=0; i<100; i++) {
            int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            
            int key = rand.nextInt(10);
            
            System.out.println("multiSearch(" + Arrays.toString(array) + ", " + key + "): " + Arrays.toString(multiSearch(array, key)));
        }
    }
    
    public static int search(int[] array, int key, int startIndex) {
        for (int i=startIndex; i<array.length; i++) {
            if (array[i] == key) return i;
        }
        return -1;
    }
    
    public static int[] multiSearch(int[] array, int key) {
        int occ = 0;
        
        for (int i=0; i<array.length; i++) if (array[i] == key) occ++;
        
        int[] solutions = new int[occ];
        int soli = 0;
        
        for (int i=0; i<array.length; i++) if (array[i] == key) solutions[soli++] = i;
        
        return solutions;
    }
}