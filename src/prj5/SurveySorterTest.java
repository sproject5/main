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

    /**
     * Tests the dataOf method
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testDataOf2() throws FileNotFoundException, ParseException
    {
        SongReader reader = new SongReader("SongListTest1.csv", "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(), reader.getSongList(), reader.getPersonListSize());

        String name = "Another One Bites the Dust";
        
        assertEquals(0, surveySorter.dataOf(name, "reading", true));
        assertEquals(0, surveySorter.dataOf(name, "sports", true));
        assertEquals(0, surveySorter.dataOf(name, "music", true));

        
        assertEquals(0, surveySorter.dataOf(name, "reading", false), 0.1);
        assertEquals(0, surveySorter.dataOf(name, "sports", false), 0.5);
        assertEquals(0, surveySorter.dataOf(name, "music" , false), 0.1);
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
        
        name = "Tik Tok";
        
        assertEquals(0, surveySorter.dataOf(name, "reading", true), 1);
        assertEquals(0, surveySorter.dataOf(name, "art", true), 1);
        assertEquals(0, surveySorter.dataOf(name, "sports", true), 1);
        assertEquals(0, surveySorter.dataOf(name, "music", true), 1);
        
        assertEquals(0, surveySorter.dataOf(name, "reading", false), 1);
        assertEquals(0, surveySorter.dataOf(name, "art", false), 1);
        assertEquals(0, surveySorter.dataOf(name, "sports", false), 1);
        assertEquals(0, surveySorter.dataOf(name, "music" , false), 1);

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
        System.out.println(surveySorter.numberOf(title, "reading", true));
        System.out.println(surveySorter.numberOf(title, "art", true));
        System.out.println(surveySorter.numberOf(title, "sports", true));
        System.out.println(surveySorter.numberOf(title, "music", true));
        
        System.out.println(surveySorter.numberOf(title, "reading", false));
        System.out.println(surveySorter.numberOf(title, "art", false));
        System.out.println(surveySorter.numberOf(title, "sports", false));
        System.out.println(surveySorter.numberOf(title, "music", false));
        SongReader readNull = null;
        assertNull(readNull);
    }
}
