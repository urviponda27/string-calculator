package org.incubyte;

public class StringCalculator {
    public static final String COMMA = ",";
    public static final String EMPTY_STRING = "";

    //Calculate the sum of numbers from one or more input strings.
    public static String calculateSum(String... input)
    {
        return null;
    }
    public static String calculateSum(String input) {
       if (input.equals(EMPTY_STRING)) {
        return "0";
     }
        return addAllNumbers(input.split(COMMA));
    }
     // Add all numbers in the given string array and return the sum as a string.
    private static String addAllNumbers(String[] numbers) {
        int sum = 0;
        for (String numberString : numbers) {
            sum = sum + Integer.valueOf(numberString);
        }
        return String.valueOf(sum);
    }
}
