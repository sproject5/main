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
        reader = new SongReader("SongList2018.csv", "MusicSurveyData2018.csv");
    }

    /**
     * 
     */
    public void testReadSongFile() 
    {
        DLList<Song> songList = reader.getSongList();
        System.out.println(songList.get(10).getArtistName());
        System.out.println(songList.get(10).getSongTitle());
        //System.out.println(songList.size());
 
        Person[] persons = reader.getPersonList();
        //System.out.println(persons[1].getHobby());
        
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
