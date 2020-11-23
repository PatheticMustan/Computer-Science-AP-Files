public class capitalize {
    public static void main(String[] args) {
        String[] testCases = { "bobby", "ILENE", "yOU-tUbER", "l33t haXXor", "3-Point shot", "p", "" };
        
        for (String test : testCases) {
            System.out.println("capitalize(\"" + test + "\"): \"" + capitalize(test) + "\"");
        }
    }
    
    public static String capitalize(String str) {
        char[] ca = str.toLowerCase().toCharArray();
        if (ca.length > 0) {
            ca[0] = Character.toUpperCase(ca[0]);
        }
        return String.valueOf(ca);
        
        // codegolf version:
        // return str.length()>0?(str.charAt(0)+"").toUpperCase()+str.substring(1).toLowerCase():"";
    }
}