package org.incubyte;

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
}
