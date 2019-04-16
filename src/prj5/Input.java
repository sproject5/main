package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {


    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        //System.out.println(args.length);
        SongReader reader = new SongReader(args[1], args[0]);
    }
}
