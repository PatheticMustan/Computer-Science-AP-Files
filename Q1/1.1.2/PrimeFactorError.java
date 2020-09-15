import java.util.Scanner;

public class PrimeFactorError {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter an integer:");
    
    // (int)5 / 2 is 2....???
    // (float)5 / 2 is 2.5 :D
    float userNum = scan.nextInt();
    
    boolean isPrime = true;
    
    for (int factor=2; factor<userNum; factor++) {
      if ((userNum / factor) % 1 == 0) {
        isPrime = false;
        break;
      }
    }
    
    if (isPrime == true) {
      System.out.println((int)userNum + " is prime.");
    } else {
      System.out.println((int)userNum + " is not prime.");
    }
  }
}