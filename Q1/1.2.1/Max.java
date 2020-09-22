import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        // maybe you want 400 numbers?
        int numbersToAskFor = 4;
        // haha see what I did there? int-put? input? haw haw?
        int[] intput = new int[numbersToAskFor];
        
        // inst scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter " + numbersToAskFor + " integers, separated by spaces: ");
        for (int i=0; i<numbersToAskFor; i++) {
            intput[i] = sc.nextInt();
        }
        
        System.out.println("The max number is: " + max(intput));
        System.out.println("The min number is: " + min(intput));
    }
    
    public static int max(int[] numbers) {
        // maybe we should verify numbers.length>0 before using numbers[0]???
        int max = numbers[0];
        
        for (int n : numbers) {
            if (n > max) {max = n;}
        }
        return max;
    }
    
    public static int min(int[] numbers) {
        int min = numbers[0];
        
        for (int n : numbers) {
            if (n < min) {min = n;}
        }
        return min;
    }
}