public class totient {
    public static void main(String[] args) {
        int[][] gcfTestCases = {
            {6, 8}, // 2
            {3, 15}, // 3
            {39, 91}, // 13
            {1, 350}, // 1
            {100, 8675309}, // 1
            {83, 83}, // 83
            {64, 128}, // din asked me for this test
            {69, 420} // nice
        };
        
        for (int[] gcfTestCase : gcfTestCases) {
            // ew why is this so long
            System.out.println("gcf(" + gcfTestCase[0] + ", " + gcfTestCase[1] + "): " + gcf(gcfTestCase[0], gcfTestCase[1]));
        }
        
        int[] totientTestCases = {
            10, // 4
            8, // 4
            24, // 8
            1, // 1
            105, // 48
            8675309 // 8675308
        };
        
        for (int totientTestCase : totientTestCases) {
            System.out.println("totient(" + totientTestCase + "): " + totient(totientTestCase)); 
        }
    }
    
    public static int gcf(int a, int b) {
        // "For the advanced version, your method should return the GCF, but should utilize the Euclidean Algorithm to do it."
        // https://en.wikipedia.org/wiki/Euclidean_algorithm
        // advanced version, after looking at the wikipedia page
        
        // ternary operators work like (condition? true : false). It's very useful for squishing things
        // if (condition) {return trueThing} else {return falseThing}
        // return condition? trueThing : falseThing
        
        // in this case, the full thing should look something like
        // if (b == 0) {
        //     return a;
        // } else {
        //     return gcf(b, a%b);
        // }
        
        // after code go squishhhh...
        return b==0? a : gcf(b, a % b);
    }
    
    public static int totient(int n) {
        int rpc = 0;
        
        // loop through 0-(n-1)
        for (int i=0; i<n; i++) {
            // if it's a totient, add 1 to the count.
            if (gcf(i, n) == 1) rpc++;
        }
        
        return rpc;
    }
}