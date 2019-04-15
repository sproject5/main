package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class SurveySorter {

    private DLList<Song> songList;
    private Person[] person;
    private SongReader songReader;
    private int size;

    public SurveySorter() throws FileNotFoundException, ParseException
    {
        songReader = new SongReader("SongList2018.csv", "MusicSurveyData2018.csv");
        person = songReader.getPersonList();
        songList = songReader.getSongList();
        size = 0;
    }

    /**
     * return the lked data of the hobby
     */
    public int HeardDataOf(String title, String Hobby )
    {
        int count = 0;

        Hobby hobby = this.hobbyTranslate(Hobby);

        int i = 0;
        while(person[i] != null)
        {
            Hobby thisHobby =  person[i].getHobby();
            if (thisHobby == hobby)
            {
                DLList<Song> thisSongList = person[i].getSongList();
                Song thisSong = this.getSong(title, thisSongList);

                if (thisSong != null && thisSong.getHeard() > 0)
                {
                    System.out.println(thisSong.getSongTitle());
                    count++;
                }
            }
            
            i++;
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
                System.out.println(title);
                targetSong = curSongList.get(k);
            }
        }


        return targetSong;
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
