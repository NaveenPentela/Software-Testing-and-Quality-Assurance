/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Max3Test {

    @Test
    public void test_max1() {
        assertEquals(9, Max3.max3(9, 3, 4));
    }

    @Test
    public void test_max2() {
        assertEquals(7, Max3.max3(5, 7, 4));
    }

    @Test
    public void test_max3() {
        assertEquals(10, Max3.max3(3, 4, 10));
    }

    @Test
    public void test_equal() {
        assertEquals(5, Max3.max3(5, 5, 5));
    }

    @Test
    public void test_two_equal() {
        assertEquals(8, Max3.max3(8, 8, 7));
    }

    @Test
    public void test_negative_numbers() {
        assertEquals(0, Max3.max3(-1, 0, -2));
    }
}
