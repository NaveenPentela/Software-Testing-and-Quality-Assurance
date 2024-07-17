import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Task 4
 */
public class TestTask4 {
    @Test
    public void testLastIndexOf() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("a");
        assertEquals(2, list.lastIndexOf("a"));
        assertEquals(-1, list.lastIndexOf("c"));
    }

    @Test
    public void testSubList() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("c");
        StringList subList = list.subList(1, 3);
        assertEquals("Printing List: [b, c]", subList.toString());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.subList(3, 1);
        });
        assertEquals("Indices out of order", exception.getMessage());

        Exception exceptionInvalidIndex = assertThrows(IllegalArgumentException.class, () -> {
            list.subList(-1, 3);
        });
        assertEquals("Invalid index", exceptionInvalidIndex.getMessage());

        Exception exceptionInvalidIndex2 = assertThrows(IllegalArgumentException.class, () -> {
            list.subList(1, 4);
        });
        assertEquals("Invalid index", exceptionInvalidIndex2.getMessage());
    }

    @Test
    public void testRemoveRange() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeRange(1, 3);
        assertEquals("Printing List: [a]", list.toString());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.removeRange(3, 1);
        });
        assertEquals("Indices out of order", exception.getMessage());

        Exception exceptionInvalidIndex = assertThrows(IllegalArgumentException.class, () -> {
            list.removeRange(-1, 2);
        });
        assertEquals("Invalid index", exceptionInvalidIndex.getMessage());

        Exception exceptionInvalidIndex2 = assertThrows(IllegalArgumentException.class, () -> {
            list.removeRange(1, 4);
        });
        assertEquals("Invalid index", exceptionInvalidIndex2.getMessage());
    }

    @Test
    public void testEquals() {
        StringList list1 = new StringList();
        list1.add("a");
        list1.add("b");

        StringList list2 = new StringList();
        list2.add("a");
        list2.add("b");

        assertTrue(list1.equals(list2));

        list2.add("c");
        assertFalse(list1.equals(list2));

        // Additional test cases for coverage
        StringList list3 = new StringList();
        list3.add("a");
        list3.add("b");

        StringList list4 = new StringList();
        list4.add("a");
        list4.add("d");

        assertFalse(list1.equals(list4));

        StringList list5 = new StringList();
        list5.add("a");
        list5.add("b");
        list5.add("c");

        assertFalse(list1.equals(list5));
    }

    @Test
    public void testToArray() {
        StringList list = new StringList();
        list.add("a");
        list.add("b");
        String[] array = list.toArray();
        assertArrayEquals(new String[] { "a", "b" }, array);
    }
}
