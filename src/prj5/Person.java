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
        Hobby thisHobby, State thisState, Major thisMajor, int thisIndex)
    {
        songList = thisSongList;
        hobby = thisHobby;
        major = thisMajor;
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
