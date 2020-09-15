import java.util.Scanner;
import java.lang.Math;

// I should have padded/floored numbers to the 4th place but whatever
// 1         --> 1.0000
// 1.2345678 --> 1.2345
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
        
        // we have a penapple
        // x = (-b +- sqrt((b*b) - (4*a*c))) / (2 * a)
        
        // HUUUU ("UH" backwards)
        // pen
        // (-b + sqrt((b*b) - (4*a*c))) / (2 * a)
        // apple
        // (-b - sqrt((b*b) - (4*a*c))) / (2 * a)
        
        // check if the discrim is <0
        
        double discrim = (b*b) - (4*a*c);
        
        if (discrim < 0) { // we're going to have complex answers
            // haha cheese go pppffffft
            // +"" is the fastest way to convert the double into a string
            String numberPart = (-b / (2 * a)) + "";
            String complexPart = ((Math.sqrt(discrim * -1) / (2 * a))+ "i");
            
            System.out.println(
                "Solutions are " +
                (numberPart + " + " + complexPart) + // I really wish Java had something like template literals
                " and " +
                (numberPart + " - " + complexPart)
            );
        } else { // normal answers, thank you very much
            System.out.println(
                "Solutions are " +
                ((-b + Math.sqrt((b*b) - (4*a*c))) / (2 * a)) +
                " and " +
                ((-b - Math.sqrt((b*b) - (4*a*c))) / (2 * a))
            );
        }
    }
}