package naturalnumberinterpreter;

import java.util.*;

public class AmbiguityInterpreter {

    public static List<String> generateInterpretations(String[] inputParts) {
        Set<String> results = new LinkedHashSet<>();
        explore(new ArrayList<>(), inputParts, 0, results);
        return new ArrayList<>(results);
    }

    private static void explore(List<String> path, String[] parts, int index, Set<String> results) {
        if (index >= parts.length) {
            String joined = String.join("", path).replaceAll("\\s", "").trim();

            if (joined.length() > 14 || !joined.matches("\\d*")) {
                return;
            }

            System.out.println("Exploring: " + path);
            results.add(joined);
            return;
        }

        String current = parts[index];

        // Case 1: Use block as-is
        List<String> path1 = new ArrayList<>(path);
        path1.add(current);
        explore(path1, parts, index + 1, results);

        // Case 2: Merge hundreds block with next two-digit block (e.g., 700 + 24 = 724)
        if (index < parts.length - 1) {
            try {
                int currentNum = Integer.parseInt(parts[index]);
                int nextNum = Integer.parseInt(parts[index + 1]);
                if (currentNum % 100 == 0 && currentNum >= 100 && currentNum <= 900 &&
                    nextNum >= 1 && nextNum <= 99) {
                    int combined = currentNum + nextNum;
                    List<String> path2 = new ArrayList<>(path);
                    path2.add(String.valueOf(combined));
                    explore(path2, parts, index + 2, results);
                }
            } catch (NumberFormatException ignored) {}
        }

        // Case 3: Split two-digit or hundreds into parts
        try {
            int num = Integer.parseInt(current);
            if (num >= 20 && num < 100) {
                int tens = (num / 10) * 10;
                int ones = num % 10;
                if (ones > 0) {
                    List<String> path3 = new ArrayList<>(path);
                    path3.add(String.valueOf(tens));
                    path3.add(String.valueOf(ones));
                    explore(path3, parts, index + 1, results);
                }
            } else if (num >= 100 && num < 1000) {
                int hundreds = (num / 100) * 100;
                int rest = num % 100;
                if (rest > 0) {
                    List<String> path4 = new ArrayList<>(path);
                    path4.add(String.valueOf(hundreds));
                    path4.add(String.valueOf(rest));
                    explore(path4, parts, index + 1, results);
                }
            }
        } catch (NumberFormatException ignored) {}

        // Case 4: Merge with next block if possible (e.g. 30 + 6 = 306)
        if (index < parts.length - 1) {
            try {
                String merged = parts[index] + parts[index + 1];
                if (merged.length() <= 3 && merged.matches("\\d+")) {
                    List<String> path5 = new ArrayList<>(path);
                    path5.add(merged);
                    explore(path5, parts, index + 2, results);
                }
            } catch (NumberFormatException ignored) {}
        }

        // Case 5: Merge two blocks into a two-digit number (e.g. 30 + 6 = 36)
        if (index < parts.length - 1) {
            try {
                int first = Integer.parseInt(parts[index]);
                int second = Integer.parseInt(parts[index + 1]);

                int merged = first + second;
                if (merged >= 20 && merged < 100) {
                    List<String> path6 = new ArrayList<>(path);
                    path6.add(String.valueOf(merged));
                    explore(path6, parts, index + 2, results);
                }

            } catch (NumberFormatException ignored) {}
        }
    }
}