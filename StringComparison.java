// Define the custom exception class
class NoMatchException extends Exception {
    public NoMatchException(String message) {
        super(message);
    }
}

public class StringComparison {

    public static void main(String[] args) {
        String inputString = "United States"; // You can change this string to test

        try {
            checkString(inputString);
            System.out.println("String matches 'India'.");
        } catch (NoMatchException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    public static void checkString(String str) throws NoMatchException {
        if (!str.equals("India")) {
            throw new NoMatchException("The string '" + str + "' does not match 'India'.");
        }
    }
}