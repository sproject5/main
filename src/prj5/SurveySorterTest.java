// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;
import java.io.FileNotFoundException;
import java.text.ParseException;
import student.TestCase;

/**
 * 
 * This class tests the SurveySorter constructor and methods
 *
 * @author Drew Pompeii (drewp24)
 * @version 04/17/2019
 */
public class SurveySorterTest extends TestCase
{
   
    /**
     * Sets up before each test case is ran
     */
    public void setUp() throws FileNotFoundException, ParseException
    {
        //intentionally left empty
    }

    /*
     * Tests the linkedDataOf method
     * @throws FileNotFoundException
     * @throws ParseException
     *
    public void testLinkedDataOf() throws FileNotFoundException, ParseException
    {
        //SongReader reader = new SongReader("SongList2018.csv", "MusicSurveyData2018.csv");
        //SurveySorter survey = new SurveySorter(reader.getPersonList(), reader.getSongList());
        //assertEquals(10, survey.DataOf("All of Me", "art", true));
        //assertEquals(87.6, survey.DataOf("Hotline Bling", Hobby.SPORTS, true), 0.1);
        //assertEquals(42, survey.DataOf("Hotline Bling", Hobby.ART, true));
        
    }
    */
    
    /**
     * Tests the dataOf method
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testDataOf2() throws FileNotFoundException, ParseException
    {
        SongReader reader = new SongReader("SongListTest1.csv", "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(), reader.getSongList(), reader.getPersonListSize());

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
        /*
         * System.out.println(reader.getPersonList()[0].getHobby() + " : "+
         * (reader.getPersonList()[0].getSongList().get(0).getLiked()));
         * System.out.println(reader.getPersonList()[1].getHobby() + " : "+
         * reader.getPersonList()[1].getSongList().get(0).getLiked());
         * System.out.println(reader.getPersonList()[2].getHobby() + " : "+
         * reader.getPersonList()[2].getSongList().get(0).getLiked());
         * System.out.println(reader.getPersonList()[3].getHobby() + " : "+
         * reader.getPersonList()[3].getSongList().get(0).getLiked());
         * System.out.println(reader.getPersonList()[4].getHobby() + " : "+
         * reader.getPersonList()[4].getSongList().get(0).getLiked());
         * System.out.println(reader.getPersonList()[5].getHobby() + " : "+
         * reader.getPersonList()[5].getSongList().get(0).getLiked());
         * System.out.println("//////////////////////////////////////////////");
         * System.out.println(reader.getPersonList()[0].getHobby() + " : "+
         * reader.getPersonList()[0].getSongList().get(4).getLiked());
         * System.out.println(reader.getPersonList()[1].getHobby() + " : "+
         * reader.getPersonList()[1].getSongList().get(4).getLiked());
         * System.out.println(reader.getPersonList()[2].getHobby() + " : "+
         * reader.getPersonList()[2].getSongList().get(4).getLiked());
         * System.out.println(reader.getPersonList()[3].getHobby() + " : "+
         * reader.getPersonList()[3].getSongList().get(4).getLiked());
         * System.out.println(reader.getPersonList()[4].getHobby() + " : "+
         * reader.getPersonList()[4].getSongList().get(4).getLiked());
         * System.out.println(reader.getPersonList()[5].getHobby() + " : "+
         * reader.getPersonList()[5].getSongList().get(4).getLiked());
         */
        
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.READ, true));
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.SPORTS, true));
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.MUSIC, true));

        
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.READ, false), 0.1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.SPORTS, false), 0.5);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.MUSIC , false), 0.1);
    }

    /**
     * Tests the dataOf method
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testDataOf3() throws FileNotFoundException, ParseException
    {
        SongReader reader = new SongReader("SongListNoGenreRepeats.csv", "MusicSurveyDataNoGenreRepeats.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(), reader.getSongList(), reader.getPersonListSize());
  
        String name = "All These Things I've Done";
        
        /*
         * assertEquals(41, surveySorter.DataOf(name, Hobby.READ, true), 1);
         * assertEquals(37, surveySorter.DataOf(name, Hobby.ART, true), 1);
         * assertEquals(34, surveySorter.DataOf(name, Hobby.SPORTS, true), 1);
         * assertEquals(35, surveySorter.DataOf(name, Hobby.MUSIC, true), 1);
         * 
         * 
         * assertEquals(41, surveySorter.DataOf(name, Hobby.READ, false), 1);
         * assertEquals(40, surveySorter.DataOf(name, Hobby.ART, false), 1);
         * assertEquals(33, surveySorter.DataOf(name, Hobby.SPORTS, false), 1);
         * assertEquals(38, surveySorter.DataOf(name, Hobby.MUSIC , false), 1);
         */
        
        name = "Tik Tok";
        
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.READ, true), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.ART, true), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.SPORTS, true), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.MUSIC, true), 1);

        
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.READ, false), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.ART, false), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.SPORTS, false), 1);
        assertEquals(0, surveySorter.dataOf(name, HobbyEnum.MUSIC , false), 1);

    }

    /**
     * Tests the numberOf methods
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testNumberOf() throws FileNotFoundException, ParseException
    {
        SongReader reader = new SongReader("SongListTest1.csv", "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(), reader.getSongList(), reader.getPersonListSize());
        String title = "All These Things I've Done";
        System.out.println(surveySorter.numberOf(title, HobbyEnum.READ, true));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.ART, true));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.SPORTS, true));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.MUSIC, true));
        
        System.out.println(surveySorter.numberOf(title, HobbyEnum.READ, false));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.ART, false));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.SPORTS, false));
        System.out.println(surveySorter.numberOf(title, HobbyEnum.MUSIC, false));
        assertNull(null);
    }
}
