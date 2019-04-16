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

/**
 * 
 *
 * @author 
 * @version 2019.04.14
 */
public class SongReader {

    private SongList<Song> songList;
    private Person[] person;
    private String thisSongListFileName;
    private int personListSize;
    /**
     * 
     * @param songListFileName
     * @param surveyFileName
     * 
     * @throws FileNotFoundException
     */
    public SongReader(String songListFileName, String surveyFileName) throws FileNotFoundException, ParseException {
        thisSongListFileName = songListFileName;
        songList = this.readSongFile(songListFileName);
        person = this.readPersonFile(surveyFileName);
        GUI_MusicWindow window = new GUI_MusicWindow(new SurveySorter(person, songList, personListSize));
    }

    /**
     * @throws FileNotFoundException
     * 
     * @throws ParseException
     */
    private SongList<Song> readSongFile(String fileName) throws FileNotFoundException, ParseException
    {
        songList = new SongList<Song>();
        File file = new File(fileName);
        Scanner file2 = new Scanner(file);
        String line = file2.nextLine();
        int i = 0;
        while (file2.hasNextLine())
        {
            
             line = file2.nextLine();
            String[] in = line.split(",");

            if (in[0] == "" || in[1] == ""|| in[2] == "" || in[3] == "")
            {
                throw new ParseException("not enough values", 3);
            }

            Song song = new Song(in[1], in[0], in[3], Integer.parseInt(in[2]));
            songList.add(song);
            i++;
        }
        return songList;
    }
    
    /**
     * @throws FileNotFoundException
     * 
     * 
     */
    private Person[] readPersonFile(String fileName) throws FileNotFoundException, ParseException
    {
        
        person = new Person[1000];

        File file = new File(fileName);
        Scanner file2 = new Scanner(file);
        String line = file2.nextLine();
        int count = 0;
        while (file2.hasNextLine())
        {
            line = file2.nextLine();
            
            
            String[] in2 = line.split(",");
            
            String[] in = new String[in2.length + 1];

            for (int i = 0; i < in2.length; i++)
            {
                in[i] = in2[i];
            }

            //for (int i = 0; i < in.length; i++)
            //{
            //    System.out.println( "i: "+ i + " Content: " +in[i]);
            //}

            SongList<Song> newSongList = this.readSongFile(thisSongListFileName);

            for (int i = 5; i < in.length - 1; i  = i + 2)
            {
                if (in[i] != null && in[i].equals("Yes"))
                {
                    newSongList.heardToYes((i - 5) /2);
                }
                else if (in[i] != null && in[i].equals("No"))
                {
                    newSongList.heardToNo((i - 5) /2);
                }

                if (in[i + 1] != null && in[i + 1].equals("Yes"))
                {
                    newSongList.likedToYes((i - 5) /2);
                }
                else if (in[i + 1] != null && in[i + 1].equals("No"))
                {
                    newSongList.likedToNo((i - 5) /2);
                }
            }

            Person newPerson;
            if (in.length < 5 || in[4].equals("") || in[2].equals("") || in[3].equals("") 
                || in[4] == null || in[2] == null || in[3] == null)
            {
                newPerson = null;
            }
            else
            {
                newPerson = new Person(newSongList, in[4], in[3], in[2], Integer.parseInt(in[0]));
            }


            person[count] = newPerson;
            //System.out.println(newPerson.getHobby() + " : "+ (newPerson.getSongList().get(0).getHeard()));
            //System.out.println(this.getPersonList()[count].getHobby() + " : "+ (this.getPersonList()[count].getSongList().get(0).getHeard()));
            //System.out.println("//////////////////////////////////////////////");

            count++;
            //System.out.println("totalNumber: " + count);
        }
        personListSize = count;
        return person;

    } 

    /**
     * @return songList of the import data
     */
    public SongList<Song> getSongList()
    {
        return songList;
    }

    public Person[] getPersonList()
    {
        return person;
    }


    public int getPersonListSize()
    {
        return personListSize;
    }


}
