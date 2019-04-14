package prj5;

/**
 * This is the person class
 * store survey data of one person
 */
public class Person {

    private SongList songList;
    private Hobby hobby;
    private Major major;
    private State state;
    private int index;

    public Person(SongList thisSongList, 
        String thisHobby, String thisState, String thisMajor, int thisIndex)
    {

        songList = thisSongList;
        // determines the hobby
        switch (thisHobby) 
        {
            case "reading":
                hobby = Hobby.READ;
                break;
            case "art":
                hobby = Hobby.ART;
                break;
            case "music":
                hobby = Hobby.MUSIC;
                break;
            case "sports":
                hobby = Hobby.SPORTS;
                break;
            default:
                hobby = null;
                break;
        }
        // determines the major
        switch (thisMajor) 
        {
            case "Computer Science":
                major = major.CS;
                break;
            case "Math or CMDA":
                major = major.MATH_OR_CMDA;
                break;
            case "Other":
                major = major.OTHER;
                break;
            case "Other Engineering":
                major = major.OTHER_ENGE;
                break;
            default:
                major = null;
                break;
        }

        // determines the state
        switch (thisState) 
        {
            case "Northeast":
                state = state.NORTHEAST_US;
                break;
            case "Outside of United States":
                state = state.OUTSIDE_THE_US;
                break;
            case "Southeast":
                state = state.SOUTHEAST_US;
                break;
            case "United States (other than Southeast or Northwest)":
                state = state.THE_REST_OF_US;
                break;
            default:
                state = null;
                break;
        }

        index = thisIndex;
    }

    /**
     * get the hobby data of the person
     * @return the hobby data
     */
    public Hobby getHobby()
    {
        return hobby;
    }

    /**
     * get the major data of the person
     * @return the major data
     */
    public Major getMajor()
    {
        return major;
    }

    /**
     * get the state data of the person
     * @return the state data
     */
    public State getState()
    {
        return state;
    }

    /**
     * get the index of the person
     * @return the index of the person
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * gets the song list of the person.
     * @return the song list data
     */
    public SongList getSongList()
    {
        return songList;
    }


}
