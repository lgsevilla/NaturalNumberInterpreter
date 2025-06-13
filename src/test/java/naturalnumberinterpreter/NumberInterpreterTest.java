package naturalnumberinterpreter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberInterpreterTest {

    @Test
    void validInputSingleDigitBlockTest() {
        String[] input = {"1"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("1", result);
    }

    @Test
    void validInputZeroOnlyBlockTest() {
        String[] input = {"0"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("0", result);
    }

    @Test
    void validInputLeadingZeroBlockTest() {
        String[] input = {"01"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("01", result);
    }

    @Test
    void validInputZeroesOnlyBlockTest() {
        String[] input = {"000"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("000", result);
    }

    @Test
    void validInputLeadingZeroesBlockTest() {
        String[] input = {"001"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("001", result);
    }

    @Test
    void validInputSingleBlockTest() {
        String[] input = {"210"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("210", result);
    }

    @Test
    void validInputMultipleBlocksTest() {
        String[] input = {"210", "69", "3"};
        String result = NumberInterpreter.interpret(input);
        assertEquals("210693", result);
    }

    @Test
    void invalidInputLengthySingleBlockTest() {
        String[] input = {"2100"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputNonNumericSingleBlockTest() {
        String[] input = {"abc"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputLengthyLeadingBlockTest() {
        String[] input = {"2100", "69", "306"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputLengthyMiddleBlockTest() {
        String[] input = {"210", "6900", "306"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputLengthyTrailingBlockTest() {
        String[] input = {"210", "69", "3061"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputNonNumericLeadingBlockTest() {
        String[] input = {"abc", "69", "306"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputNonNumericMiddleBlockTest() {
        String[] input = {"210", "abc", "306"};
        Exception except = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(except.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputNonNumericTrailingBlockTest() {
        String[] input = {"210", "69", "abc"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

    @Test
    void invalidInputEmptyBlockTest() {
        String[] input = {""};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> NumberInterpreter.interpret(input));
        assertTrue(exception.getMessage().contains("Invalid input"));
    }

}
