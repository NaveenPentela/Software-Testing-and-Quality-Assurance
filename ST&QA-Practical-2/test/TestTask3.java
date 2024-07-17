import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Task 3
 */
public class TestTask3 {
    @Test
    public void testConstructorWithCapacity() {
        StringList list = new StringList(10);
        assertEquals(0, list.size());
    }

    @Test
    public void testAddAtIndex() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add(1, "c");
        assertEquals("Printing List: [a, c, b]", list.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.add(4, "d");
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void testRemoveAtIndex() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertEquals("a", list.remove(0));
        assertEquals("Printing List: [b]", list.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.remove(1);
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void testRemoveElement() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertTrue(list.remove("a"));
        assertFalse(list.remove("c"));
        assertEquals("Printing List: [b]", list.toString());
    }

    @Test
    public void testClearAndIsEmpty() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.clear();
        assertTrue(list.isEmpty());
    }
}
