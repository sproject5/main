package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

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
    public int DataOf(String title, Hobby hobby, Boolean isHeardData )
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
                    if (thisSong != null && thisSong.getHeard() > 0)
                    {   
                        count++;
                    }  
                }
                else 
                {
                    if (thisSong != null && thisSong.getLiked() > 0)
                    {
                        count++;
                    }
                }
                
            }
            
            i++;
        }
        
        return count;
    }

    public int numberOf(Hobby hobby)
    {
        int count = 0;
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
    
    /**
     * translate the string to Hobby
     * @param str the string to be translate
     * @return the aimed hobby
     */
    public Hobby hobbyTranslate(String str)
    {
        Hobby hobby;
        switch (str) 
        {
            case "reading":
                hobby = Hobby.READ;
                break;
            case "art":
                hobby = Hobby.ART;
                break;
            case "music":
                hobby = Hobby.MUSIC;
                break;
            case "sports":
                hobby = Hobby.SPORTS;
                break;
            default:
                hobby = null;
                break;
        }
        return hobby;
    }


}
