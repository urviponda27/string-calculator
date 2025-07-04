package org.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

    /*
       Adds numbers from the input string.
       Supports default delimiter (comma), new lines, and custom single-character delimiters.
       Throws exception if any negative numbers are found.
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

        // Split the normalized string by the chosen delimiter,
        // convert each number to an integer,
        // and collect them into a list for further processing.
        List<Integer> numberList = Arrays.stream(normalized.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Find all negative numbers in the list.
        List<Integer> negatives = numberList.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        // If any negative numbers are found, throw an exception listing them.
        if (!negatives.isEmpty()) {
            String negativesString = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            throw new IllegalArgumentException("negatives not allowed: " + negativesString);
        }

        // If no negatives, sum up all numbers and return the total.
        return numberList.stream().mapToInt(Integer::intValue).sum();

    }
}
