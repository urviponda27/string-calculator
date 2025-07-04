package org.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
   Adds numbers from the input string.
   Supports:
   - Default delimiter (comma)
   - New lines
   - Custom single/multi-character delimiters
   - Multiple delimiters
   Throws exception if any negative numbers are found.
   Ignores numbers greater than 1000.
*/
public class StringCalculator {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY_STRING = "";

    public static int add(String input) {
        if (input.equals(EMPTY_STRING)) {
            return 0;
        }

        String delimiter = COMMA;
        String numbers = input;

        if (input.startsWith("//")) {
            int index = input.indexOf(NEW_LINE);
            String delimiterPart = input.substring(2, index);

            // If multiple delimiters (e.g., [*][%][##])
            if (delimiterPart.startsWith("[") && delimiterPart.contains("][")) {
                String[] delimiters = delimiterPart.substring(1, delimiterPart.length() - 1).split("]\\[");
                delimiter = Arrays.stream(delimiters)
                        .map(Pattern::quote) // escape regex special chars
                        .collect(Collectors.joining("|")); // join with regex OR
            }
            // Single multi-char delimiter: [***]
            else if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                delimiter = Pattern.quote(delimiterPart.substring(1, delimiterPart.length() - 1));
            }
            // Single-char delimiter: ;
            else {
                delimiter = Pattern.quote(delimiterPart);
            }

            numbers = input.substring(index + 1);
        }

        String normalized = numbers.replace(NEW_LINE, COMMA);

        /*
            Use regex to split by multiple delimiters if needed,
            parse numbers,
            filter > 1000,
            check negatives,
            sum up.
         */
        List<Integer> numberList = Arrays.stream(normalized.split(delimiter))
                .map(Integer::parseInt)
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());

        List<Integer> negatives = numberList.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            String negativesString = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException("negatives not allowed: " + negativesString);
        }

        return numberList.stream().mapToInt(Integer::intValue).sum();
    }
}
