/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void test_factorial5() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void test_negative_input() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }

    @Test
    public void test_overflow_input() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(20));
    }
}
