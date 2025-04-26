public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        try {
            System.out.println("Starting the try block");
            int result = divide(10, 0); // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line will not be reached
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed regardless of exception.");
        }

        System.out.println("Program continues after try-catch-finally.");
    }

    // The 'throws' keyword indicates that this method might throw an ArithmeticException
    public static int divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            // The 'throw' keyword is used to explicitly throw an exception
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}