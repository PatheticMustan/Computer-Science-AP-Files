public class MaxLength {
    public static void main(String[] args) {
        int[][] table = {
            {23, 0, 425, -25},
            {1856, 24601, 7, 92},
            {-3, 18, -2053, 13}
        };
        System.out.println(maxLength(table));
    }
    
    public static int maxLength(int[][] table) {
        int maxLength = 0;
        
        for (int[] row : table) {
            for (int num : row) {
                if (("" + num).length() > maxLength) {
                    maxLength = ("" + num).length();
                }
            }
        }
        
        return maxLength;
    }
}