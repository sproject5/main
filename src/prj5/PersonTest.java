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
        assertEquals(Hobby.SPORTS, person.getHobby());
        System.out.println(Hobby.SPORTS);
        System.out.println(Hobby.ART);
        System.out.println(Hobby.MUSIC);
        System.out.println(Hobby.READ);
        
        System.out.println(Major.MATH_OR_CMDA);
        System.out.println(Major.OTHER);
        System.out.println(Major.OTHER_ENGE);
        System.out.println(Major.CS);
        
        System.out.println(State.OUTSIDE_THE_US);
        System.out.println(State.SOUTHEAST_US);
        System.out.println(State.NORTHEAST_US);
        System.out.println(State.THE_REST_OF_US);


        
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

    /**
     * Tests the person's toString method
     */
    public void testToString() {
        
        Person test1 = new Person(new SongList<Song>(), "d", "d", "d", 10);
        test1.getHobby()
        assertEquals(person.toString(), "0; Hobby: SPORTS; "
            + "Major: CS; State: NORTHEAST_US");
    }
    
    

}