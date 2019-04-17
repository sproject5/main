// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;


/**
 * 
 * @author cmangin
 *  he SurveySorter class will serve to sort data into a songList
 *@version 2019.4
 */
public class SurveySorter {

    private SongList<Song> songList;
    private Person[] person;
    private int personListSize;

    /**
     * This method is the default constructor of the Survey sorter
     * @param inputPerson
     *              a person
     * @param inputSongList
     *              a SongList
     * @param otherPersonListSize
     *              the size of another person's list
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public SurveySorter(Person[] inputPerson, SongList<Song> 
        inputSongList, int otherPersonListSize) 
        throws FileNotFoundException, ParseException
    {
        person = inputPerson;
        songList = inputSongList;
        personListSize = otherPersonListSize;
    }

    /**
     * return the liked data of the hobby
     * @return the data of sorting
     * @param hobby the hobby input
     * @param title the title of the song
     * @param isHeardData if it is true
     */
    public double dataOf(String title, Hobby hobby, Boolean isHeardData )
    {
        int count = 0;
        int i = 0;
        while (i < personListSize)
        {
            if (person[i] == null)
            {
                i++;
                continue;
            }

            Hobby thisHobby =  person[i].getHobby();
            if (thisHobby == hobby)
            {
                SongList<Song> thisSongList = person[i].getSongList();
                Song thisSong = this.getSongInLowerCase(title, thisSongList);
                
                if (isHeardData)
                {
                    if (thisSong != null && thisSong.getHeard() == 1)
                    {
                        count++;
                    }
                }
                else 
                {
                    if (thisSong != null && thisSong.getLiked() == 1)
                    {
                        count++;
                    }
                }
            }

            i++;
        }

        double output = ((double)count / this
            .numberOf(title, hobby, isHeardData) ) * 100;
        return output;
    }
    
    /**
     * This method returns the number of times within the data
     * a person with a certain hobby heard the song
     * @param title
     *          the title of the song
     * @param hobby
     *          the hobby of the person
     * @param isHeardData
     *          boolean describing whether heard is true or false
     * @return
     *      the count
     */
    public double numberOf(String title, Hobby hobby, Boolean isHeardData)
    {
        double count = 0.0000001;
        for (int i = 0; i < person.length; i++)
        {
            if (isHeardData)
            {
                if (person[i] != null && person[i].getHobby() 
                    == hobby && person[i]
                    .getSongList().getSongInLowerCase(title) != null
                    && (person[i].getSongList()
                    .getSongInLowerCase(title).getHeard() >= 0))
                {
                    count++;
                }
            }
            else
            {
                if (person[i] != null && person[i].getHobby() == 
                    hobby && person[i].getSongList().getSongInLowerCase(title) 
                    != null
                    && (person[i].getSongList().getSongInLowerCase(title)
                    .getLiked() >= 0))
                {
                    count++;
                }
            } 
        }
        return count;
        
    }


    /**
     * This method will return the song in lower case
     * @param title
     *      the title of the song
     * @param curSongList
     *       the current songList
     * @return
     *      the targetSong
     */
    public Song getSongInLowerCase(String title, DLList<Song> curSongList)
    {
        Song targetSong = null;
        for (int k = 0; k < curSongList.size(); k++)
        {
            //System.out.println(curSongList.get(k).getSongTitle());
            if (curSongList.get(k).getSongTitle().toLowerCase().equals(title))
            {
                //System.out.println(title);
                targetSong = curSongList.get(k);
            }
        }


        return targetSong;
    }
    
    /**
     * The method will return the song's genre
     * @param genre
     *          the genre of the song
     * @param curSongList
     *          the current song list
     * @return
     *      the targetSong
     */
    public SongList<Song> 
        getSongByGenre(String genre, SongList<Song> curSongList)
    {
        SongList<Song> targetSong = new SongList<Song>();
        for (int k = 0; k < curSongList.size(); k++)
        {
            if (curSongList.get(k).getGenre().equals(genre))
            {
                targetSong.add(curSongList.get(k));
            }
        }
        return targetSong;
    }

    /**
     * This metho get the song list
     * @return
     *      the songList
     */
    public SongList<Song> getSongList()
    {
        return songList;
    }
   
}
