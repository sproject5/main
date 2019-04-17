// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;
import student.TestCase;

/*   
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)

 */

/**
 * Tests the song class
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */
public class SongTest extends TestCase
{
    private Song song;
    
    /**
     * Sets up before each test class is ran
     */
    public void setUp()
    {
        song = new Song("The Killers", "All These Things I've Done", 
            "alternative", 2005);
    }
    
    /**
     * Test the getArtistName method
     */
    public void testGetAristName()
    {
        assertEquals(song.getArtistName(), "The Killers");
    }
    
    /**
     * Test the getSongTitle method
     */
    public void testGetSongTitle()
    {
        assertEquals(song.getSongTitle(), "All These Things I've Done");
    }
    
    /**
     * Test the getGenre method
     */
    public void testGetGenre()
    {
        assertEquals(song.getGenre(), "alternative");
    }
    
    /**
     * Test the getDate method
     */
    public void testGetDate()
    {
        assertEquals(song.getDate(), 2005);
    }
    
    /**
     * Test the getLiked and the addLiked method
     */
    public void testAddLiked()
    {
        assertEquals(song.getLiked(), 50);
        //song.addLiked();
        assertEquals(song.getLiked(), 51);
    }
    
    /**
     * Test the getHeard and addHeard method
     */
    public void testAddHeard()
    {
        assertEquals(song.getHeard(), 100);
        //song.addHeard();
        assertEquals(song.getHeard(), 101);
    }

    /**
     * Test the toString method
     */
    public void testToString()
    {
        assertEquals(song.toString(), "Title: All These Things I've Done; "
            + "Artist: The Killers; Genre: Alternative; Date: 2005;"
            + " Liked: 50; Heard: 100");
    }
}

