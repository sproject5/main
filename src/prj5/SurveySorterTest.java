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
 * test the surveysorter
 * @author boyuan
 *@version 2019.4
 */
public class SurveySorterTest extends TestCase
{
   

    /**
     *  test the number of
     * @throws FileNotFoundException when the file is not found
     * @throws ParseException when the parse error
     */
    public void testdataOf21() throws FileNotFoundException, ParseException
    {
        SongReader reader 
            = new SongReader("SongListTest1.csv", "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter 
            = new SurveySorter(reader.getPersonList(),  
            reader.getSongList(), reader.getPersonListSize());
    }


    /**
     * This method tests the dataOf method of the SurveySorter method
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testdataOf2() throws FileNotFoundException, ParseException {
        SongReader reader = new SongReader("SongListTest1.csv",
            "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(),
            reader.getSongList(), reader.getPersonListSize());



        String name = "Another One Bites the Dust";


        assertEquals(0, surveySorter.dataOf(name, Hobby.READ, true), 0.1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.SPORTS, true), 0.1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.MUSIC, true), 0.1);

        assertEquals(0, surveySorter.dataOf(name, Hobby.READ, false), 0.1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.SPORTS, false), 0.5);
        assertEquals(0, surveySorter.dataOf(name, Hobby.MUSIC, false), 0.1);
    }


    /**
     * This method tests the dataOf method of the SurveySorter method
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testdataOf3() throws FileNotFoundException, ParseException {
        SongReader reader = new 
            SongReader("SongListNoGenreRepeats.csv",
            "MusicSurveyDataNoGenreRepeats.csv");
        SurveySorter surveySorter = new 
            SurveySorter(reader.getPersonList(),
            reader.getSongList(), reader.getPersonListSize());
        String name = "All These Things I've Done";

        /*
         * assertEquals(41, surveySorter.dataOf(name, Hobby.READ, true), 1);
         * assertEquals(37, surveySorter.dataOf(name, Hobby.ART, true), 1);
         * assertEquals(34, surveySorter.dataOf(name, Hobby.SPORTS, true), 1);
         * assertEquals(35, surveySorter.dataOf(name, Hobby.MUSIC, true), 1);
         * 
         * 
         * assertEquals(41, surveySorter.dataOf(name, Hobby.READ, false), 1);
         * assertEquals(40, surveySorter.dataOf(name, Hobby.ART, false), 1);
         * assertEquals(33, surveySorter.dataOf(name, Hobby.SPORTS, false), 1);
         * assertEquals(38, surveySorter.dataOf(name, Hobby.MUSIC , false), 1);
         */

        name = "Tik Tok";

        assertEquals(0, surveySorter.dataOf(name, Hobby.READ, true), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.ART, true), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.SPORTS, true), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.MUSIC, true), 1);

        assertEquals(0, surveySorter.dataOf(name, Hobby.READ, false), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.ART, false), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.SPORTS, false), 1);
        assertEquals(0, surveySorter.dataOf(name, Hobby.MUSIC, false), 1);

    }


}
