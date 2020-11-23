import java.util.*;

public class RowStrings {
    public static void main(String[] args) {
        // haha the anime shark said "a"
        char[][] a = {
            {'G','r','e','a','t'},
            {'W','h','i','t','e'},
            {'S','h','a','r','k'}
        };
        
        char[][] aaaaa = {
            {'G','r','e','a','t'},
            {'W','h','i','t','e'},
            {'S','h','a','r','k'},
            {'D','o',' ','d','o'},
            {'D','o',' ','d','o'},
            {'D','o',' ','d','o'}
        };
        
        System.out.println(Arrays.toString(rowStrings(a)));
        System.out.println(Arrays.toString(rowStrings(aaaaa)));
    }
    
    // precondition: characters contains at least 1 row and 1 column
    public static String[] rowStrings(char[][] characters) {
        // the game plan is to convert characters into a big string, then use String.split
        String nat = "";
        
        for (char[] row : characters) {
            for (char letter : row) {
                nat += letter;
            }
            // add a space
            nat += ' ';
        }
        
        return nat.split(" ");
    }
}