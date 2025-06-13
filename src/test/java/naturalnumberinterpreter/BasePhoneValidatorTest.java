package naturalnumberinterpreter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasePhoneValidatorTest {

    @Test
    void validLocalLandlineTest() {
        String input = "2101234567";
        assertTrue(BasePhoneValidator.isValid(input));
    }

    @Test
    void validLocalCellphoneTest() {
        String input = "6912345678";
        assertTrue(BasePhoneValidator.isValid(input));
    }

    @Test
    void validInternationalLandlineTest() {
        String input = "00302101234567";
        assertTrue(BasePhoneValidator.isValid(input));
    }

    @Test
    void validInternationalCellphoneTest() {
        String input = "00306912345678";
        assertTrue(BasePhoneValidator.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "691234567",            // Local cellphone, too short
            "69123456789",          // Local cellphone, too long
            "6812345678",           // Local cellphone, wrong prefix below
            "7012345678",           // Local cellphone, wrong prefix above
            "0030691234567",        // International cellphone, too short
            "003069123456789",      // International cellphone, too long
            "306912345678",         // International cellphone, missing 00
            "0306912345678",        // International cellphone, single 0
            "00296912345678",       // International cellphone, wrong country code below
            "00316912345678",       // International cellphone, wrong country code above
    })
    void invalidCellphoneNumberTest(String input) {
        assertFalse(BasePhoneValidator.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "210123456",            // Local landline, too short
            "21012345678",          // Local landline, too long
            "1101234567",           // Local landline, wrong prefix below
            "3101234567",           // Local landline, wrong prefix above
            "0030210123456",        // International landline, too short
            "003021012345678",      // International landline, too long
            "302101234567",         // International landline, missing 00
            "0302101234567",        // International landline, single 0
            "00292101234567",       // International landline, wrong country code below
            "00312101234567",       // International landline, wrong country code above
    })
    void invalidLandlineNumberTest(String input) {
        assertFalse(BasePhoneValidator.isValid(input));
    }

}
