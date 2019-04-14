package prj5;

public class SongTest 
{
    * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)

 */
package prj5;

/**
 * Tests the song class
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */
public class SongTest extends student.TestCase
{
    private Song song;
    
    /**
     * Sets up before each test class is ran
     */
    public void setUp()
    {
        song = new Song("The Killers", "All These Things I've Done", 
            "alternative", 2005, 50, 100);
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
        song.addLiked();
        assertEquals(song.getLiked(), 51);
    }
    
    /**
     * Test the getHeard and addHeard method
     */
    public void testAddHeard()
    {
        assertEquals(song.getHeard(), 100);
        song.addHeard();
        assertEquals(song.getHeard(), 101);
    }
}

