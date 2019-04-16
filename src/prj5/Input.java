package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {


    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        SurveySorter survey = new SurveySorter(args[1], args[0]);
    }
}
