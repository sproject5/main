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
    
    /**
     * This is the constructor for the MusicWindow
     * Allows users to interact with song statistics
     * and sort songs based on certain information
     */
    public GUI_MusicWindow()
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
}
