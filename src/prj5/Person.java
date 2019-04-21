// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin, drewp24

package prj5;

/**
 * This is the person class
 * store survey data of one person
 * 
 * @author drewp24
 * @version 2019.16.04
 */
public class Person {

    private SongList<Song> songList;
    private HobbyEnum hobby;
    private MajorEnum major;
    private StateEnum state;
    private int index;


    /**
     * This is the constructor for the Person class
     * 
     * @param thisSongList
     *            songList passed through
     * @param thisHobby
     *            the person's hobby
     * @param thisState
     *            the person's state
     * @param thisMajor
     *            the person's major
     * @param thisIndex
     *            the person's index
     */
    public Person(
        SongList<Song> thisSongList,
        String thisHobby,
        String thisState,
        String thisMajor,
        int thisIndex) {

        songList = thisSongList;
        // determines the hobby
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

        index = thisIndex;
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
     * get the index of the person
     * 
     * @return the index of the person
     */
    public int getIndex() {
        return index;
    }


    /**
     * gets the song list of the person.
     * 
     * @return the song list data
     */
    public SongList<Song> getSongList() {
        return songList;
    }


    /**
     * return the content of this person
     * 
     * @return the string content of this person
     */
    public String toString() {
        return index + "; Hobby: " + hobby + "; Major: " + major + "; State: "
            + state;
    }

}
