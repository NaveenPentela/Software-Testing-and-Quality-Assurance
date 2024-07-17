import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Task 2
 */
public class TestTask2 {
    @Test
    public void testContains() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertTrue(list.contains("a"));
        assertFalse(list.contains("c"));
    }

    @Test
    public void testIndexOf() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertEquals(0, list.indexOf("a"));
        assertEquals(-1, list.indexOf("c"));
    }

    @Test
    public void testSet() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertEquals("a", list.set(0, "c"));
        assertEquals("c", list.get(0));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.set(2, "d");
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void testSize() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertEquals(2, list.size());
    }
}
