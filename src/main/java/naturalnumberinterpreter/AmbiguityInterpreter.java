package naturalnumberinterpreter;

import java.util.*;

public class AmbiguityInterpreter {

    public static List<String> generateInterpretations(String[] parts) {
        Set<String> results = new LinkedHashSet<>();
        generateRecursive(results, new ArrayList<>(), parts, 0);
        return new ArrayList<>(results);
    }

    private static void generateRecursive(Set<String> results, List<String> current, String[] parts, int index) {
        if (index >= parts.length) {
            results.add(String.join("", current));
            return;
        }

        List<List<String>> expansions = expandBlock(parts[index]);

        for (List<String> expansion : expansions) {
            List<String> newCurrent = new ArrayList<>(current);
            newCurrent.addAll(expansion);
            generateRecursive(results, newCurrent, parts, index + 1);
        }
    }

    private static List<List<String>> expandBlock(String block) {
        List<List<String>> expansions = new ArrayList<>();
        expansions.add(Collections.singletonList(block)); // Original block

        try {
            int num = Integer.parseInt(block);

            if (num >= 20 && num < 100) { // Example: 69 -> [60, 9]
                int tens = (num / 10) * 10;
                int ones = num % 10;
                if (ones > 0) {
                    expansions.add(Arrays.asList(String.valueOf(tens), String.valueOf(ones)));
                }
            }

            if (num >= 100 && num <= 999) { // Example: 723 -> [700, 23] and [700, 20, 3]
                int hundreds = (num / 100) * 100;
                int tensOnes = num % 100;
                if (tensOnes > 0) {
                    expansions.add(Arrays.asList(String.valueOf(hundreds), String.valueOf(tensOnes)));
                    int tens = (tensOnes / 10) * 10;
                    int ones = tensOnes % 10;
                    if (tens > 0 && ones > 0) {
                        expansions.add(Arrays.asList(String.valueOf(hundreds), String.valueOf(tens), String.valueOf(ones)));
                    }
                }
            }

        } catch (NumberFormatException ignored) {}

        return expansions;
    }
}
