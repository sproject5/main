package prj5;
import java.io.FileNotFoundException;
import java.text.ParseException;
import student.TestCase;

public class SurveySorterTest extends TestCase
{
   

    public void setUp() throws FileNotFoundException, ParseException
    {
        
    }

    public void testLinkedDataOf() throws FileNotFoundException, ParseException
    {
        //SongReader reader = new SongReader("SongList2018.csv", "MusicSurveyData2018.csv");
        //SurveySorter survey = new SurveySorter(reader.getPersonList(), reader.getSongList());
        //assertEquals(10, survey.DataOf("All of Me", "art", true));
        //assertEquals(87.6, survey.DataOf("Hotline Bling", Hobby.SPORTS, true), 0.1);
        //assertEquals(42, survey.DataOf("Hotline Bling", Hobby.ART, true));
        
    }
    
    public void testDataOf2() throws FileNotFoundException, ParseException
    {
        SongReader reader = new SongReader("SongListTest1.csv", "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(), reader.getSongList());

        //System.out.println(reader.getPersonList()[0].getSongList().size());
        /*
         * assertEquals(0, surveySorter.DataOf("All These Things I've Done",
         * Hobby.READ, true), 0.1);
         * assertEquals(0, surveySorter.DataOf("All These Things I've Done",
         * Hobby.READ, false), 0.1);
         * 
         * assertEquals(0, surveySorter.DataOf("All These Things I've Done",
         * Hobby.ART, true), 0.1);
         * assertEquals(0, surveySorter.DataOf("All These Things I've Done",
         * Hobby.ART, false), 0.1);
         * 
         * assertEquals(50, surveySorter.DataOf("All These Things I've Done",
         * Hobby.SPORTS, true), 0.1);
         * assertEquals(50, surveySorter.DataOf("All These Things I've Done",
         * Hobby.SPORTS, false), 0.1);
         * 
         * assertEquals(0, surveySorter.DataOf("All These Things I've Done",
         * Hobby.MUSIC, true), 0.1);
         * assertEquals(100, surveySorter.DataOf("All These Things I've Done",
         * Hobby.MUSIC , false), 0.1);
         */
        
        String name = "Another One Bites the Dust";
        
          System.out.println(reader.getPersonList()[0].getHobby() + " : "+
          (reader.getPersonList()[0].getSongList().get(0).getLiked()));
          System.out.println(reader.getPersonList()[1].getHobby() + " : "+
          reader.getPersonList()[1].getSongList().get(0).getLiked());
          System.out.println(reader.getPersonList()[2].getHobby() + " : "+
          reader.getPersonList()[2].getSongList().get(0).getLiked());
          System.out.println(reader.getPersonList()[3].getHobby() + " : "+
          reader.getPersonList()[3].getSongList().get(0).getLiked());
          System.out.println(reader.getPersonList()[4].getHobby() + " : "+
          reader.getPersonList()[4].getSongList().get(0).getLiked());
          System.out.println(reader.getPersonList()[5].getHobby() + " : "+
          reader.getPersonList()[5].getSongList().get(0).getLiked());
          System.out.println("//////////////////////////////////////////////");
          System.out.println(reader.getPersonList()[0].getHobby() + " : "+
          reader.getPersonList()[0].getSongList().get(4).getLiked());
          System.out.println(reader.getPersonList()[1].getHobby() + " : "+
          reader.getPersonList()[1].getSongList().get(4).getLiked());
          System.out.println(reader.getPersonList()[2].getHobby() + " : "+
          reader.getPersonList()[2].getSongList().get(4).getLiked());
          System.out.println(reader.getPersonList()[3].getHobby() + " : "+
          reader.getPersonList()[3].getSongList().get(4).getLiked());
          System.out.println(reader.getPersonList()[4].getHobby() + " : "+
          reader.getPersonList()[4].getSongList().get(4).getLiked());
          System.out.println(reader.getPersonList()[5].getHobby() + " : "+
          reader.getPersonList()[5].getSongList().get(4).getLiked());
         
        
        assertEquals(100, surveySorter.DataOf(name, Hobby.READ, true), 0.1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.ART, true), 0.1);
        assertEquals(100, surveySorter.DataOf(name, Hobby.SPORTS, true), 0.1);
        assertEquals(100, surveySorter.DataOf(name, Hobby.MUSIC, true), 0.1);

        
        assertEquals(100, surveySorter.DataOf(name, Hobby.READ, false), 0.1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.ART, false), 0.1);
        assertEquals(33, surveySorter.DataOf(name, Hobby.SPORTS, false), 0.5);
        assertEquals(100, surveySorter.DataOf(name, Hobby.MUSIC , false), 0.1);
    }
}
