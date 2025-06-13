package naturalnumberinterpreter;

import java.util.Scanner;

public class NumberInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read user input

        System.out.println("Enter number in blocks, up to 3 digits per block, separated by spaces:"); // Input instructions based on requirements
        String inputLine = scanner.nextLine().trim();

        String[] parts = inputLine.split("\\s+");

        String interpretedNumber = interpret(parts);

        System.out.println("Interpreted number sequence: " + interpretedNumber);
        System.out.println("Phone number: " + (BasePhoneValidator.isValid(interpretedNumber) ? "VALID" : "INVALID")); // Calls on naturalnumberinterpreter.BasePhoneValidator to check the interpreted number
        scanner.close();
    }

    private static String interpret(String[] parts) {
        // Validate sequence
        for (String part : parts) {
            if (!isValidNumberPart(part)) {
                // Old print line, changed to throw error to allow for testing
                // System.out.println("Invalid input: \"" + part + "\". Only 1 to 3 digit numbers allowed.");
                throw new IllegalArgumentException("Invalid input: \"" + part + "\". Only 1 to 3 digit numbers allowed.");
            }
        }

        // If all inputs are valid, concatenate
        StringBuilder fullNumber = new StringBuilder();
        for (String part : parts) {
            fullNumber.append(part);
        }

        return fullNumber.toString();
    }

    private static boolean isValidNumberPart(String input) {
        return input.matches("\\d{1,3}");
    }
}
