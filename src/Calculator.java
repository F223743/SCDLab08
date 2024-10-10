public class Calculator {
    
    // Addition with input validation
    public int addition(int num1, int num2) {
        if (isValidInput(num1, num2)) {
            return num1 + num2;
        } else {
            System.out.println("Invalid input: Numbers must be non-negative integers.");
            return -1;
        }
    }

    // Multiplication with input validation
    public int multiplication(int num1, int num2) {
        if (isValidInput(num1, num2)) {
            return num1 * num2;
        } else {
            System.out.println("Invalid input: Numbers must be non-negative integers.");
            return -1;
        }
    }

    // Validation method for non-negative integers
    private boolean isValidInput(int num1, int num2) {
        return num1 >= 0 && num2 >= 0;
    }
}