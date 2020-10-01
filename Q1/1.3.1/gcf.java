public class gcf {
    public static void main(String[] args) {
        int[][] testCases = {
            {6, 8}, // 2
            {3, 15}, // 3
            {39, 91}, // 13
            {1, 350}, // 1
            {100, 8675309}, // 1
            {83, 83}, // 83
            {64, 128} // din asked me for this test
        };
        
        for (int[] testCase : testCases) {
            // ew why is this so long
            System.out.println("gcf(" + testCase[0] + ", " + testCase[1] + "): " + gcf(testCase[0], testCase[1]));
        }
    }
    
    public static int gcf(int a, int b) {
        // https://en.wikipedia.org/wiki/Euclidean_algorithm
        // advanced version, after looking at the wikipedia page
        return b==0? a : gcf(b, a % b);
    }
}