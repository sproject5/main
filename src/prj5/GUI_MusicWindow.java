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

public class GUI_MusicWindow {
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

    private final String[] Attributes;

    /**
     * This is the constructor for the MusicWindow
     * Allows users to interact with song statistics
     * and sort songs based on certain information
     */
    public GUI_MusicWindow() {

        Attributes = new String[]{"reading", "art", "music", "sports",
        "Computer Science", "Math or CMDA", "Other", "Other Engineering",
        "Northeast", "Outside of United States", "Southeast", "United States (other than Southeast or Northwest)"};


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

        int vertWidth = 5;
        int vertLength = 40;
        int horWidth = 10;



        this.legendBuild();

        
    }


    /**
     * Takes the survey input and generates the output based on hobby sorted
     * based
     * on title and genre of the song
     * 
     * @param input
     */
    public GUI_MusicWindow(SurveySorter input) {
        this();
        survey = input;

        buildShape("Can You Feel the Love Tonight", "Hobby", 0);
        buildShape("Can You Feel the Love Tonight", "Hobby", 1);
        buildShape("Can You Feel the Love Tonight", "Hobby", 2);

        buildShape("Can You Feel the Love Tonight", "Hobby", 3);
        buildShape("Can You Feel the Love Tonight", "Hobby", 4);
        buildShape("Can You Feel the Love Tonight", "Hobby", 5);

        buildShape("Can You Feel the Love Tonight", "Hobby", 6);
        buildShape("Can You Feel the Love Tonight", "Hobby", 7);
        buildShape("Can You Feel the Love Tonight", "Hobby", 8);
        //buildShape("Can You Feel the Love Tonight", "Hobby", 6);


        //System.out.println( survey.getSongList().toString());
        //this.clickedSortByGenre();
        //this.clickedSortBySongTitle();

    }


    /**
     * When clicked it will sort all the songs by artist name
     * in alphabetical order
     * 
     * @param button
     *            the button to be clicked to
     *            sort the songs by artist name
     */
    public void clickedSortByArtistName(Button button) {

    }


    /**
     * When clicked it will sort all the songs by it's release year
     * sorting from oldest to newest
     * 
     * @param button
     *            the button to be clicked to
     *            sort the songs by release year
     */
    public void clickedSortByReleaseYear(Button button) {

    }


    public void clickedSortBySongTitle() {
        SongList songList = survey.getSongList();
        DLList<String> sortedList = songList.sortBySongTitle();

        for (int i = 0; i < sortedList.size(); i++) {
            String songName = sortedList.get(i);



            // System.out.println(songName);
            DecimalFormat df = new DecimalFormat("0");

            String heard = "\nheard \n" + "reading" + df.format(survey.dataOf(
                songName, "reading", true)) + " art" + df.format(survey.dataOf(
                    songName, "art", true)) + " sports" + df.format(survey
                        .dataOf(songName, "sports", true)) + " music" + df
                            .format(survey.dataOf(songName, "music", true));

            String like = "\nlikes \n" + "reading" + df.format(survey.dataOf(
                songName, "reading", false)) + " art" + df.format(survey.dataOf(
                    songName, "art", false)) + " sports" + df.format(survey
                        .dataOf(songName, "sports", false)) + " music" + df
                            .format(survey.dataOf(songName, "music", false))
                + " \n";

            //System.out.println(survey.getSongInLowerCase(songName, songList)
            //    .toStringTest() + heard + like);

        }
    }


    public void clickedSortByGenre() 
    {
        SongList songList = survey.getSongList();
        DLList<String> sortedList = songList.sortByGenre();
        for (int i = 0; i < sortedList.size(); i++) {
            String genre = sortedList.get(i);
            SongList<Song> tempSongList = survey.getSongByGenre(genre,
                songList);
            for (int j = 0; j < tempSongList.size(); j++) {
                Song temp = tempSongList.get(j);
                String songName = temp.getSongTitle().toLowerCase();
                DecimalFormat df = new DecimalFormat("0");
                String heard = "\nheard \n" + "reading" + df.format(survey
                    .dataOf(songName, "reading", true)) + " art" + df.format(
                        survey.dataOf(songName, "art", true)) + " sports" + df
                            .format(survey.dataOf(songName, "sports", true))
                    + " music" + df.format(survey.dataOf(songName, "music",
                        true));

                String like = "\nlikes \n" + "reading" + df.format(survey
                    .dataOf(songName, "reading", false)) + " art" + df.format(
                        survey.dataOf(songName, "art", false)) + " sports" + df
                            .format(survey.dataOf(songName, "sports", false))
                    + " music" + df.format(survey.dataOf(songName, "music",
                        false)) + " \n";
                System.out.println(survey.getSongInLowerCase(songName, songList)
                    .toStringTest() + heard + like);

            }
        }

    }


    /**
     * When clicked it will show the statistics of the songs
     * in correlation to the hobbies people said was their favorite
     * 
     * @param button
     *            the button to be clicked to show the stats
     *            of the songs of the people's favorite hobbies
     */
    public void clickedRepresentHobby(Button button) {

    }


    /**
     * When clicked it will show the statistics of the songs
     * in correlation to people's majors
     * 
     * @param button
     *            the button to be clicked to show the stats
     *            of the songs of the people's majors
     */
    public void clickedRepresentMajor(Button button) {

    }


    /**
     * When clicked it will show the statistics of the songs
     * in correlation to where people reside
     * 
     * @param button
     *            the button to be clicked to show the stats
     *            of the songs of where people reside
     */
    public void clickedRepresentRegion(Button button) {

    }


    /**
     * Holds the behavior of the quitButton.
     * Exits the program when clicked.
     * 
     * @param quitButton
     *            the button to be clicked to quit the window
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }


    /**
     * Shows the previous data on the GUI window.
     * This button is disabled if its the first data displayed.
     * 
     * @param button
     *            the previous button
     */
    public void clickedPrevious(Button button) {

    }


    /**
     * Shows the next data on the GUI window.
     * This button is disabled if there's
     * no more data to be displayed.
     * 
     * @param button
     *            the next button
     */
    public void clickedNext(Button button) 
    {

    }
    
    public void buildShape(String title, String attributesTypes, int index)
    {
        title = title.toLowerCase();
        int glyph_X = index % 3 * 240 + 110;
        int glyph_Y =  index / 3 * 90 + 40;
        
        int stringIndex = 0;
        if (attributesTypes == "Major")
        {
            stringIndex = 4;
        }
        else if ( attributesTypes == "State")
        {
            stringIndex = 8;
        }

        Shape vertical = new Shape(glyph_X, glyph_Y + 5, 5, 50, Color.BLACK);
        
        this.window.addShape(vertical);

        for (int i = 0; i < 4; i++)
        {
            int width = (int)(survey.dataOf(title, Attributes[i+stringIndex], true) * 0.7);
            Shape horizontal = new Shape(glyph_X - width, glyph_Y + 10*(i+1), 
            width, 10, new Color(60, 60*i, 230));
            this.window.addShape(horizontal);
        }

        for (int i = 0; i < 4; i++)
        {
            int width = (int)(survey.dataOf(title, Attributes[i+stringIndex], false) * 0.7);
            Shape horizontal = new Shape(glyph_X, glyph_Y + 10*(i+1), 
            width, 10, new Color(60, 60*i, 230));
            this.window.addShape(horizontal);
        }

        TextShape textshape = new TextShape(glyph_X - 100, glyph_Y - 25,
            title.toUpperCase(), Color.BLACK);
        textshape.setBackgroundColor(Color.WHITE);
        TextShape artist = new TextShape(glyph_X - 20, glyph_Y - 10, "by Crew",
            Color.BLACK);
        artist.setBackgroundColor(Color.WHITE);

                
                this.window.addShape(textshape);
                this.window.addShape(artist);
    }

    public void legendBuild()
    {
        int xposition = 745;
        int yposition = 140;
        // This creates the Legend
        TextShape majorLegend = new TextShape(xposition, yposition, "Major Legend",
            Color.BLACK);
        majorLegend.setBackgroundColor(Color.WHITE);
        TextShape major1 = new TextShape(xposition + 5, yposition + 20, "Comp Sci", new Color(60, 0, 230));
        major1.setBackgroundColor(Color.WHITE);
        TextShape major2 = new TextShape(xposition+ 5, yposition + 40, "Other Eng", new Color(60, 60, 230));
        major2.setBackgroundColor(Color.WHITE);
        TextShape major3 = new TextShape(xposition+ 5, yposition + 60, "Math/CMDA", new Color(60, 120, 230));
        major3.setBackgroundColor(Color.WHITE);
        TextShape major4 = new TextShape(xposition+ 5, yposition + 80, "Other", new Color(60, 180, 230));
        major4.setBackgroundColor(Color.WHITE);

        TextShape songTitle = new TextShape(xposition + 15, 240, "Song Title",
            Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        TextShape heard = new TextShape(xposition, 270, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        Shape verticalLegend = new Shape(xposition + 50, 260, 5, 40, Color.BLACK);
        TextShape liked = new TextShape(xposition + 60, 270, "Likes", Color.BLACK);
        liked.setBackgroundColor(Color.WHITE);

        // rectangle
        Shape top = new Shape(xposition - 13, 135, 130, 5, Color.BLACK);
        Shape bottom = new Shape(xposition - 13, 305, 130, 5, Color.BLACK);
        Shape left = new Shape(xposition - 13, 135, 5, 170, Color.BLACK);
        Shape right = new Shape(xposition +110, 135, 5, 175, Color.BLACK);

        this.window.addShape(top);
        this.window.addShape(bottom);
        this.window.addShape(left);
        this.window.addShape(right);

        // This places the Legend
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
     
}
