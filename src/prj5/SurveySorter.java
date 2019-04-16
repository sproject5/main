package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class SurveySorter {

    private SongList<Song> songList;
    private Person[] person;
    private SongReader songReader;
    private int size;
    private int personListSize;

    public SurveySorter(Person[] inputPerson, SongList<Song> inputSongList, int otherPersonListSize) throws FileNotFoundException, ParseException
    {
        person = inputPerson;
        songList = inputSongList;
        personListSize = otherPersonListSize;
        size = 0;
    }

    /**
     * return the lked data of the hobby
     */
    public double DataOf(String title, Hobby hobby, Boolean isHeardData )
    {
        int count = 0;
        int i = 0;
        while(i <= personListSize)
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
                Song thisSong = this.getSong(title, thisSongList);
                
                if (isHeardData)
                {
                    if (thisSong != null && thisSong.getHeard() == 1) count++;
                }
                else 
                {
                    if (thisSong != null && thisSong.getLiked() == 1) count++;
                }
            }
            
            i++;
        }

        double output = ((double)count / this.numberOf(title, hobby, isHeardData)) * 100;
        System.out.println( "Hobby: "+ hobby + " count: " + count +" number: " + this.numberOf(title, hobby, isHeardData) + " output: "  + output);
        return output;
    }

    public double numberOf(String title, Hobby hobby, Boolean isHeardData)
    {
        double count = 0.001;
        
        
        for (int i = 0; i < person.length; i++)
        {
            if(isHeardData)
            {
                if (person[i] != null && person[i].getHobby()==hobby
                && (person[i].getSongList().getSong(title).getHeard() >= 0))
                {
                    count++;
                }
            }
            else
            {
                if (person[i] != null && person[i].getHobby()==hobby
                && (person[i].getSongList().getSong(title).getLiked() >= 0))
                {
                    count++;
                }
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
