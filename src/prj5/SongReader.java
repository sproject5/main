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

    private DLList<Song> songList;
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
    }

    /**
     * @throws FileNotFoundException
     * @throws ParseException
     * 
     */
    private DLList<Song> readSongFile(String fileName) throws FileNotFoundException, ParseException
    {
        songList = new DLList<Song>();
        File file = new File(fileName);
        Scanner file2 = new Scanner(file);
        String line = file2.nextLine();
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
            
            
            
            DLList<Song> newSongList = this.readSongFile(thisSongListFileName);
            //System.out.println(count);
            for (int i = 5; i < newSongList.size() + 5; i++)
            {
                if (in[i].equals("Yes")) newSongList.get(i - 5).addHeard();
                i++;
                if (in[i].equals("Yes")) newSongList.get(i - 5).addHeard();
            }

            Person newPerson = new Person(newSongList, in[4], in[3], in[2], Integer.parseInt(in[0]));
            person[count] = newPerson;
            count++;
            
        }
        
        return person;

    } 

    /**
     * @return songList of the import data
     */
    public DLList<Song> getSongList()
    {
        return songList;
    }

    public Person[] getPersonList()
    {
        return person;
    }




}
