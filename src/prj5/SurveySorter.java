package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class SurveySorter {

    private SongList<Song> songList;
    private Person[] person;
    private SongReader songReader;
    private int size;

    public SurveySorter(Person[] inputPerson, SongList<Song> inputSongList) throws FileNotFoundException, ParseException
    {
        person = inputPerson;
        songList = inputSongList;
        size = 0;
    }

    /**
     * return the lked data of the hobby
     */
    public double DataOf(String title, Hobby hobby, Boolean isHeardData )
    {
        int count = 0;
        int i = 0;
        while(person[i] != null)
        {
            Hobby thisHobby =  person[i].getHobby();
            if (thisHobby == hobby)
            {
                DLList<Song> thisSongList = person[i].getSongList();
                Song thisSong = this.getSong(title, thisSongList);
                
                if (isHeardData)
                {
                    if (thisSong != null && thisSong.getHeard() > 0) count++;
                }
                else 
                {
                    if (thisSong != null && thisSong.getLiked() > 0) count++;
                }
                
                
            }
            
            i++;
        }

        double output = ((double)count / this.numberOf(hobby)) * 100;
        System.out.println( "Hobby: "+ hobby + " count: " + count +" number: " + this.numberOf(hobby) + " output: "  + output);
        return output;
    }

    public double numberOf(Hobby hobby)
    {
        double count = 0.001;
        for (int i = 0; i < person.length; i++)
        {
            if (person[i] != null && person[i].getHobby()==hobby)
            {
                count++;
            }
        }
        return count;
    }

    public Song getSong(String title, DLList<Song> curSongList)
    {
        Song targetSong = null;
        for (int k = 0; k < curSongList.size(); k++)
        {
            //System.out.println(curSongList.get(k).getSongTitle());
            if (curSongList.get(k).getSongTitle().equals(title))
            {
                //System.out.println(title);
                targetSong = curSongList.get(k);
            }
        }


        return targetSong;
    }
    
    
    public SongList<Song> getSongList()
    {
        return songList;
    }
   
}
