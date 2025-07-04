package org.incubyte;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    public void emptyStringShouldReturnZero()
    {
        assertThat(StringCalculator.calculateSum("")).isEqualTo("0");
    } 
    @Test
    public void singleStringShouldReturnItselfAsSum()
     {
    assertThat(StringCalculator.calculateSum("5")).isEqualTo("5");
     }
     @Test
    public void sumOfNumbersSeperatedByCommaShouldReturned()
    {
        assertThat(StringCalculator.calculateSum("1,2,3")).isEqualTo("6");

    }
    @Test
    public void numbersInAnyNumberofInputStringsShouldBeAdded()
    {
        assertThat(StringCalculator.calculateSum("1", "1,2,3", "")).isEqualTo("7");
    }

}
