// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- cmangin

package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * This class holds the main method which launches the GUI Music Window.
 *
 * @author Conner Mangin (cmangin)
 * @version 2019.04.14
 */
public class Input {

    /**
     * This main method launches the GUI Window.
     */
    public static void main(String[] args)
    {
        //System.out.println(args.length);
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
}
