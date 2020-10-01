public class gcf {
    public static void main(String[] args) {
        int[][] testCases = {
            {6, 8}, // 2
            {3, 15}, // 3
            {39, 91}, // 13
            {1, 350}, // 1
            {100, 8675309}, // 1
            {83, 83}, // 83
            {64, 128}, // din asked me for this test
            {69, 420} // nice
        };
        
        for (int[] testCase : testCases) {
            // ew why is this so long
            System.out.println("gcf(" + testCase[0] + ", " + testCase[1] + "): " + gcf(testCase[0], testCase[1]));
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
}