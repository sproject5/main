/*
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
    private Song marx;
    private Song conner;
    private Song ruba;
    private Song drew;
    
    /**
     * Sets up before each test case is ran
     */
    public void setUp()
    {
        songList = new SongList<Song>();
        marx = new Song("Marx Wang", "Rockstar Marx", "Rock", 1971);
        conner = new Song("Conner Mangin", "Conner Yay", "Country", 2004);
        ruba = new Song("Ruba Shawkat", "Cove song", "EDM", 1995);
        drew = new Song("Drew Pompeii", "Cizza Pizza", "Rock", 1995);
        
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
        //System.out.println(songList.sortByArtistName());
        DLList<String> artistList = songList.sortByArtistName();
        assertEquals(artistList.get(0), conner.getArtistName());
        assertEquals(artistList.get(0), conner.getArtistName());
        assertEquals(artistList.get(1), drew.getArtistName());
        assertEquals(artistList.get(2), marx.getArtistName());
        assertEquals(artistList.get(3), ruba.getArtistName());
    }
    
    /**
     * Test the sortBySongTitle method
     */
    public void testSortBySongTitle()
    {
        DLList<String> songTitleList = songList.sortBySongTitle();
        assertEquals(songTitleList.get(0), drew.getSongTitle());
        assertEquals(songTitleList.get(1), conner.getSongTitle());
        assertEquals(songTitleList.get(2), ruba.getSongTitle());
        assertEquals(songTitleList.get(3), marx.getSongTitle());
    }
    
    /**
     * Test the sortByReleaseYear method
     */
    public void testSortByReleaseYear()
    {
        DLList<Integer> yearList = songList.sortByReleaseYear();
        assertTrue(yearList.get(0) == marx.getDate());
        assertTrue(yearList.get(1) == ruba.getDate());
        assertTrue(yearList.get(2) == drew.getDate());
        assertTrue(yearList.get(3) == conner.getDate());
        
        
    }
    
    /**
     * Test the sortByGenre method
     */
    public void testSortByGenre()
    {
        DLList<String> genreList = songList.sortByGenre();
        assertEquals(genreList.get(0), conner.getGenre());
        assertEquals(genreList.get(1), ruba.getGenre());
        assertEquals(genreList.get(2), marx.getGenre());
        assertEquals(genreList.get(3), drew.getGenre());
    }
    
    /**
     * Tests the incrementHeard and incrementLiked method
     */
    public void testIncrementHeard()
    {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 0", list.get(0).toString());

        //list.incrementHeard(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 1", list.get(0).toString());
        //list.incrementLike(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 1; Heard: 1", list.get(0).toString());
    }
    
    /**
     * Tests the decrementHeard and decrementLiked method
     */
    public void testDecrementHeard()
    {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 1; Heard: 1", list.get(0).toString());

        //list.decrementLike(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 1", list.get(0).toString());
        //list.decrementHeard(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 0", list.get(0).toString());
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 0\n", list.toString());
        
        song = new Song("jack2", "goodBye2", "jazz2", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; Liked: 0; Heard: 0\n" + 
            "Title: goodBye2; Artist: jack2; Genre: jazz2; Date: 1999; Liked: 0; Heard: 0\n", list.toString());
    }
}