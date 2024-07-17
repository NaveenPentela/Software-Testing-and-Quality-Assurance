import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Task 1
 */
public class TestTask1 {
    @Test
    public void testAddAndToString() {
        StringList list = new StringList();
        assertEquals("List is empty: []", list.toString());
        list.add("a");
        list.add("b");
        assertEquals("Printing List: [a, b]", list.toString());
    }

    @Test
    public void testGet() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.get(2);
        });
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void testGrow() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e"); // This should trigger the grow method
        assertEquals(5, list.size());
        assertEquals("Printing List: [a, b, c, d, e]", list.toString());
    }

    @Test
    public void testAddAtIndexAndGrow() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(2, "e"); // This should trigger the grow method
        assertEquals(5, list.size());
        assertEquals("Printing List: [a, b, e, c, d]", list.toString());
    }

    @Test
    public void testAddAtIndexAndGrowMultiple() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e"); // This should trigger the grow method
        list.add(2, "f"); // This should trigger the grow method
        assertEquals(6, list.size());
        assertEquals("Printing List: [a, b, f, c, d, e]", list.toString());
    }
}
