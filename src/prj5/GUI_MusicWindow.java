/* Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)

 */
package prj5;

import java.awt.Color;
import java.awt.Rectangle;
import java.text.DecimalFormat;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
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
        
        int glyph_X = 50;
        int glyph_Y = 50;
        
        //This creates the practice glyph
        Shape vertical = new Shape(glyph_X, glyph_Y+10, 10, 60, Color.BLACK);
        Shape horizontal1 = new Shape(glyph_X-25, glyph_Y+20, 25, 10, Color.PINK);
        Shape horizontal2 = new Shape(glyph_X-25, glyph_Y+30, 25, 10, Color.BLUE);
        Shape horizontal3 = new Shape(glyph_X-25, glyph_Y+40, 25, 10, Color.YELLOW);
        Shape horizontal4 = new Shape(glyph_X-25, glyph_Y+50, 25, 10, Color.GREEN);
        Shape horizontal5 = new Shape(glyph_X+10, glyph_Y+20, 25, 10, Color.PINK);
        Shape horizontal6 = new Shape(glyph_X+10, glyph_Y+30, 25, 10, Color.BLUE);
        Shape horizontal7 = new Shape(glyph_X+10, glyph_Y+40, 25, 10, Color.YELLOW);
        Shape horizontal8 = new Shape(glyph_X+10, glyph_Y+50, 25, 10, Color.GREEN);
        TextShape title = new TextShape(glyph_X-30, glyph_Y-30, "Cizza Pizza", Color.BLACK);
        title.setBackgroundColor(Color.WHITE);
        TextShape artist = new TextShape(glyph_Y-20, glyph_Y-13, "by Crew", Color.BLACK);
        artist.setBackgroundColor(Color.WHITE);
        
        //this places the practice glyph
        this.window.addShape(vertical);
        this.window.addShape(horizontal1);
        this.window.addShape(horizontal2);
        this.window.addShape(horizontal3);
        this.window.addShape(horizontal4);
        this.window.addShape(horizontal5);
        this.window.addShape(horizontal6);
        this.window.addShape(horizontal7);
        this.window.addShape(horizontal8);
        this.window.addShape(title);
        this.window.addShape(artist);
        
        
        //This creates the Legend
        TextShape majorLegend = new TextShape(600, 140, "Major Legend", Color.BLACK);
        majorLegend.setBackgroundColor(Color.WHITE);
        TextShape major1 = new TextShape(600, 160, "Comp Sci", Color.PINK);
        major1.setBackgroundColor(Color.WHITE);
        TextShape major2 = new TextShape(600, 180, "Other Eng", Color.BLUE);
        major2.setBackgroundColor(Color.WHITE);
        TextShape major3 = new TextShape(600, 200, "Math/CMDA", Color.YELLOW);
        major3.setBackgroundColor(Color.WHITE);
        TextShape major4 = new TextShape(600, 220, "Other", Color.GREEN);
        major4.setBackgroundColor(Color.WHITE);
        
        TextShape songTitle = new TextShape(615, 240, "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        TextShape heard = new TextShape(600, 270, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        Shape verticalLegend = new Shape(650, 260, 5, 40, Color.BLACK);
        TextShape liked = new TextShape(660, 270, "Likes", Color.BLACK);
        liked.setBackgroundColor(Color.WHITE);
        
        //rectangle
        Shape top = new Shape(580, 135, 130, 5 , Color.BLACK);
        Shape bottom = new Shape(580, 305, 130, 5 , Color.BLACK);
        Shape left = new Shape(580, 135, 5, 170 , Color.BLACK);
        Shape right = new Shape(710, 135, 5 , 175 , Color.BLACK);

        this.window.addShape(top);
        this.window.addShape(bottom);
        this.window.addShape(left);
        this.window.addShape(right);
        
        
        //This places the Legend
        this.window.addShape(majorLegend);
        this.window.addShape(major1);
        this.window.addShape(major2);
        this.window.addShape(major3);
        this.window.addShape(major4);
        this.window.addShape(songTitle);
        this.window.addShape(heard);
        this.window.addShape(verticalLegend);
        this.window.addShape(liked);
        
        
        
        
        
        
        
        
        
    }
    /**
     * Takes the survey input and generates the output based on hobby sorted based
     * on title and genre of the song
     * @param input
     */
    public GUI_MusicWindow(SurveySorter input)
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

    }


}

