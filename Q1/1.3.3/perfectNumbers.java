import java.lang.*;

public class perfectNumbers {
    public static void main(String[] args) {
        for (int i=2; i<50000000; i+=2) {
            boolean result = isPerfect(i);
            
            if (result) System.out.println("isPerfect(" + i + "): " + result);
            
            
            int percentageCount = 50000000 / 100;
            if (i % percentageCount == 0) System.out.println((i/percentageCount) + "% searched.");
            
            // after running it for a few minutes, here are the results!
            // I instantly found the first four, at 6, 28, 496, and 8128.
            // When the search reached 67%, I found 33550336
        }
    }
    
    public static boolean isPerfect(int n) {
        int sum = 0;
        
        for (int i=2; i<Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + (n/i);
            }
        }
        
        return sum+1 == n;
    }
}