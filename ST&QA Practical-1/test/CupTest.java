/**
 * STQA PRAC-1
 * Fan ID: pent0020
 * Name: Naveen Pentela
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class CupTest {

    @Test
    @DisplayName("Test Capacity")
    public void test_cap() {
        Cup cupT1 = new Cup(200);
        assertEquals(200, cupT1.getCapacity());
    }

    @Test
    @DisplayName("Test Filling")
    public void test_fill() {
        Cup cupT2 = new Cup(200);
        cupT2.fill(100);
        assertEquals(100, cupT2.getCurrentVolume());
    }

//    @Test
//    @DisplayName("Test Cup constructor with negative capacity")
//    public void test_negative_capacity_constructor() {
//        Cup cup_negative = new Cup(200);
//        cup_negative.fill(100);
//        assertThrows(100, cup_negative.getCurrentVolume());
//    }
    @Test
    @DisplayName("check negative capacity")
    public void testCupConstructorNegativeCap(){
        assertThrows(IllegalArgumentException.class, () -> new Cup(-100));
    }

    @Test
    public void testFillNegativeAmount() {
        Cup cup = new Cup(200);

        assertThrows(IllegalArgumentException.class, () -> cup.fill(-10));
    }

    @Test
    @DisplayName("Test to check Partial Fill")
    public void testPartialFill() {
        Cup cup = new Cup(200);
        cup.fill(100); // Fill to half capacity

        assertFalse(cup.isEmpty(), "Cup should not be empty.");
        assertFalse(cup.isFull(), "Cup should not be full.");
    }

    @Test
    @DisplayName("check zero capacity")
    public void testCupConstructorZeroCap(){
        assertThrows(IllegalArgumentException.class, () -> new Cup(0));
    }

    @Test
    @DisplayName("Test Overfill")
    public void test_over_fill() {
        Cup cupT3 = new Cup(200);
        assertThrows(IllegalArgumentException.class, () -> cupT3.fill(250));
    }

    @Test
    @DisplayName("Test Emptying")
    public void test_empty() {
        Cup cupT4 = new Cup(200);
        cupT4.fill(150);
        cupT4.empty();
        assertEquals(0, cupT4.getCurrentVolume());
    }

    @Test
    @DisplayName("Test Empty Cup")
    public void test_is_Empty() {
        Cup cupT5 = new Cup(200);
        assertTrue(cupT5.isEmpty());
    }
    @Test
    @DisplayName("Test Full Cup")
    public void testIsFull() {
        Cup cupT6 = new Cup(200);
        cupT6.fill(200);

        /** checking whether cup is full or not */

        assertTrue(cupT6.isFull());
    }
}
