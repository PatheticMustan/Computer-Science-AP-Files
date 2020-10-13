public class primeFactorizationCodeGolfed {
    public static void main(String[] args) {
        int[] testCases = { 42, 12, 65536, 8675309 };
        
        for (int testCase : testCases) {
            System.out.println("primeFactor(" + testCase + "): " + primeFactor(testCase));
        }
    }
    
    public static String primeFactor(int n) {
        // codegolfed!
        for (int i=2; i<=n; i++) {
            double res = (double)n / i;
            
            if (res%1==0) return i+" "+(res!=1?primeFactor((int)res):"");
        }
        
        return "";
    }
}