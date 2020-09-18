import java.util.Scanner;
import java.util.Arrays;

public class SortSortRealSmooth { // cha-cha intensifies
    public static void main(String[] args) {
        // sort n amount of items.
        int inputAmount = 3;

        // init scanner
        Scanner sc = new Scanner(System.in);
        
        // get input
        String[] inputStrings = new String[inputAmount];
        for (int i=0; i<inputAmount; i++) {
            System.out.println("Enter string #" + (i+1) + ": ");
            inputStrings[i] = sc.nextLine();
        }
        
        // we're sorting Strings, yee-haw :cowboy: YEEEEEEEEEEEEEEEEEEE HAWWWWWWWWWW
        // I think the name of this one is called Bubble sort.... I think???????
        for (int i=0; i<inputAmount; i++) {
            for (int o=0; o<inputAmount-1; o++) {
                // if string[o] > string[o+1]....
                if (inputStrings[o].compareTo(inputStrings[o+1]) > 0) {
                    // swap 'em
                    // I remember this really cool way to swap two things in an array without a temp variable,
                    // but it only works for numbers
                    String temp = inputStrings[o];
                    inputStrings[o] = inputStrings[o+1];
                    inputStrings[o+1] = temp;
                }
            }
        }
        
        // Arrays.toString, why do we need a helper function just to convert an array to a readable format???
        System.out.println(Arrays.toString(inputStrings));
    }
}