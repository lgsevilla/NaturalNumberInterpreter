package naturalnumberinterpreter;

import java.util.List;
import java.util.Scanner;

/**
 * Main entry point for the Natural Number Interpreter.
 * Accepts input from user through terminal, generating possible interpretations
 * and checks whether the input is a valid Greek phone number.
 *
 */
public class NumberInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read user input

        System.out.println("Enter number in blocks, up to 3 digits per block, separated by spaces:"); // Input instructions based on requirements
        String inputLine = scanner.nextLine().trim();

        String[] parts = inputLine.split("\\s+");

        List<String> interpretations = AmbiguityInterpreter.generateInterpretations(parts);

        int count = 1;
        for (String interpretation : interpretations) {
             boolean valid = BasePhoneValidator.isValid(interpretation);
             System.out.println("Interpretation " + count + ": "  + interpretation + " [phone number: " + (valid ? "VALID" : "INVALID") + "]");
             count++;
        }
        // Original interpreter print before ambiguity introduction
        // String interpretedNumber = interpret(parts);


        // System.out.println("Interpreted number sequence: " + interpretedNumber);
        // System.out.println("Phone number: " + (BasePhoneValidator.isValid(interpretedNumber) ? "VALID" : "INVALID")); // Calls on naturalnumberinterpreter.BasePhoneValidator to check the interpreted number
        scanner.close();
    }

    /**
     * Concatenates and checks an array of number blocks.
     * Each individual block should be a string containing 1 to 3 digits.
     *
     * @param parts An array of strings representing numeric blocks.
     * @return A single string formed by concatenating valid blocks.
     * @throws IllegalArgumentException if any block length is less than 1 or more than 3 or contains non-numeric characters.
     */
    public static String interpret(String[] parts) {
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

    /**
     * Checks the input string for validity as a number block that contains 1 to 3 digits.
     *
     * @param input The string to be validated.
     * @return true if the input matches the requirement of 1-3 digits, false otherwise
     */
    private static boolean isValidNumberPart(String input) {
        return input.matches("\\d{1,3}");
    }
}
