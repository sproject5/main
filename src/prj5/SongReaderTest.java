// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import student.TestCase;
import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Tests the Person class.
 *
 * @author Conner Mangin (cmangin)
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
    public void setUp() throws FileNotFoundException, ParseException, java.text.ParseException
    {
        reader = new SongReader("SongList2018.csv", "MusicSurveyData2018Test1.csv");
    }

    /**
     * @throws java.text.ParseException 
     * @throws FileNotFoundException 
     * 
     */
    public void testReadSongFile() throws FileNotFoundException, java.text.ParseException 
    {
        SongReader reader = new SongReader("SongList2018.csv", "MusicSurveyData2018.csv");
        DLList<Song> songList = reader.getSongList();

        Person[] persons = reader.getPersonList();
        assertEquals(001, persons[0].getIndex());
        assertEquals(Hobby.READ, persons[0].getHobby());
        
         assertEquals(1, persons[0].getSongList().get(0).getHeard());
         assertEquals(1, persons[1].getSongList().get(0).getHeard());
         assertEquals(1, persons[2].getSongList().get(0).getHeard());
         assertEquals(1, persons[3].getSongList().get(0).getHeard());
         assertEquals(1, persons[4].getSongList().get(0).getHeard());
         assertEquals(1, persons[5].getSongList().get(0).getHeard());
         assertEquals(1, persons[6].getSongList().get(0).getHeard());
         assertEquals(0, persons[7].getSongList().get(0).getHeard());
         
        //System.out.println(persons[1].getHobby());
        System.out.println(persons[0].getSongList().get(0).toString());
        
        //System.out.println(persons[0].getSongList().get(0).toString());
        assertEquals(1, persons[0].getSongList().get(0).getHeard());
        assertEquals(1, persons[0].getSongList().get(0).getLiked());
        
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
    
    /**
     * Tests that a ParseException is thrown.
     */
    public void testReadSongFileException()
    {
        Exception thrown = null;
        
      //  try {
             
          //  }
      //  }

       // catch (Exception exception) {
       //     thrown = exception;
       // }
       // assertNotNull(thrown);
        //assertTrue(thrown instanceof ParseException);
    }
 
}
