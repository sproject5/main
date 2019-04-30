// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import CS2114.Button;

/**
 * This class reads the song list and survey files and
 * into song and person objects
 *
 * @author drewp24
 * @version 2019.04.14
 */
public class SongReader {

    private SongList<Song> songList;
    private Person[] person;
    private String thisSongListFileName;
    private int personListSize;


    /**
     * This is the constructor for the SongReader
     * 
     * @param songListFileName
     *            songListFileName
     * @param surveyFileName
     *            surveyFileName
     * 
     * @throws FileNotFoundException
     */
    public SongReader(String songListFileName, String surveyFileName)
        throws FileNotFoundException,
        ParseException {
        thisSongListFileName = songListFileName;
        songList = this.readSongFile(songListFileName);
        person = this.readPersonFile(surveyFileName);
        GUI_MusicWindow window = new GUI_MusicWindow(new SurveySorter(person,
            songList, personListSize));
    }


    /**
     * Reads in the songList file
     * 
     * @param fileName
     *            the file being read from
     * @return a list of the songs from the file after being parsed
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private SongList<Song> readSongFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        songList = new SongList<Song>();
        File file = new File(fileName);
        Scanner file2 = new Scanner(file);
        String line = file2.nextLine();
        int i = 0;
        while (file2.hasNextLine()) {

            line = file2.nextLine();
            String[] in = line.split(",");

            if (in[0] == "" || in[1] == "" || in[2] == "" || in[3] == "") {
                throw new ParseException("not enough values", 3);
            }

            Song song = new Song(in[1], in[0], in[3], Integer.parseInt(in[2]));
            songList.add(song);
            i++;
        }
        return songList;
    }


    /**
     * Reads in the person file
     * 
     * @param fileName
     *            the file being read from
     * @return an array of the person file after being parsed
     * @throws FileNotFoundException
     */
    private Person[] readPersonFile(String fileName)
        throws FileNotFoundException,
        ParseException {

        person = new Person[1000];

        File file = new File(fileName);
        Scanner file2 = new Scanner(file);
        String line = file2.nextLine();
        int count = 0;
        while (file2.hasNextLine()) {
            line = file2.nextLine();

            String[] in2 = line.split(",");

            String[] in = new String[in2.length + 1];

            for (int i = 0; i < in2.length; i++) {
                in[i] = in2[i];
            }

            SongList<Song> newSongList = this.readSongFile(
                thisSongListFileName);

            for (int i = 5; i < in.length - 1; i = i + 2) {
                if (in[i] != null && in[i].equals("Yes")) {
                    newSongList.heardToYes((i - 5) / 2);
                }
                else if (in[i] != null && in[i].equals("No")) {
                    newSongList.heardToNo((i - 5) / 2);
                }

                if (in[i + 1] != null && in[i + 1].equals("Yes")) {
                    newSongList.likedToYes((i - 5) / 2);
                }
                else if (in[i + 1] != null && in[i + 1].equals("No")) {
                    newSongList.likedToNo((i - 5) / 2);
                }
            }

            Person newPerson;
            if (in.length < 5 || in[4].equals("") || in[2].equals("") || in[3]
                .equals("") || in[4] == null || in[2] == null
                || in[3] == null) {
                newPerson = null;
            }
            else {
                newPerson = new Person(newSongList, in[4], in[3], in[2], Integer
                    .parseInt(in[0]));
            }

            person[count] = newPerson;
            count++;
        }
        personListSize = count;
        return person;

    }


    /**
     * Gets the songList
     * 
     * @return songList of the import data
     */
    public SongList<Song> getSongList() {
        return songList;
    }


    /**
     * Gets the personList
     * 
     * @return the personList
     */
    public Person[] getPersonList() {
        return person;
    }


    /**
     * Gets the PersonListSize
     * 
     * @return size of person list
     */
    public int getPersonListSize() {
        return personListSize;
    }

}
