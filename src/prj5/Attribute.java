// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin, drewp24

package prj5;

/**
 * This class holds the attributes of a person.
 *
 * @author Drew Pompeii (drewp24)
 * @version 04/17/2019
 */
public class Attribute {
    private HobbyEnum hobby;
    private MajorEnum major;
    private StateEnum state;


    /**
     * This is the constructor for the Attribute class.
     * 
     * @param thisHobby
     *            the person's hobby
     * @param thisState
     *            the person's state
     * @param thisMajor
     *            the person's major
     */
    public Attribute(String thisHobby, String thisState, String thisMajor) {
        switch (thisHobby) {
            case "reading":
                hobby = HobbyEnum.READ;
                break;
            case "art":
                hobby = HobbyEnum.ART;
                break;
            case "music":
                hobby = HobbyEnum.MUSIC;
                break;
            case "sports":
                hobby = HobbyEnum.SPORTS;
                break;
            default:
                hobby = null;
                break;
        }
        // determines the major
        switch (thisMajor) {
            case "Computer Science":
                major = MajorEnum.CS;
                break;
            case "Math or CMDA":
                major = MajorEnum.MATH_OR_CMDA;
                break;
            case "Other":
                major = MajorEnum.OTHER;
                break;
            case "Other Engineering":
                major = MajorEnum.OTHER_ENGE;
                break;
            default:
                major = null;
                break;
        }

        // determines the state
        switch (thisState) {
            case "Northeast":
                state = StateEnum.NORTHEAST_US;
                break;
            case "Outside of United States":
                state = StateEnum.OUTSIDE_THE_US;
                break;
            case "Southeast":
                state = StateEnum.SOUTHEAST_US;
                break;
            case "United States (other than Southeast or Northwest)":
                state = StateEnum.THE_REST_OF_US;
                break;
            default:
                state = null;
                break;
        }
    }


    /**
     * get the hobby data of the person
     * 
     * @return the hobby data
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * get the major data of the person
     * 
     * @return the major data
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * get the state data of the person
     * 
     * @return the state data
     */
    public StateEnum getState() {
        return state;
    }


    /**
     * Checks equality between two different attributes.
     * 
     * @param obj
     *            the object being passed as an attribute.
     * @return true if the attributes are equal,
     *         false in all other cases.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Attribute others = (Attribute)obj;

        return this.state == others.getState() && this.major == others
            .getMajor() && this.hobby == others.getHobby();
    }


    /**
     * Compares two different attributes.
     * 
     * @param obj
     *            the object being compared to as an attribute.
     * 
     * @return true if the compared attributes are equal,
     *         false in all other cases.
     */
    public boolean compare(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Attribute others = (Attribute)obj;

        return this.state == others.getState() || this.major == others
            .getMajor() || this.hobby == others.getHobby();
    }

}