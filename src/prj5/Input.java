package prj5;

/**
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Ruba Shawkat (rubas8)
 * 
 */

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author rubas8
 *         This class displays the Music Window and implements the visual
 *         elements of the GUI
 *
 */
public class Input {

    /**
     * This method creates the window
     * 
     * @param args
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException {
 
        if (args.length > 0) {
            try {
                SongReader reader = new SongReader(args[1], args[0]);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            SongReader reader = new SongReader("SongList2018.csv",
                "MusicSurveyData2018.csv");
        }

    }
}