package org.incubyte;

import java.util.Arrays;

public class StringCalculator {
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";

    /*
      This method takes a string of numbers separated by commas and returns their sum.
      If the input string is empty, it returns 0.
     */
    public static int add(String input) {
        if (input.equals(EMPTY_STRING)) {
            return 0;
        }

        /*
          Split the input string by comma, convert each part to an integer,
          and sum up all the integers using Java Streams.
         */
        return Arrays.stream(input.split(COMMA))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
