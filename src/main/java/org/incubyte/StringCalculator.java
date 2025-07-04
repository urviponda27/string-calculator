package org.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

/*
   Adds numbers from the input string.
   Supports:
   - Default delimiter (comma)
   - New lines
   - Custom single-character or multi-character delimiters
   Throws exception if any negative numbers are found.
   Ignores numbers greater than 1000.
*/
public class StringCalculator {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY_STRING = "";

    /*
        Adds numbers from the input string.
        Returns 0 if the input is empty.
    */
    public static int add(String input) {
        if (input.equals(EMPTY_STRING)) {
            return 0;
        }

        String delimiter = COMMA;
        String numbers = input;

        // Check if custom delimiter is specified at the start
        if (input.startsWith("//")) {
            int index = input.indexOf(NEW_LINE);
            delimiter = input.substring(2, index);

            // If the delimiter is wrapped in [ ], strip the brackets
            if (delimiter.startsWith("[") && delimiter.endsWith("]")) {
                delimiter = delimiter.substring(1, delimiter.length() - 1);
            }

            numbers = input.substring(index + 1);
        }

        // Replace all new lines with the delimiter
        String normalized = numbers.replace(NEW_LINE, delimiter);

        /*
            Split the string by the chosen delimiter safely,
            parse each to integer,
            ignore numbers > 1000,
            check for negatives,
            sum the rest.
        */
        List<Integer> numberList = Arrays.stream(normalized.split(Pattern.quote(delimiter)))
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
