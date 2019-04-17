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
    private SongList<Song> list;


    /**
     * Sets up the test class.
     */
    public void setUp() {
        list = new SongList<Song>();
        person = new Person(list, "sports", "Northeast", "Computer Science", 0);
    }


    /**
     * Tests that a person's hobby is correctly given.
     */
    public void testGetHobby() {
        assertEquals(HobbyEnum.SPORTS, person.getHobby());
    }


    /**
     * Tests that a person's hobby is incorrect and then
     * kicks out to the default case, which is null.
     */
    public void testGetHobbyNull() {
        Person personNull = new Person(list, "Null", "Northeast",
            "Computer Science", 0);
        assertNull(personNull.getHobby());
    }

 
    /**
     * Tests that a person's state is correctly given.
     */
    public void testGetState() {
        assertEquals(StateEnum.NORTHEAST_US, person.getState());
    }


    /**
     * Tests that a person's state is incorrect and then
     * kicks out to the default case, which is null.
     */
    public void testGetStateNull() {
        Person personNull = new Person(list, "sports", "Error",
            "Computer Science", 0);
        assertNull(personNull.getState());
    }


    /**
     * Test that a person's major is correctly given.
     */
    public void testGetMajor() {
        assertEquals(MajorEnum.CS, person.getMajor());
    }


    /**
     * Tests that a person's major is incorrect and then
     * kicks out to the default case, which is null.
     */
    public void testGetMajorNull() {
        Person personNull = new Person(list, "sports", "Northeast", "Error", 0);
        assertNull(personNull.getMajor());
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


    /**
     * Tests the person's toString method
     */
    public void testToString() {
        assertEquals(person.toString(), "0; Hobby: SPORTS; "
            + "Major: CS; State: NORTHEAST_US");
    }

}
