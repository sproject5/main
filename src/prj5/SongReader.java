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

    /**
     * 
     * @param songListFileName
     * @param surveyFileName
     * @throws ParseException 
     * @throws FileNotFoundException
     */
    public SongReader(String songListFileName, String surveyFileName) throws FileNotFoundException, ParseException {
        thisSongListFileName = songListFileName;
        songList = this.readSongFile(songListFileName);
        person = this.readPersonFile(surveyFileName);
        GUI_MusicWindow window = new GUI_MusicWindow(new SurveySorter(person, songList));
    }

    /**
     * @throws FileNotFoundException
     * @throws ParseException
     * 
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

            Song song = new Song(in[1], in[0], in[3], Integer.parseInt(in[2]),0, 0);
            songList.add(song);
            i++;
        }
        return songList;
    }
    
    /**
     * @throws FileNotFoundException
     * @throws ParseException
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
            
            
            String[] in = line.split(",");
            
            for (int i = 0; i < in.length; i++)
            {
                //System.out.println(i + " : " + in[i]);
            }
            
            
            
            SongList<Song> newSongList = this.readSongFile(thisSongListFileName);

            for (int i = 5; i < (in.length - 4); i  = i + 2)
            {

                if (in[i].equals("Yes")) newSongList.incrementHeard((i - 5) /2);;               
                if (in[i + 1].equals("Yes")) newSongList.incrementLike((i - 5) /2);
            }
            Person newPerson;
            if (in.length < 5)
            {
                newPerson = null;
            }
            else
            {
                newPerson = new Person(newSongList, in[4], in[3], in[2], Integer.parseInt(in[0]));

            }

            person[count] = newPerson;
            count++;
            
        }
        
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




}
