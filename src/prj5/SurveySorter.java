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

    public int LikedDataOf(String Hobby)
    {
        int count = 0;

        Hobby hobby = this.hobbyTranslate(Hobby);

        int i = 0;
        while(person[i] != null)
        {
            Hobby thisHobby =  person[i].getHobby();
            System.out.println(thisHobby == hobby);
            if (thisHobby != null && thisHobby == hobby)
            {
                
                DLList<Song> thisSongList = person[i].getSongList();
                for (int k = 0; k < thisSongList.size(); k++)
                {
                    if (thisSongList.get(0).getHeard() == 1)
                    {
                        count++;
                    }
                }
            }
            
            i++;
        }




        return count;
    }

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
