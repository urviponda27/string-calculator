package org.incubyte;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void emptyStringShouldReturnZero() {
        assertThat(StringCalculator.calculateSum("")).isEqualTo("0");
    } 
   
}
