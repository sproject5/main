package prj5;

public class Attribute 
{
    private HobbyEnum hobby;
    private MajorEnum major;
    private StateEnum state;

    public Attribute(
        String thisHobby,
        String thisState,
        String thisMajor)
    {
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

    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        Attribute others = (Attribute) obj;

        return this.state == others.getState() 
            && this.major == others.getMajor() 
            && this.hobby == others.getHobby(); 
    }

    public boolean compare(Object obj)
    {
        if (obj == null || obj.getClass() != this.getClass())
        {
            return false;
        }
        Attribute others = (Attribute) obj;

        return this.state == others.getState() 
            || this.major == others.getMajor() 
            || this.hobby == others.getHobby(); 
    }

}
