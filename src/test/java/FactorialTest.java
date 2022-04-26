import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @Test
    public void shouldReturnOneIfTheNumberIsZero() {
        Factorial factorial = new Factorial();
        int actualresult = factorial.findFactorial(0);
        int expectedresult = 1;
        assertEquals(expectedresult,actualresult);

    }
    @Test
    public void shouldReturnZeroIfTheNumberIsNegative() {
        Factorial factorial = new Factorial();
        int actualresult = factorial.findFactorial(-8);
        int expectedresult =0;
        assertEquals(actualresult,expectedresult);
    }
    @Test
    public void shouldReturnTheFactorialOfTheNumber() {
        Factorial factorial = new Factorial();
        int actualresult = factorial.findFactorial(3);
        int expectedresult =6;
        assertEquals(actualresult,expectedresult);
    }
}
