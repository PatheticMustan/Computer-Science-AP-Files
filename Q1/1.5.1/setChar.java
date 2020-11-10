import java.lang.*;

public class setChar {
    public static void main(String[] args) {
        // use examples from specs
        String word = "touch";
        System.out.println(word);
        
        word = setChar(word, 3, "g"); //calls String version
        System.out.println(word);
        
        word = setChar(word, 0, 'r'); //calls char version
        System.out.println(word);
        
        word = setChar(word, 4, (char)(word.charAt(4)-3)); //calls char version
        System.out.println(word);
    }
    
    public static String setChar(String str, int index, String ch) {
        char[] letters = str.toCharArray();
            
        letters[index] = ch.charAt(0);
        
        return new String(letters);
    }
    
    public static String setChar(String str, int index, char ch) {
        return setChar(str, index, String.valueOf(ch));
    }
}