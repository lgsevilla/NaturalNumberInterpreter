import java.util.Scanner;

public class NumberInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read user input

        System.out.println("Enter number in blocks, up to 3 digits per block, separated by spaces:"); // Input instructions based on requirements
        String inputLine = scanner.nextLine().trim();

        String[] parts = inputLine.split("\\s+");

        // Validate sequence
        for (String part : parts) {
            if (!isValidNumberPart(part)) {
                System.out.println("Invalid input: \"" + part + "\". Only 1 to 3 digit numbers allowed.");
                scanner.close();
                return;
            }
        }

        // If all inputs are valid, concatenate
        StringBuilder fullNumber = new StringBuilder();
        for (String part : parts) {
            fullNumber.append(part);
        }

        String interpretedNumber = fullNumber.toString();
        System.out.println("Interpreted number sequence: " + interpretedNumber);
        System.out.println("Phone number: " + (BasePhoneValidator.isValid(interpretedNumber) ? "VALID" : "INVALID")); // Calls on BasePhoneValidator to check the interpreted number
        scanner.close();
    }

    private static boolean isValidNumberPart(String input) {
        return input.matches("\\d{1,3}");
    }
}
