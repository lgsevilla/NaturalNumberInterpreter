package naturalnumberinterpreter;

/**
 * BasePhoneValidator checks for valid Greek phone numbers.
 * A string is considered a valid Greek number if it contains 10 digits and starts with 2 (landline) or 69 (mobile),
 * or if it contains 14 digits starting with 00302 (international, landline) or 003069 (international, mobile).
 */
public class BasePhoneValidator {
    /**
     * Validates a number string based on the length and prefix.
     *
     * @param number The phone number as a string.
     * @return true if the number is a valid Greek phone number, false otherwise.
     */
    public static boolean isValid(String number) {
        if (number.length() == 14 && (number.startsWith("00302") || number.startsWith("003069"))) {
            return true; // Checks whether the number is 14 digits because of 0030
        } else if (number.length() == 10 && (number.startsWith("2") || number.startsWith("69"))) {
            return true; // Checks whether the number is 10 digits and starts with 2 or 69
        } else {
            return false;
        }
    }
}

// IntelliJ keeps throwing a simplify Warning
// Could be simplified into a single line with OR and removing the else statement but structured this way for readability
