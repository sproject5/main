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
import java.util.Iterator;
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
    private boolean orderInit;

    private SurveySorter survey;

    private final String[] Attributes;
    private final Color[] Colors;
    private SongList<Song> initialSongList;
    private SongList<Song> currentSongList;
    private String representKey;
    private String currSortedType;


    /**
     * This is the constructor for the MusicWindow
     * Allows users to interact with song statistics
     * and sort songs based on certain information
     */
    public GUI_MusicWindow() {

        Attributes = new String[] { "reading", "art", "sports", "music",
            "Computer Science", "Other Engineering", "Math or CMDA", "Other",
            "Northeast", "Outside of United States", "Southeast",
            "United States (other than Southeast or Northwest)" };
        Colors = new Color[] { Color.PINK, Color.BLUE, Color.YELLOW,
            Color.GREEN };
        window = new Window("Project 5");
        orderInit = false;
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
        initialSongList = survey.getSongList();
        representKey = "Hobby";
        currSortedType = "ArtistName";

        this.buildLegend(representKey);
        this.buildButton();

        sortByArtistName.onClick(this, "clickedSortByArtistName");
        sortBySongTitle.onClick(this, "clickedSortByTitle");
        sortByReleaseYear.onClick(this, "clickedSortByReleaseYear");
        sortByGenre.onClick(this, "clickedSortByGenre");

        representHobby.onClick(this, "clickedRepresentHobby");
        representMajor.onClick(this, "clickedRepresentMajor");
        representRegion.onClick(this, "clickedRepresentRegion");

        prev.onClick(this, "clickedPrevious");
        next.onClick(this, "clickedNext");
        quit.onClick(this, "clickedQuit");

        // System.out.println( survey.getSongList().toString());
        this.clickedSortByGenreTest();
        this.clickedSortBySongTitleTest();
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
        currentSongList = initialSongList.getSortedByArtistName();
        window.removeAllShapes();
        currSortedType = "ArtistName";
        pageNumber = 0;
        this.updateGlyph(currSortedType, representKey);

    }


    /**
     * When clicked it will sort all the songs by artist name
     * in alphabetical order
     * 
     * @param button
     *            the button to be clicked to
     *            sort the songs by artist name
     */
    public void clickedSortByTitle(Button button) {
        currentSongList = initialSongList.getSortedByTitle();
        window.removeAllShapes();
        currSortedType = "Title";
        pageNumber = 0;
        this.updateGlyph(currSortedType, representKey);
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
        currentSongList = initialSongList.getSortedByYear();
        window.removeAllShapes();
        currSortedType = "Year";
        pageNumber = 0;
        this.updateGlyph(currSortedType, representKey);

    }


    /**
     * Sorts the data by song title in this call.
     */
    public void clickedSortBySongTitleTest() {
        SongList<Song> songList = initialSongList.getSortedByTitle();
        for (int i = 0; i < songList.size(); i++) {
            String songName = songList.get(i).getSongTitle().toLowerCase();

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

            System.out.println(survey.getSongInLowerCase(songName, songList)
                .toStringTest() + heard + like);

        }
    }


    /**
     * Sorts the data by genre in this button.
     * 
     * @param button
     *            the button in the window.
     */
    public void clickedSortByGenre(Button button) {
        currentSongList = initialSongList.getSortedByGenre();
        window.removeAllShapes();
        currSortedType = "Genre";
        pageNumber = 0;
        this.updateGlyph(currSortedType, representKey);

    }


    /**
     * Updates the glyphs in the window.
     * 
     * @param sortedType
     *            the sorted data
     * @param representKey
     *            the attribute
     */
    public void updateGlyph(String sortedType, String representKey) {

        if (currentSongList != null && pageNumber >= 0) {
            Iterator<Song> Iter = currentSongList.iterator();
            int i = 0;
            while (Iter.hasNext() && i < 9 * (pageNumber + 1)) {
                String songTitle = Iter.next().getSongTitle();
                if (i >= 9 * pageNumber) {
                    this.buildShape(songTitle, representKey, sortedType, i % 9);
                }
                i++;

            }
        }
        this.buildLegend(representKey);
    }


    /**
     * Sorts the data by genre in this call.
     */
    public void clickedSortByGenreTest() {
        SongList songList = initialSongList.getSortedByGenre();

        /*
         * for (int i = 0; i < sortedList.size(); i++) {
         * String genre = sortedList.get(i);
         * SongList<Song> tempSongList = survey.getSongByGenre(genre,
         * songList);
         */

        for (int j = 0; j < songList.size(); j++) {
            Song temp = (Song)songList.get(j);
            String songName = temp.getSongTitle().toLowerCase();
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
            System.out.println(survey.getSongInLowerCase(songName, songList)
                .toStringTest() + heard + like);

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
        representKey = "Hobby";
        window.removeAllShapes();
        this.updateGlyph(currSortedType, representKey);
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
        representKey = "Major";
        window.removeAllShapes();
        this.updateGlyph(currSortedType, representKey);
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
        representKey = "State";
        window.removeAllShapes();
        this.updateGlyph(currSortedType, representKey);
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
        window.removeAllShapes();

        if (currentSongList != null && pageNumber > 0) {
            pageNumber--;
        }
        updateGlyph(currSortedType, representKey);
    }


    /**
     * Shows the next data on the GUI window.
     * This button is disabled if there's
     * no more data to be displayed.
     * 
     * @param button
     *            the next button
     */
    public void clickedNext(Button button) {
        window.removeAllShapes();

        if (currentSongList != null && pageNumber < currentSongList.size() / 9
            - 1) {
            pageNumber++;
        }
        updateGlyph(currSortedType, representKey);
    }


    /**
     * Builds the glyphs for the window.
     * 
     * @param title
     *            the title
     * @param attributesTypes
     *            type of attributes
     * @param sortedType
     *            sorted data
     * @param index
     *            the position
     */
    public void buildShape(
        String title,
        String attributesTypes,
        String sortedType,
        int index) {

        Song curSong = currentSongList.getSongInLowerCase(title.toLowerCase());
        title = title.toLowerCase();
        int glyph_X = index % 3 * 240 + 130;
        int glyph_Y = index / 3 * 90 + 40;

        int stringIndex = 0;
        if (attributesTypes == "Major") {
            stringIndex = 4;
        }
        else if (attributesTypes == "State") {
            stringIndex = 8;
        }

        Shape vertical = new Shape(glyph_X, glyph_Y + 5, 5, 50, Color.BLACK);

        this.window.addShape(vertical);

        for (int i = 0; i < 4; i++) {
            int width = (int)(survey.dataOf(title, Attributes[i + stringIndex],
                true) * 0.7);
            Shape horizontal = new Shape(glyph_X - width, glyph_Y + 10 * (i
                + 1), width, 10, Colors[i]);
            this.window.addShape(horizontal);
        }

        for (int i = 0; i < 4; i++) {
            int width = (int)(survey.dataOf(title, Attributes[i + stringIndex],
                false) * 0.7);
            Shape horizontal = new Shape(glyph_X, glyph_Y + 10 * (i + 1), width,
                10, Colors[i]);
            this.window.addShape(horizontal);
        }

        TextShape textshape = new TextShape(glyph_X - 10, glyph_Y - 25, title
            .toUpperCase(), Color.BLACK);
        textshape.setBackgroundColor(Color.WHITE);
        textshape.setX(glyph_X - textshape.getWidth() / 2);
        this.window.addShape(textshape);

        String label = "By " + curSong.getArtistName();

        if (sortedType.equals("Year")) {
            label = "year: " + curSong.getDate();
        }
        else if (sortedType.equals("Genre")) {
            label = "genre: " + curSong.getGenre();
        }

        TextShape labelShape = new TextShape(glyph_X - 30, glyph_Y - 10, label,
            Color.BLACK);
        labelShape.setX(glyph_X - labelShape.getWidth() / 2);
        labelShape.setBackgroundColor(Color.WHITE);

        this.window.addShape(labelShape);
    }


    /**
     * Builds the legend for the window.
     * 
     * @param representKey
     *            the attribute
     */
    public void buildLegend(String representKey) {
        int xposition = 745;
        int yposition = 140;
        // This creates the Legend
        String title = "Hobby Legend";
        String legend1 = "Read";
        String legend2 = "Art";
        String legend3 = "Sports";
        String legend4 = "Music";

        if (representKey.equals("Major")) {
            legend1 = "Comp Sci";
            legend2 = "Other Eng";
            legend3 = "Math/CMDA";
            legend4 = "Other";
        }
        else if (representKey.equals("State")) {
            legend1 = "Northeast";
            legend2 = "Out of US";
            legend3 = "Southeast";
            legend4 = "US";
        }
        TextShape majorLegend = new TextShape(xposition, yposition, title,
            Color.BLACK);
        majorLegend.setBackgroundColor(Color.WHITE);
        TextShape major1 = new TextShape(xposition + 5, yposition + 20, legend1,
            Color.PINK);
        major1.setBackgroundColor(Color.WHITE);
        TextShape major2 = new TextShape(xposition + 5, yposition + 40, legend2,
            Color.BLUE);
        major2.setBackgroundColor(Color.WHITE);
        TextShape major3 = new TextShape(xposition + 5, yposition + 60, legend3,
            Color.YELLOW);
        major3.setBackgroundColor(Color.WHITE);
        TextShape major4 = new TextShape(xposition + 5, yposition + 80, legend4,
            Color.GREEN);
        major4.setBackgroundColor(Color.WHITE);

        TextShape songTitle = new TextShape(xposition + 15, 240, "Song Title",
            Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        TextShape heard = new TextShape(xposition, 270, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        Shape verticalLegend = new Shape(xposition + 50, 260, 5, 40,
            Color.BLACK);
        TextShape liked = new TextShape(xposition + 60, 270, "Likes",
            Color.BLACK);
        liked.setBackgroundColor(Color.WHITE);

        // rectangle
        Shape top = new Shape(xposition - 13, 135, 130, 5, Color.BLACK);
        Shape bottom = new Shape(xposition - 13, 305, 130, 5, Color.BLACK);
        Shape left = new Shape(xposition - 13, 135, 5, 175, Color.BLACK);
        Shape right = new Shape(xposition + 115, 135, 5, 175, Color.BLACK);

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


    /**
     * Adds the buttons to the window and names them.
     */
    public void buildButton() {
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
