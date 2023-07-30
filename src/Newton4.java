import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * The program will ask user for a double variable and calculate to square root
 * of the number. After calculation the code should continue asking the user for
 * other input until the user inputs a negative number.
 *
 * @author Zheyuan Gao
 *
 */
public final class Newton4 {
    /*
     * Private constructor
     */
    private Newton4() {
        //not called
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param error
     *            biggest error the user accept
     * @return estimate of square root
     */
    private static double sqrt(double x, double error) {
        final double zero = 0.0;
        //Declare a double variable called r to store the result
        double r;
        // add a if statement to handle the input is 0
        if (x - zero < error) {
            r = zero;
        } else {
            r = x;
            /*
             * set up the loop and it will continue loop if the error is bigger
             * than the error
             */
            while ((r * r - x) / x > error * error) {
                //update the value of r and check it again
                r = (r + x / r) / 2;
            }
        }
        //return the estimation of square root of x
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * ask the user for a double number input
         */
        out.print("Please enter the number been square rootted "
                + "(type negative number to quit): ");
        double userInput = in.nextDouble();
        //if the user input a positive number, the program will proceed
        while (userInput >= 0) {
            out.print("Please input bigget error accepted: ");
            double userChoiceError = in.nextDouble();
            //pass the user number into the method and get the result
            double result = sqrt(userInput, userChoiceError);
            out.println("The estimate square root of " + userInput + " is: "
                    + result);
            //ask the user if they want to calculate another number
            out.print("Please enter the another number been square rootted "
                    + "(type negative number to quit): ");
            userInput = in.nextDouble();
        }
        // the user choose to quit, display goodbye to the user
        out.println("Goodbye");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
