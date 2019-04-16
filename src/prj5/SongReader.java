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
             //System.out.println(line);
            String[] in = line.split(",");

            if (in[0] == "" || in[1] == ""|| in[2] == "" || in[3] == "")
            {
                throw new ParseException("not enough values", 3);
            }

            Song song = new Song(in[1], in[0], in[3], Integer.parseInt(in[2]),0, 0);
            songList.add(song);
            i++;
        }
        //System.out.println(i);
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

            SongList<Song> newSongList = this.readSongFile(thisSongListFileName);
            //System.out.println(newSongList.size());
            //System.out.println(count);
            //System.out.println(in[5]);

            for (int i = 5; i < newSongList.size() + 5; i++)
            {
                
                if (in[i].equals("Yes")) newSongList.incrementHeard(i - 5);;
                
                //System.out.println("index: " + in[0] + " i: " + i + " " + in[i] + newSongList.get(i - 5).getHeard() + " Song: " + newSongList.get(i - 5).toString());
                
                if (in[i + 1].equals("Yes")) newSongList.incrementLike(i - 5);
                
                
                //System.out.println("index: " + in[0] + " i: " + i + " " + in[i] + newSongList.get(i - 5).getLiked() + " Song: " + newSongList.get(i - 5).toString());
                i++;
                //System.out.println("index: " + in[0] + " i: " + i + " " + in[i] +" Like: " + newSongList.get(i - 5).getLiked() + " Heard: " + newSongList.get(i - 5).getHeard() + " Song: " + newSongList.get(i - 5).toString());


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
