package org.incubyte;

public class StringCalculator {
    public static final String EMPTY_STRING = "";

    public static String calculateSum(String input) {
       if (input.equals(EMPTY_STRING)) {
        return "0";
     }
        return input;
    }
}
