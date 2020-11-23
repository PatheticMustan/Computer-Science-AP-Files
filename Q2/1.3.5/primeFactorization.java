public class primeFactorization {
    public static void main(String[] args) {
        int[] testCases = { 42, 12, 65536, 8675309 };
        
        for (int testCase : testCases) {
            System.out.println("primeFactor(" + testCase + "): " + primeFactor(testCase));
        }
    }
    
    public static String primeFactor(int n) {
        String acc = "";
         
        // find factor
        // if factor, divide los by factor, add to acc
        // if los == 1, remove space at the end
        // else, add los to acc
        for (int i=2; i<=n; i++) {
            if (n % i == 0) {
                acc += i + " ";
                
                if (n / i != 1) acc += primeFactor(n / i);
                
                break;
            }
        }
        
        return acc;
    }
}