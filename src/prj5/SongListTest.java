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
        marx = new Song("marx wang", "rockstar marx", "Rock", 1971);
        conner = new Song("conner mangin", "conner yay", "Country", 2004);
        ruba = new Song("ruba shawkat", "cove song", "EDM", 1995);
        drew = new Song("drew pompeii", "cizza pizza", "Rock", 1995);
        
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
     * Test the getSortedByArtistName method
     */
    public void testGetSortedByArtistName()
    {
        assertEquals(songList.getSortedByArtistName().get(0), conner);
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
     * Test the getSortedByTitle method
     */
    public void testGetSortedByTitle()
    {
        assertEquals(songList.getSortedByTitle().get(0), drew);
    }
    
    /**
     * Test the sortByReleaseYear method
     */
    public void testSortByReleaseYear()
    {
        DLList<Integer> yearList = songList.sortByReleaseYear();
        assertTrue(yearList.get(0).equals(marx.getDate()));
        assertTrue(yearList.get(1).equals(ruba.getDate()));
        assertTrue(yearList.get(2).equals(drew.getDate()));
        assertTrue(yearList.get(3).equals(conner.getDate()));
    }
    
    /**
     * Test the getSortedByYear method
     */
    public void testGetSortedByYear()
    {
        assertEquals(songList.getSortedByYear().get(0), marx);
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
     * Test the getSortedByGenre method
     */
    public void testGetSortedByGenre()
    {
        assertEquals(songList.getSortedByGenre().get(0), conner);
    }
    
    /**
     * Tests the heardToYes and likedToYes method
     */
    public void testHeardAndLikedToYes()
    {
        
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: -1", list.get(0).toString());

        list.heardToYes(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: 1", list.get(0).toString());
        list.likedToYes(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: 1; Heard: 1", list.get(0).toString());
    }
    
    /**
     * Tests the heardToNo and likedToNo method
     */
    public void testHeardAndLikedToNo()
    {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: -1", list.get(0).toString());

        list.heardToNo(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: 0", list.get(0).toString());
        list.likedToNo(0);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: 0; Heard: 0", list.get(0).toString());
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "goodBye", "jazz", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: -1\n", list.toString());
        
        song = new Song("jack2", "goodBye2", "jazz2", 1999);
        list.add(song);
        assertEquals("Title: goodBye; Artist: jack; Genre: jazz; Date: 1999; "
            + "Liked: -1; Heard: -1\n" + 
            "Title: goodBye2; Artist: jack2; Genre: jazz2; Date: 1999; "
            + "Liked: -1; Heard: -1\n", list.toString());
    }

    /**
     * Tests the getSongInLowerCase method.
     */
    public void testGetSongInLowerCase() {
        SongList<Song> list = new SongList<Song>();
        Song song = new Song("jack", "CIZZA PIZZA", "jazz", 2006);
        list.add(song);

        assertEquals(list.getSongInLowerCase("cizza pizza"), song);

    }
}