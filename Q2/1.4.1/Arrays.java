public class Arrays {
    public static void main(String[] args) {
        int[] testMinMax = {8, 6, 7, 5, 3, 0, 9, 0};
        System.out.println("Max of the example numbers: " + max(testMinMax));
        System.out.println("Min of the example numbers: " + min(testMinMax));
        
        int[] testRange = {-3, 8, 2, 17, 9, -3, 12, 0, 4, 11};
        System.out.println("Range of the example numbers: " + range(testRange));
    }
    
    public static int max(int[] array) {
        int maxNumber = array[0];
        for (int n : array) if (n > maxNumber) maxNumber = n;
        return maxNumber;
    }
    public static int min(int[] array) {
        int minNumber = array[0];
        for (int n : array) if (n < minNumber) minNumber = n;
        return minNumber;
    }
    public static int range(int[] array) {
        return max(array) - min(array);
    }
}