package naturalnumberinterpreter;

public class BasePhoneValidator {
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
