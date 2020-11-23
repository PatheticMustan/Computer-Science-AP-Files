public class Password {
    public static void main(String[] args) {
        String[] testCases = { "test", "Password", "Passw0rd", "Passw0!^|>", "loooooooooooooooooooooooooooooNg1!", "s p a c e S1!", "Ss1!" };
        
        for (String test : testCases) {
            System.out.println("isValidPassword(\"" + test + "\"): " + isValidPassword(test));
        }
    }
    
    public static boolean isValidPassword(String password) {
        // be at least 6 characters long
        if (password.length() < 6) return false;
        
        // be no more than 16 characters long
        if (password.length() > 16) return false;
        
        // not contain any spaces
        if (password.contains(" ")) return false;
        
        // contain at least three of the following:
        int cm = 0;
        for (char c : password.toCharArray()) {
            // A capital letter ('A' through 'Z')
            if (c >= 65 && c <= 90) {
                cm++;
                break;
            }
        }
        for (char c : password.toCharArray()) {
            // A lowercase letter ('a' through 'z')
            if (c >= 97 && c <= 122) {
                cm++;
                break;
            }
        }
        for (char c : password.toCharArray()) {
            // A digit ('0' through '9')
            if (c >= 48 && c <= 57) {
                cm++;
                break;
            }
        }
        for (char c : password.toCharArray()) {
            // Any character not fitting the previous 3 categories (i.e. punctuation)
            if (!(c >= 65 && c <= 90) && !(c >= 97 && c <= 122) && !(c >= 48 && c <= 57)) {
                cm++;
                break;
            }
        }
        
        if (cm < 3) return false;
        
        return true;
    }
}