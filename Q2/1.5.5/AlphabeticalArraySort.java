import java.util.*;

public class AlphabeticalArraySort {
    public static void main(String[] args) {
        String[][] testCases = {
            { "A", "car", "drove", "fast" },
            { "A", "cat", "ran", "fast" },
            { "He", "read", "4", "words" },
            { "I'm", "really", "really", "tired" },
            { "tomato" },
            {}
        };
        
        for (String[] test : testCases) {
            System.out.println("isAlphabetical(" + Arrays.toString(test) + "): " + isAlphabetical(test));
        }
    }
    
    public static boolean isAlphabetical(String[] words) {
        for (int i=0; i<words.length-1; i++) {
            if (words[i].compareToIgnoreCase(words[i+1]) > 0) {
                return false;
            }
        }
        
        return true;
    }
}