/**
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)

 */
package prj5;

import java.text.DecimalFormat;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * This class creates the window in which the data will be displayed, 
 * and observes the SurveySorter class given to it by the main method present 
 * in ProjectRunner. The MusicWindow contains methods that support 
 * the use of the sort and representation buttons.
 *
 * @author Drew Pompeii (drewp24)
 * @version 2019.04.16
 */

public class GUI_MusicWindow 
{
    private Window window;
    private Button prev;
    private Button next;
    private Button quit;
    private Button sortByArtistName;
    private Button sortBySongTitle;
    private Button sortByReleaseYear;
    private Button sortByGenre;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private int pageNumber;


    private SurveySorter survey;
    
    /**
     * This is the constructor for the MusicWindow
     * Allows users to interact with song statistics
     * and sort songs based on certain information
     */
    public GUI_MusicWindow( )
    {
        
        window = new Window("Project 5");
        
        prev = new Button(" <- Prev");
        window.addButton(prev, WindowSide.NORTH);
        
        sortByArtistName = new Button("Sort by Artist Name");
        window.addButton(sortByArtistName, WindowSide.NORTH);
        
        sortBySongTitle = new Button("Sort by Song Title");
        window.addButton(sortBySongTitle, WindowSide.NORTH);
        
        sortByReleaseYear = new Button("Sort by Release Year");
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        
        sortByGenre = new Button("Sort by Genre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        
        next = new Button("Next ->");
        window.addButton(next, WindowSide.NORTH);
        
        representHobby = new Button("Represent Hobby");
        window.addButton(representHobby, WindowSide.SOUTH);
        
        representMajor = new Button("Represent Major");
        window.addButton(representMajor, WindowSide.SOUTH);
        
        representRegion = new Button("Represent Region");
        window.addButton(representRegion, WindowSide.SOUTH);
        
        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
    }

    public GUI_MusicWindow( SurveySorter input)
    {
        //this();
        survey = input;
        //System.out.println( survey.getSongList().toString());
        
        this.clickedSortByGenre();
        this.clickedSortBySongTitle();
    }

    public void clickedSortBySongTitle()
    {
        SongList songList = survey.getSongList();
        DLList<String> sortedList = songList.sortBySongTitle();

        for( int i = 0; i < sortedList.size() ; i++)
        {
            String songName = sortedList.get(i);
            //System.out.println(songName);
            DecimalFormat df = new DecimalFormat("0");

            String heard = "\nheard \n" 
                + "reading" + df.format(survey.DataOf(songName, Hobby.READ, true))
                + " art" + df.format(survey.DataOf(songName, Hobby.ART, true))
                + " sports" + df.format(survey.DataOf(songName, Hobby.SPORTS, true))
                + " music" + df.format(survey.DataOf(songName, Hobby.MUSIC, true));
            
            String like = "\nlikes \n" 
                + "reading" + df.format(survey.DataOf(songName, Hobby.READ, false))
                + " art" + df.format(survey.DataOf(songName, Hobby.ART, false))
                + " sports" + df.format(survey.DataOf(songName, Hobby.SPORTS, false))
                + " music" + df.format(survey.DataOf(songName, Hobby.MUSIC, false)) + " \n";
            
            System.out.println(survey.getSongInLowerCase(songName, songList).toStringTest() + heard + like);
        
        }

        //System.out.println(sortedList.toString());

    }


    public void clickedSortByGenre()
    {
        SongList songList = survey.getSongList();
        DLList<String> sortedList = songList.sortByGenre();

        for( int i = 0; i < sortedList.size() ; i++)
        {
            String genre = sortedList.get(i);
            SongList<Song> tempSongList = survey.getSongByGenre(genre, songList);
            for (int j = 0; j < tempSongList.size()  ; j++)
            {
                
                
                Song temp = tempSongList.get(j);
                String songName = temp.getSongTitle().toLowerCase();
                DecimalFormat df = new DecimalFormat("0");
                String heard = "\nheard \n" 
                + "reading" + df.format(survey.DataOf(songName, Hobby.READ, true))
                + " art" + df.format(survey.DataOf(songName, Hobby.ART, true))
                + " sports" + df.format(survey.DataOf(songName, Hobby.SPORTS, true))
                + " music" + df.format(survey.DataOf(songName, Hobby.MUSIC, true));
            
                String like = "\nlikes \n" 
                    + "reading" + df.format(survey.DataOf(songName, Hobby.READ, false))
                    + " art" + df.format(survey.DataOf(songName, Hobby.ART, false))
                    + " sports" + df.format(survey.DataOf(songName, Hobby.SPORTS, false))
                    + " music" + df.format(survey.DataOf(songName, Hobby.MUSIC, false)) + " \n";
                
                System.out.println(survey.getSongInLowerCase(songName, songList).toStringTest() + heard + like);
        
            }
            
            
        }

        //System.out.println(sortedList.toString());

    }
    

}
