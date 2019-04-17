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
 * 
 */

/**
 * Tests the song class
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */
public class SongTest extends TestCase {
    private Song song;


    /**
     * Sets up before each test class is ran
     */
    public void setUp() {
        song = new Song("The Killers", "All These Things I've Done",
            "Alternative", 2005);
    }


    /**
     * Test the getArtistName method
     */
    public void testGetAristName() {
        assertEquals(song.getArtistName(), "The Killers");
    }


    /**
     * Test the getSongTitle method
     */
    public void testGetSongTitle() {
        assertEquals(song.getSongTitle(), "All These Things I've Done");
    }


    /**
     * Test the getGenre method
     */
    public void testGetGenre() {
        assertEquals(song.getGenre(), "Alternative");
    }


    /**
     * Test the getDate method
     */
    public void testGetDate() {
        assertEquals(song.getDate(), 2005);
    }


    /**
     * Test the getLiked and the addLiked method
     */
    public void testHeardAndLikeIsNo() {
        assertEquals(song.getLiked(), -1);
        song.likedIsNo();
        assertEquals(song.getLiked(), 0);
        assertEquals(song.getHeard(), -1);
        song.heardIsNo();
        assertEquals(song.getHeard(), 0);

    }


    /**
     * Test the getHeard and addHeard method
     */
    public void testHeardAndLikeIsYes() {
        assertEquals(song.getLiked(), -1);
        song.likedIsYes();
        assertEquals(song.getLiked(), 1);
        assertEquals(song.getHeard(), -1);
        song.heardIsYes();
        assertEquals(song.getHeard(), 1);
    }


    /**
     * Test the toString method
     */
    public void testToString() {
        assertEquals(song.toString(), "Title: All These Things I've Done; "
            + "Artist: The Killers; Genre: Alternative; Date: 2005;"
            + " Liked: -1; Heard: -1");
    }
    /**
     * This tests the testToStringTest method.
     */
    public void testToStringTest()
    {
        assertEquals(song.toStringTest(), "song title All These Things I've"
            + " Done" + "\n" + "song artist The Killers" + "\n" + "song "
                + "genre Alternative" + "\n" +  "song year 2005");
    }
}
