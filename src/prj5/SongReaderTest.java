// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin, drewp24

package prj5;

import student.TestCase;
import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Tests the SongReader class.
 *
 * @author Conner Mangin (cmangin) (drewp24)
 * @version 2019.04.14
 */
public class SongReaderTest extends TestCase {
    
    private SongReader reader;

    /**
     * Sets up the initial condition
     * @throws ParseException 
     * @throws FileNotFoundException 
     * @throws java.text.ParseException 
     */
    public void setUp() throws FileNotFoundException, 
        ParseException, java.text.ParseException
    {
        reader = new SongReader("SongList2018.csv", 
            "MusicSurveyData2018Test1.csv");
    }

    /**
     * Tests the readSongFile method
     * @throws java.text.ParseException 
     * @throws FileNotFoundException 
     * 
     */
    public void testReadSongFile() 
            throws FileNotFoundException, java.text.ParseException 
    {

        Person[] persons = reader.getPersonList();
        assertEquals(001, persons[0].getIndex());
        
        assertEquals(1, persons[0].getSongList().get(0).getHeard());
         
        
        assertEquals(0, persons[0].getSongList().get(1).getHeard());
        assertEquals(0, persons[0].getSongList().get(1).getLiked());
        
        
        assertEquals(1, persons[0].getSongList().get(2).getHeard());
        assertEquals(1, persons[0].getSongList().get(2).getLiked());

        assertEquals(1, persons[0].getSongList().get(3).getHeard());
        assertEquals(1, persons[0].getSongList().get(3).getLiked());

        
        assertEquals(0, persons[0].getSongList().get(4).getHeard());
        assertEquals(0, persons[0].getSongList().get(4).getLiked());

        //assertEquals(1, persons[0].getSongList().get(5).getHeard());
        assertEquals(1, persons[0].getSongList().get(5).getHeard());
        assertEquals(1, persons[0].getSongList().get(5).getLiked());

        //assertEquals(1, persons[0].getSongList().get(7).getHeard());
        
    }
   
 
}
