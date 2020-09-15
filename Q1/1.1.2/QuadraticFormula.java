import java.util.Scanner;

public class QuadraticFormula {
  public static void main(String[] args) {
    // create scanner for user input
    Scanner sc = new Scanner(System.in);
    
    // get input (a, b, c)
    System.out.println("Enter A: ");
    double a = sc.nextDouble();
    
    System.out.println("Enter B: ");
    double b = sc.nextDouble();
    
    System.out.println("Enter C: ");
    double c = sc.nextDouble();
    
    // x = (-b +- sqrt((b*b) - (4*a*c))) / (2 * a)
    // (-b + sqrt((b*b) - (4*a*c))) / (2 * a)
    // (-b - sqrt((b*b) - (4*a*c))) / (2 * a)
  }
}