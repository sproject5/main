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
 * @author cmangin
 *         This class will test the SurveySorterClass
 *
 */
public class SurveySorterTest extends TestCase {

    /**
     * The setUp is intentionally left empty
     */
    public void setUp() throws FileNotFoundException, ParseException {

    }


    /**
     * This method tests the DataOf method of the SurveySorter method
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testDataOf2() throws FileNotFoundException, ParseException {
        SongReader reader = new SongReader("SongListTest1.csv",
            "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(),
            reader.getSongList(), reader.getPersonListSize());

        // System.out.println(reader.getPersonList()[0].getSongList().size());
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

        assertEquals(0, surveySorter.DataOf(name, Hobby.READ, true), 0.1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.SPORTS, true), 0.1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.MUSIC, true), 0.1);

        assertEquals(0, surveySorter.DataOf(name, Hobby.READ, false), 0.1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.SPORTS, false), 0.5);
        assertEquals(0, surveySorter.DataOf(name, Hobby.MUSIC, false), 0.1);
    }


    /**
     * This method tests the DataOf method of the SurveySorter method
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testDataOf3() throws FileNotFoundException, ParseException {
        SongReader reader = new SongReader("SongListNoGenreRepeats.csv",
            "MusicSurveyDataNoGenreRepeats.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(),
            reader.getSongList(), reader.getPersonListSize());
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

        assertEquals(0, surveySorter.DataOf(name, Hobby.READ, true), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.ART, true), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.SPORTS, true), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.MUSIC, true), 1);

        assertEquals(0, surveySorter.DataOf(name, Hobby.READ, false), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.ART, false), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.SPORTS, false), 1);
        assertEquals(0, surveySorter.DataOf(name, Hobby.MUSIC, false), 1);

    }


    /**
     * This method tests the numberOf method in SurveySorter
     * 
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public void testNumberOf() throws FileNotFoundException, ParseException {
        SongReader reader = new SongReader("SongListTest1.csv",
            "MusicSurveyDataTest1.csv");
        SurveySorter surveySorter = new SurveySorter(reader.getPersonList(),
            reader.getSongList(), reader.getPersonListSize());
        String title = "All These Things I've Done";
        System.out.println(surveySorter.numberOf(title, Hobby.READ, true));
        System.out.println(surveySorter.numberOf(title, Hobby.ART, true));
        System.out.println(surveySorter.numberOf(title, Hobby.SPORTS, true));
        System.out.println(surveySorter.numberOf(title, Hobby.MUSIC, true));

        System.out.println(surveySorter.numberOf(title, Hobby.READ, false));
        System.out.println(surveySorter.numberOf(title, Hobby.ART, false));
        System.out.println(surveySorter.numberOf(title, Hobby.SPORTS, false));
        System.out.println(surveySorter.numberOf(title, Hobby.MUSIC, false));

    }
}
