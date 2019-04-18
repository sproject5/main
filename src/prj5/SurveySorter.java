// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
//import javax.print.attribute.standard.OutputDeviceAssigned;

/**
 * @author cmangin
 * @version 2019-04-17
 *          The class SurveySorter will be how the data
 *          will be sorted
 *
 */
public class SurveySorter {

    private SongList<Song> songList;
    private Person[] person;
    //private SongReader songReader;
    //private int size;
    private int personListSize;


    /**
     * The default class for SurveySorter
     * 
     * @param inputPerson
     *            The input Person
     * @param inputSongList
     *            The SongList input
     * @param otherPersonListSize
     *            The size of the other person's list
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public SurveySorter(
        Person[] inputPerson,
        SongList<Song> inputSongList,
        int otherPersonListSize)
        throws FileNotFoundException,
        ParseException {
        person = inputPerson;
        songList = inputSongList;
        personListSize = otherPersonListSize;
        //size = 0;
    }


    /**
     * This method returns the the data by sorted by hobby
     * 
     * @param title
     *            the title of the song
     * @param hobby
     *            the hobby
     * @param isHeardData
     *            whether or not the person has heard the song
     * @return
     *         the output
     */
    public int dataOf(String title, HobbyEnum hobby, Boolean isHeardData) {
        int count = 0;
        int i = 0;
        while (i < personListSize) {
            if (person[i] == null) {
                i++;
                continue;
            }

            HobbyEnum thisHobby = person[i].getHobby();
            if (thisHobby == hobby) {
                SongList<Song> thisSongList = person[i].getSongList();
                Song thisSong = this.getSongInLowerCase(title, thisSongList);

                if (isHeardData) {
                    if (thisSong != null && thisSong.getHeard() == 1) {
                        count++;
                    }
                }
                else {
                    if (thisSong != null && thisSong.getLiked() == 1) {
                        count++;
                    }
                }
            }

            i++;
        }
        int output = 0;
        if (this.numberOf(title, hobby, isHeardData) != 0) {
            output = count * 100 / this.numberOf(title, hobby, isHeardData);

        }
        // System.out.println( "Hobby: "+ hobby + " count: " + count +" number:
        // " + this.numberOf(title, hobby, isHeardData) + " output: " + output);
        return output;
    }


    /**
     * This method returns the number of times a song is heard
     * sorted by hobby
     * 
     * @param title
     *            the title
     * @param hobby
     *            the hobby
     * @param isHeardData
     *            whether or not the song is heard
     * @return
     *         the count
     */
    public int numberOf(String title, HobbyEnum hobby, Boolean isHeardData) {
        int count = 0;
        for (int i = 0; i < person.length; i++) {
            if (isHeardData) {
                if (person[i] != null && person[i].getHobby() == hobby
                    && person[i].getSongList().getSongInLowerCase(title) != null
                    && (person[i].getSongList().getSongInLowerCase(title)
                        .getHeard() >= 0)) {
                    count++;
                }
            }
            else {
                if (person[i] != null && person[i].getHobby() == hobby
                    && person[i].getSongList().getSongInLowerCase(title) != null
                    && (person[i].getSongList().getSongInLowerCase(title)
                        .getLiked() >= 0)) {
                    count++;
                }
            }
        }
        return count;

    }


    /**
     * This method returns the lowercase version of the song
     * 
     * @param title
     *            the title of the song
     * @param curSongList
     *            the current song list
     * @return
     *         the target song
     */
    public Song getSongInLowerCase(String title, DLList<Song> curSongList) {
        Song targetSong = null;
        for (int k = 0; k < curSongList.size(); k++) {
            // System.out.println(curSongList.get(k).getSongTitle());
            if (curSongList.get(k).getSongTitle().toLowerCase().equals(title)) {
                // System.out.println(title);
                targetSong = curSongList.get(k);
            }
        }

        return targetSong;
    }


    /**
     * This method returns the song list by genre
     * 
     * @param genre
     *            the genre of the song
     * @param curSongList
     *            the current songlist
     * @return
     *         the target song
     */
    public SongList<Song> getSongByGenre(
        String genre,
        SongList<Song> curSongList) {
        SongList<Song> targetSong = new SongList<Song>();
        for (int k = 0; k < curSongList.size(); k++) {
            if (curSongList.get(k).getGenre().equals(genre)) {
                targetSong.add(curSongList.get(k));
            }
        }
        return targetSong;
    }


    /**
     * This method gets the song list
     * 
     * @return
     *         the song list
     */
    public SongList<Song> getSongList() {
        return songList;
    }

}