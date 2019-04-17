// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

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
     * return the liked data of the hobby
     */
    public int DataOf(String title, HobbyEnum hobby, Boolean isHeardData )
    {
        int count = 0;
        int i = 0;
        while(i < personListSize)
        {
            if (person[i] == null)
            {
                i++;
                continue;
            }

            HobbyEnum thisHobby =  person[i].getHobby();
            if (thisHobby == hobby)
            {
                SongList<Song> thisSongList = person[i].getSongList();
                Song thisSong = this.getSongInLowerCase(title, thisSongList);
                
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
        int output = 0;
        if(this.numberOf(title, hobby, isHeardData)  != 0) {
            output = count * 100 / this.numberOf(title, hobby, isHeardData) ;

        }
        //System.out.println( "Hobby: "+ hobby + " count: " + count +" number: " + this.numberOf(title, hobby, isHeardData) + " output: "  + output);
        return output;
    }

    public int numberOf(String title, HobbyEnum hobby, Boolean isHeardData)
    {
        int count = 0;
        for (int i = 0; i < person.length; i++)
        {
            if(isHeardData)
            {
                if (person[i] != null && person[i].getHobby()==hobby && person[i].getSongList().getSongInLowerCase(title) != null
                && (person[i].getSongList().getSongInLowerCase(title).getHeard() >= 0))
                {
                    count++;
                }
            }
            else
            {
                if (person[i] != null && person[i].getHobby()==hobby && person[i].getSongList().getSongInLowerCase(title) != null
                && (person[i].getSongList().getSongInLowerCase(title).getLiked() >= 0))
                {
                    count++;
                }
            } 
        }
        return count;
        
    }

//    public Song getSong(String title, DLList<Song> curSongList)
//    {
//        Song targetSong = null;
//        for (int k = 0; k < curSongList.size(); k++)
//        {
//            //System.out.println(curSongList.get(k).getSongTitle());
//            if (curSongList.get(k).getSongTitle().equals(title))
//            {
//                //System.out.println(title);
//                targetSong = curSongList.get(k);
//            }
//        }
//
// 
//        return targetSong;
//    }

    public Song getSongInLowerCase(String title, DLList<Song> curSongList)
    {
        Song targetSong = null;
        for (int k = 0; k < curSongList.size(); k++)
        {
            //System.out.println(curSongList.get(k).getSongTitle());
            if (curSongList.get(k).getSongTitle().toLowerCase().equals(title))
            {
                //System.out.println(title);
                targetSong = curSongList.get(k);
            }
        }


        return targetSong;
    }
    
    public SongList<Song> getSongByGenre(String genre, SongList<Song> curSongList)
    {
        SongList<Song> targetSong = new SongList<Song>();
        for (int k = 0; k < curSongList.size(); k++)
        {
            if (curSongList.get(k).getGenre().equals(genre))
            {
                targetSong.add(curSongList.get(k));
            }
        }
        return targetSong;
    }


    public SongList<Song> getSongList()
    {
        return songList;
    }
   
}