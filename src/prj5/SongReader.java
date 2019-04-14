package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class SongReader {

    private DLList<Song> songList;
    private Person[] person;
    private int size;
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

            Song song = new Song(in[0], in[1], in[0], Integer.parseInt(in[2]),0, 0);
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
            for (int i = 4; i < newSongList.size() + 4; i++)
            {
                Song song = newSongList.get(i - 4);
                switch (in[i]) 
                {
                    case "Yes":
                        song.addHeard();
                        break;
                    default:
                        break;
                }
                i++;
                switch (in[i]) 
                {
                    case "Yes":
                        song.addLiked();
                        break;
                    default:
                        break;
                }

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
