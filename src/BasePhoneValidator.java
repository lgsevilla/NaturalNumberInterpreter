public class BasePhoneValidator {
    public static boolean isValid(String number) {
        if (number.length() == 14 && (number.startsWith("00302") || number.startsWith("003069"))) {
            return true;
        } else if (number.length() == 10 && (number.startsWith("2") || number.startsWith("69"))) {
            return true;
        } else {
            return false;
        }
    }
}
