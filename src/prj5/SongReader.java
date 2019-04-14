package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class SongReader {

    private DLList<Song> songList;
    private Person[] person;
    private int size;

    /**
     * 
     * @param songListFileName
     * @param surveyFileName
     * @throws ParseException 
     * @throws FileNotFoundException
     */
    public SongReader(String songListFileName, String surveyFileName) throws FileNotFoundException, ParseException {
        songList = this.readSongFile(songListFileName);
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

            Song song = new Song(in[0], in[1], in[0], Integer.parseInt(in[2]),0, 0);
            songList.add(song);
        }
        
        return songList;
    }
    
    /**
     * @throws FileNotFoundException
     * 
     */
    private Person[] readPersonFile(String fileName) throws FileNotFoundException
    {
        person = new Person[1000];

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

            Song song = new Song(in[0], in[1], in[0], Integer.parseInt(in[2]),0, 0);
            songList.add(song);
        }
        

    } 

    /**
     * @return songList of the import data
     */
    public DLList<Song> getSongList()
    {
        return songList;
    }




}
