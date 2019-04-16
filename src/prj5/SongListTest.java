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
 * Tests the methods and constructors in the SongList class
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */
public class SongListTest extends student.TestCase
{
    private SongList<Song> songList;
    private DLList<Song> dList;
    private Song marx;
    private Song conner;
    private Song ruba;
    private Song drew;
    
    /**
     * Sets up before each test case is ran
     */
    public void setUp()
    {
        dList = new DLList<Song>();
        songList = new SongList<Song>(dList);
        marx = new Song("Marx Wang", "Rockstar Marx", "Rock", 1971, 70, 100);
        conner = new Song("Conner Mangin", "Conner Yay", "Country", 2004, 56, 75);
        ruba = new Song("Ruba Shawkat", "Love song", "R&B", 1995, 100, 200);
        drew = new Song("Drew Pompeii", "Pizza Pizza", "Rock", 1995, 25, 50);
        
        songList.add(marx);
        songList.add(conner);
        songList.add(ruba);
        songList.add(drew);
    }
    
    /**
     * Test the sortByArtistName method
     */
    public void testSortByArtistName()
    {
        songList.sortByArtistName();
        assertEquals(songList.get(0), conner);
        assertEquals(songList.get(1), drew);
        assertEquals(songList.get(2), marx);
        assertEquals(songList.get(3), ruba);
    }
    
    /**
     * Test the sortBySongTitle method
     */
    public void testSortBySongTitle()
    {
        songList.sortBySongTitle();
        assertEquals(songList.get(0), conner);
        assertEquals(songList.get(1), ruba);
        assertEquals(songList.get(2), drew);
        assertEquals(songList.get(3), marx);
    }
    
    /**
     * Test the sortByReleaseYear method
     */
    public void testSortByReleaseYear()
    {
        songList.sortByReleaseYear();
        assertEquals(songList.get(0), marx);
        assertEquals(songList.get(1), ruba);
        assertEquals(songList.get(2), drew);
        assertEquals(songList.get(3), conner);
        
        //conner
        
    }
    
    /**
     * Test the sortByGenre method
     */
    public void testSortByGenre()
    {
        songList.sortByGenre();
        assertEquals(songList.get(0), ruba);
        assertEquals(songList.get(1), conner);
        assertEquals(songList.get(2), marx);
        assertEquals(songList.get(3), drew);
    }
}