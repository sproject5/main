package prj5;
import java.io.FileNotFoundException;
import java.text.ParseException;
import student.TestCase;

public class SurveySorterTest extends TestCase
{
    private SurveySorter survey;

    public void setUp() throws FileNotFoundException, ParseException
    {
        survey = new SurveySorter("SongList2018.csv", "MusicSurveyData2018.csv");
    }

    public void testLinkedDataOf()
    {
        //assertEquals(10, survey.DataOf("All of Me", "art", true));
        assertEquals(114, survey.DataOf("Hotline Bling", "sports", true));
        assertEquals(42, survey.DataOf("Hotline Bling", "reading", true));

    }
}
