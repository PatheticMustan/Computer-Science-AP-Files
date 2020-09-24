import java.lang.Math;

public class approxEquals {
    public static void main(String[] args) {
        System.out.println("approxEquals(3.95, 4.0, 0.1): " + approxEquals(3.95, 4.0, 0.1));
        System.out.println("approxEquals(3.95, 4.0, 0.001): " + approxEquals(3.95, 4.0, 0.001));
        System.out.println("approxEquals(5, 10, 10): " + approxEquals(5, 10, 10));
        System.out.println("approxEquals(5, 10, 1): " + approxEquals(5, 10, 1));
        System.out.println("approxEquals(6.999, 7, 0.001): " + approxEquals(6.999, 7, 0.001));
        System.out.println("approxEquals(6.999, 7, 0.002): " + approxEquals(6.999, 7, 0.002));
        System.out.println("approxEquals(1/3, 0.333, 0.1): " + approxEquals((double)1/(double)3, 0.333, 0.1));
    }
    
    public static boolean approxEquals(double a, double b, double tolerance) {
        // get the difference of the two, and see if it's less than or equal to the tolerance.
        // a very nice one liner
        // the pdf instructions specifically said <, not <=. Weird.
        return Math.abs(a - b) < Math.abs(tolerance);
    }
}