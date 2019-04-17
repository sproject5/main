
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * @author Eric
 * @author maellis1
 * @version 11-2-15
 *
 */
public class DLListTest extends TestCase {
    /**
     * the list we will use 
     */
    private DLList<String> list; 
    private Iterator<String> ite;
    private Iterator<String> reverse;


    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new DLList<String>();
        ite = list.iterator();
        reverse = list.reverseIterator();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DLList<String> emptyList = new DLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests the next value is properly given.
     */
    public void testNext() {
        list.add("apple");
        list.add("banana");

        assertEquals("apple", ite.next());

    }


    /**
     * Tests that a NoSuchElementException is thrown when
     * there are no nodes left in the list.
     */
    public void testNextException() {
        list.add("apple");
        ite.next();
        Exception e = null;
        try {
            ite.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * Tests that the next element is properly removed.
     */
    public void testRemoveIterator() {
        list.add("apple");
        list.add("orange");
        ite.next();
        ite.remove();
        assertEquals("orange", list.get(0));
    }


    /**
     * Tests that an IllegalStateException is thrown
     * when the next element hasn't been called and
     * the element has already been removed.
     */
    public void testRemoveExceptionIterator() {
        list.add("apple");
        list.add("orange");

        Exception e = null;
        try {
            ite.remove();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalStateException);
    }
    // Reverse DL List testing
    // -----------------------------------------------------------------------


    /**
     * Tests the next value is properly given
     * in a reverse DL List.
     */
    public void testNextReverse() {
        list.add("apple");
        list.add("banana");
        list.add("peach");

        assertEquals("peach", reverse.next());
        assertEquals("banana", reverse.next());
        assertEquals("apple", reverse.next());
        // Exception e = null;
        try {
            reverse.next();
        }
        catch (Exception e) {
            System.out.print(e);
            assertTrue(e instanceof NoSuchElementException);
        }

    }


    /**
     * Tests that a NoSuchElementException is thrown when
     * there are no nodes left in a reverse DL list.
     */
    public void testNextExceptionReverse() {
        list.add("apple");
        reverse.next();
        

        try {
            reverse.next();
        }
        catch (Exception e) {
            System.out.print(e);
            assertTrue(e instanceof NoSuchElementException); 
        }

    }


    /**
     * Tests that the next element is properly removed
     * in a reverse DL List
     */
    public void testRemoveIteratorReverse() {
        list.add("apple");
        list.add("orange");
        reverse.next();
        reverse.remove();
        assertEquals("apple", list.get(0));
    }


    /**
     * Tests that an IllegalStateException is thrown
     * when the next element hasn't been called and
     * the element has already been removed in a reverse DL List.
     */
    public void testRemoveExceptionIteratorReverse() {
        list.add("apple");
        list.add("orange");

        Exception e = null;
        try {
            reverse.remove();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalStateException);
    }

}
