// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself 
// with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Boyuan

package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bsh.ParseException;
/**
 * this is class to read the colony
 * @author boyuan
 * @version 2019.4.11
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;

    /**
     * Send the applicant input file to readQueueFile to populate an
     * ArrayQueue<Person> for the colony and send the planet input file to
     * readPlanetFile to populate an array of planets for the colony. Instantiate a
     * new SpaceWindow with the recently filled colony as its parameter.
     * 
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException 
     */
    public ColonyReader(String applicantFileName, String planetFileName)
            throws ParseException, SpaceColonyDataException, FileNotFoundException
    {
        queue = this.readQueueFile(applicantFileName);
    
        planets = this.readPlanetFile(planetFileName);
       
        //System.out.println(planets[1].toString());
        SpaceWindow window = new SpaceWindow(new ColonyCalculator(queue, planets));
    }  


    /**
     * Declare and instantiate a local array of planets that will store the planets
     * in sequential order in slots 1, 2 and 3.
     * 
     * Declare a new Scanner named file and instantiate it to be a new Scanner, with
     * a new File as its parameter. Give your new File the String fileName
     * parameter. You do not have to use a try catch statement to catch a
     * FileNotFoundException, you can just let it be thrown.
     * 
     * If the filename was correct, you can begin parsing the file. Loop through it
     * using hasNextLine(). Only read in the first 3 Planets.
     * 
     * You can use String’s split() function to parse the lines. The delimiter is
     * “,” but if you want to also account for spaces you can use a regular
     * expression “, *” (note the space). This will ensure your numerical skill
     * values can easily be converted with Integer.valueOf(String).
     * 
     * If there are not 5 comma separated values on the line, then throw a
     * ParseException.
     * 
     * If the skills are not between 1 and 5, then throw a SpaceColonyDataException.
     * 
     * If there are less than 3 planets, then throw a SpaceColonyDataException.
     * 
     * @throws ParseException
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException 
     */
    private Planet[] readPlanetFile(String fileName) 
        throws ParseException, SpaceColonyDataException, FileNotFoundException 
    {
        Planet[] planets = new Planet[3];
        File file2 = new File(fileName); 
        Scanner file = new Scanner(file2);
        int i = 0;
        while ( file.hasNextLine() && i <= 3)
        {
            
            String input = file.nextLine();
            //System.out.println(input);
            String[] in = input.split(", *");
            //System.out.println(in[0]);
            
            //System.out.println(": " + in[2] );
            if (in[1] == "" || in[2] == ""|| in[3] == "" || in[4] == "")
            {
                throw new ParseException("not enough values");
            }
            //System.out.println(in[3]);
            if ( !this.isInSkillRange(Integer.parseInt(in[1]), Integer.parseInt(in[2]), Integer.parseInt(in[3])))
            {
                throw new SpaceColonyDataException("skills not in range");
            }

            planets[i] = new Planet(in[0], Integer.parseInt(in[1]), 
                Integer.parseInt(in[2]), Integer.parseInt(in[3]), 
                Integer.parseInt(in[4]));
            i++;
        }

        if (i < 3)
        {
            throw new SpaceColonyDataException("not enough planets");
        }
        return planets;
    }
    
    /**
     * Declare and instantiate a local ArrayQueue<Person>, this will store the data
     * in the input file.
     * 
     * Follow the same strategy as above in readPlanetFile for using a Scanner
     * object and parsing the lines.
     * 
     * If the skills are not between 1 and 5, then throw a SpaceColonyDataException.
     * 
     * Hint: You may get an empty string if you use your scanner’s nextLine() method
     * to parse the people’s names. That’s because after parsing the previous
     * integer, the scanner is still “looking” at the end of the previous line. Call
     * nextLine() a second time to get their full names.
     * 
     * Hint: You can handle the "no preference" case as you choose, one suggestion
     * is to use an empty String.
     * 
     * Reference your previous labs and textbook for File I/O guidance as needed.
     * 
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName) throws FileNotFoundException, SpaceColonyDataException
    {
        ArrayQueue<Person> array = new ArrayQueue<Person>();
        File file2 = new File(fileName); 
        Scanner file = new Scanner(file2);
        while ( file.hasNextLine())
        {
            String input = file.nextLine();
            String[] in = input.split(", *");
            if ( !this.isInSkillRange(Integer.parseInt(in[1]), Integer.parseInt(in[2]), Integer.parseInt(in[3])))
            {
                throw new SpaceColonyDataException("skills not in range");
            }
            
            if (in.length <= 4)
            {
                array.enqueue(new Person(in[0], Integer.parseInt(in[1]), 
                    Integer.parseInt(in[2]), Integer.parseInt(in[3]), ""));
            }
            else {
                array.enqueue(new Person(in[0], Integer.parseInt(in[1]), 
                    Integer.parseInt(in[2]), Integer.parseInt(in[3]), in[4]));
            }
            
        }
        //System.out.println(array.toString());
        return array;
    }

    /**
     * If the skills are not between 1 and 5
     * @return if the skills are not bewteen 1 and 5
     */
    private boolean isInSkillRange(int num1, int num2, int num3)
    {
        if (( 0 < num1 && num1 < 6) 
            && ( 0 < num2 && num2 < 6) 
            && ( 0 < num3 && num3 < 6))
        {
            return true;
        }
        return false;
    }

    
    

}
