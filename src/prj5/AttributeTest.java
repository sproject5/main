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
        assertEquals(HobbyEnum.SPORTS, attribute.getHobby());

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
        assertEquals(StateEnum.NORTHEAST_US, attribute.getState());
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
        assertEquals(MajorEnum.CS, attribute.getMajor());
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
     * Tests that the attributes are equal.
     */
    public void testEquals() {
        Attribute attribute2 = new Attribute("sports", "Northeast",
            "Computer Science");
        assertTrue(attribute.equals(attribute2));
    }


    /**
     * Tests that the state attributes are NOT equal.
     */
    public void testEqualsNotEqualState() {
        Attribute attribute2 = new Attribute("sports", "southeast",
            "Computer Science");
        assertFalse(attribute.equals(attribute2));
    }


    /**
     * Tests that the major attributes are NOT equal.
     */
    public void testEqualsNotEqualMajor() {
        Attribute attribute2 = new Attribute("sports", "Northeast", "Other");
        assertFalse(attribute.equals(attribute2));
    }


    /**
     * Tests that the hobby attributes are NOT equal.
     */
    public void testEqualsNotEqualHobby() {
        Attribute attribute2 = new Attribute("reading", "Northeast",
            "Computer Science");
        assertFalse(attribute.equals(attribute2));
    }


    /**
     * Test that an Attribute cannot
     * equal another class, like object.
     */
    public void testEqualsClass() {
        Attribute attribute2 = new Attribute("sports", "southeast",
            "Computer Science");
        Object obj = new Object();
        assertFalse(attribute2.equals(obj));
    }


    /**
     * Tests that an Attribute is null
     */
    public void testEqualsNull() {
        Attribute attributeNull = null;
        assertFalse(attribute.equals(attributeNull));
    }


    /**
     * Compares two attributes and that they are equal.
     */
    public void testCompareAllEqual() {
        Attribute attribute2 = new Attribute("sports", "Northeast",
            "Computer Science");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that they are NOT equal.
     */
    public void testCompareAllFalse() {
        Attribute attribute2 = new Attribute("reading", "Southeast", "Other");
        assertFalse(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that hobby is not equal.
     */
    public void testCompareNot1() {
        Attribute attribute2 = new Attribute("reading", "Northeast",
            "Computer Science");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that hobby and major are not equal.
     */
    public void testCompareNot2() {
        Attribute attribute2 = new Attribute("reading", "Northeast", "Other");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that hobby and state are not equal.
     */
    public void testCompareNot3() {
        Attribute attribute2 = new Attribute("reading", "Northeast",
            "Computer Science");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that state and majors are not equal.
     */
    public void testCompareNot4() {
        Attribute attribute2 = new Attribute("sports", "Southeast", "Other");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that state is not equal.
     */
    public void testCompareNot5() {
        Attribute attribute2 = new Attribute("sports", "Southeast",
            "Computer Science");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Compares two attributes and that major is not equal
     */
    public void testCompareNot6() {
        Attribute attribute2 = new Attribute("sports", "Southeast", "Other");
        assertTrue(attribute.compare(attribute2));
    }


    /**
     * Test that an Attribute cannot
     * compared to another class, like object.
     */
    public void testCompareClass() {
        Attribute attribute2 = new Attribute("sports", "southeast",
            "Computer Science");
        Object obj = new Object();
        assertFalse(attribute2.compare(obj));
    }


    /**
     * Tests that an Attribute cannot be compared to null.
     */
    public void testCompareNull() {
        Attribute attributeNull = null;
        assertFalse(attribute.compare(attributeNull));
    }
}
