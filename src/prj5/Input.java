package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {


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
