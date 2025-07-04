package org.incubyte;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void emptyStringShouldReturnZero() {
        assertThat(StringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void singleNumberShouldReturnItself() {
        assertThat(StringCalculator.add("5")).isEqualTo(5);
    }

    @Test
    public void numbersSeparatedByCommaShouldReturnSum() {
        assertThat(StringCalculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    public void multipleNumbersInOneInputStringShouldBeAdded() {
        assertThat(StringCalculator.add("1,1,2,3")).isEqualTo(7);
    }
    @Test
    public void shouldHandleNewLinesBetweenNumbers() {
        // This input has both \n and , as delimiters → should return 6
        assertThat(StringCalculator.add("1\n2,3")).isEqualTo(6);
    }
    @Test
    public void customSingleCharDelimiterShouldBeSupported() {
        assertThat(StringCalculator.add("//;\n1;2")).isEqualTo(3);
    }
     @Test
    public void negativeNumbersShouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> StringCalculator.add("1,-2,3,-4")
        );

        assertThat(exception.getMessage()).isEqualTo("negatives not allowed: -2,-4");
    }
}
