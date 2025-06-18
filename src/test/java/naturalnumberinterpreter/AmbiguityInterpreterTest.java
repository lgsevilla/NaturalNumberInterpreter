package naturalnumberinterpreter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AmbiguityInterpreterTest {

    @Test
    void singleValidInterpretationTest() {
        String[] input = {"2", "10", "6", "9", "30", "6", "6", "4"};
        List<String> results = AmbiguityInterpreter.generateInterpretations(input);

        System.out.println("Generated interpretations: " + results);
        assertTrue(results.contains("2106930664"));
        assertTrue(results.contains("210693664"));
    }

    @Test
    void multipleValidInterpretationsTest() {
        String[] input = {"2", "10", "69", "30", "6", "6", "4"};
        List<String> results = AmbiguityInterpreter.generateInterpretations(input);

        System.out.println("Generated interpretations: " + results);
        assertTrue(results.contains("2106930664"));
        assertTrue(results.contains("210693664"));
        assertTrue(results.contains("2106093664"));
        assertTrue(results.contains("21060930664"));
    }

    @Test
    void validAndInvalidInterpretationComplexTest() {
        String[] input = {"0", "0", "30", "69", "700", "24", "1", "3", "50", "2"};
        List<String> results = AmbiguityInterpreter.generateInterpretations(input);

        System.out.println("Generated interpretations: " + results);
        assertTrue(results.contains("00306972413502")); // Will appear because this is maximum possible for 0030 beginning digits
        assertTrue(results.contains("0030697241352")); // Will still appear because it starts with 0030 and is less than 14 digits
    }
}
