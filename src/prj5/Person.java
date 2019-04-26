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

    private Attribute attributes;

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
        int thisIndex) 
        {

        songList = thisSongList;
        // determines the hobby

        attributes = new Attribute(thisHobby, thisState, thisMajor);
        
        index = thisIndex;
    }



    /**
     * get the hobby data of the person
     * 
     * @return the hobby data
     */
    public HobbyEnum getHobby() {
        return attributes.getHobby();
    }


    /**
     * get the major data of the person
     * 
     * @return the major data
     */
    public MajorEnum getMajor() {
        return attributes.getMajor();
    }


    /**
     * get the state data of the person
     * 
     * @return the state data
     */
    public StateEnum getState() {
        return attributes.getState();
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
     * Gets the attributes of the person
     * @return the person's attributes
     */
    public Attribute getAttribute()
    {
        return this.attributes;
    }

    /**
     * return the content of this person
     * 
     * @return the string content of this person
     */
    public String toString() {
        return index + "; Hobby: " + getHobby() + "; Major: " + getMajor() +
            "; State: " + getState();
    }

}