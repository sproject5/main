// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin, drewp24

package prj5;

/**
 *  
 * This class tests the Attribute constructor and methods
 *
 * @author Drew Pompeii (drewp24)
 * @version 04/17/2019
 */
public class AttributeTest extends student.TestCase {
    private Person person;
    private SongList<Song> list;
    private Attribute attribute;


    /**
     * Sets up the test class.
     */
    public void setUp() {
        list = new SongList<Song>();
        attribute = new Attribute("sports", "Northeast", "Computer Science");
        person = new Person(list, "sports", "Northeast", "Computer Science", 0);
    }


    /**
     * Tests that a person's hobby is correctly given.
     */
    public void testGetHobby() {
        assertEquals(HobbyEnum.SPORTS, person.getHobby());
    }


    /**
     * Tests that the different types of enums are correctly given.
     */
    public void testGetEnums() {
        Person person2 = new Person(list, "art", "Outside of United States",
            "Math or CMDA", 0);
        assertEquals(HobbyEnum.ART, person2.getHobby());
        assertEquals(StateEnum.OUTSIDE_THE_US, person2.getState());
        assertEquals(MajorEnum.MATH_OR_CMDA, person2.getMajor());
    }


    /**
     * Tests that the different types of enums are correctly given.
     */
    public void testGetEnums2() {
        Person person2 = new Person(list, "reading", "Southeast", "Other", 0);
        assertEquals(HobbyEnum.READ, person2.getHobby());
        assertEquals(StateEnum.SOUTHEAST_US, person2.getState());
        assertEquals(MajorEnum.OTHER, person2.getMajor());
    }


    /**
     * Tests that the different types of enums are correctly given.
     */
    public void testGetEnums3() {
        Person person2 = new Person(list, "music",
            "United States (other than Southeast or Northwest)",
            "Other Engineering", 0);
        assertEquals(HobbyEnum.MUSIC, person2.getHobby());
        assertEquals(StateEnum.THE_REST_OF_US, person2.getState());
        assertEquals(MajorEnum.OTHER_ENGE, person2.getMajor());
    }


    /**
     * Tests that the different types of enums are null.
     */
    public void testGetEnumsNull() {
        Person person2 = new Person(list, "null", "error", "test", 0);
        assertNull(person2.getHobby());
        assertNull(person2.getState());
        assertNull(person2.getMajor());
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

}
