package org.incubyte;

import java.util.Arrays;

/**
 * StringCalculator provides a method to add numbers in a string.
 * It supports custom delimiters, new lines, and commas as default delimiters.
 */
public class StringCalculator {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY_STRING = "";

    /*
        Adds numbers from the input string.
        Supports default delimiter (comma), new lines, and custom single-character delimiters.
        Returns 0 if the input is empty.
    */
    public static int add(String input) {
        if (input.equals(EMPTY_STRING)) {
            return 0;
        }

        // Default delimiter is comma
        String delimiter = COMMA;
        String numbers = input;

        // Check if a custom delimiter is specified at the start
        if (input.startsWith("//")) {
            int index = input.indexOf(NEW_LINE);
            delimiter = input.substring(2, index);
            numbers = input.substring(index + 1);
        }

        // Replace all new lines with the chosen delimiter
        String normalized = numbers.replace(NEW_LINE, delimiter);

        /*
            Split the normalized string by the chosen delimiter,
            convert each part to an integer,
            and sum up all integers using streams.
        */
        return Arrays.stream(normalized.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
