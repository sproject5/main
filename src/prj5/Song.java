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
 * These objects contain information about the song. 
 * These will also be where liked and heard data will be kept track of.
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */
public class Song 
{
    private String artistName;
    private String songTitle;
    private String genre;
    private int date;
    private int liked;
    private int heard;
    
    /**
     * The constructor for the Song class
     * @param artistName  the name of the arist
     * @param songTitle  the title of the song
     * @param genre  the genre of the song
     * @param date  the song's release year
     * @param liked  the amount of likes the song has
     * @param heard  the amount of people who have heard the song
     */
    public Song(String artistName, String songTitle, String genre,
        int date, int liked, int heard)
    {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.genre = genre;
        this.date = date;
        this.liked = liked;
        this.heard = heard;
    }
    
    /**
     * Gets the name of the artist for the song
     * @return the name of the artist
     */
    public String getArtistName()
    {
        return artistName;
    }
    
    /**
     * Gets the song title of the song
     * @return the song title
     */
    public String getSongTitle()
    {
        return songTitle;
    }
    
    /**
     * Gets the genre of the song
     * @return the genre
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * Gets the year the song was released
     * @return the year
     */
    public int getDate()
    {
        return date;
    }
    
    /**
     * Gets how many likes the song received
     * @return the number of likes
     */
    public int getLiked()
    {
        return liked;
    }
    
    /**
     * Gets how many people heard the song
     * @return the amount of people who heard the song
     */
    public int getHeard()
    {
        return heard;
    }
    
    /**
     * Adds a like to the song when someone likes the song
     */
    public void addLiked()
    {
        liked++;
    }
    
    /**
     * Add a heard to the song when someone has heard the song
     */
    public void addHeard()
    {
        heard++;
    }


    /**
     * return the content of this song
     * @return the string content of this song
     */
    public String toString()
    {
        return "Title: " + songTitle + "; Artist: " 
            + artistName + "; Genre: "  + genre
            + "; Date: " + date + "; Liked: " + liked
            + "; Heard: " + heard;
    }

}

