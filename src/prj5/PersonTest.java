// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import student.TestCase;

/**
 * Tests the Person class.
 *
 * @author Conner Mangin (cmangin)
 * @version 2019.04.14
 */
public class PersonTest extends TestCase {

    private Person person;
    private DLList<Song> list;


    /**
     * Sets up the test class.
     */
    public void setUp() {
        list = new DLList<Song>();
        person = new Person(list, "sports", "Northeast", "Computer Science", 0);
    }


    /**
     * Tests that a person's hobby is correctly given.
     */
    public void testGetHobby() {
        assertEquals(Hobby.SPORTS, person.getHobby());
    }


    /**
     * Tests that a person's state is correctly given.
     */
    public void testGetState() {
        assertEquals(State.NORTHEAST_US, person.getState());
    }


    /**
     * Test that a person's major is correctly given.
     */
    public void testGetMajor() {
        assertEquals(Major.CS, person.getMajor());
    }


    /**
     * Tests that the index of a person is correctly given.
     */
    public void testGetIndex() {
        assertEquals(0, person.getIndex());
    }


    /**
     * Tests that a person's song list is correctly given.
     */
    public void testGetSongList() {
        assertEquals(list, person.getSongList());
    }

}