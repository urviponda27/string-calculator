package org.incubyte;

import java.util.Arrays;

public class StringCalculator {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY_STRING = "";

    /*
         This method takes a string of numbers separated by commas and returns their sum.
         If the input string is empty, it returns 0.
    */
      public static int add(String input) {
        if (input.equals(EMPTY_STRING)) {
            return 0;
        }

        // Replace new lines with commas so we can split by comma only
        String normalized = input.replace(NEW_LINE, COMMA);


        /*
            Split the normalized string by comma,
            convert each part to integer,
            and sum up all integers using streams.
       */
        return Arrays.stream(normalized.split(COMMA))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
