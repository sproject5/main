package prj5;
import java.io.FileNotFoundException;
import java.text.ParseException;
import student.TestCase;

public class SurveySorterTest extends TestCase
{
    private SurveySorter survey;

    public void setUp() throws FileNotFoundException, ParseException
    {
        survey = new SurveySorter();
    }

    public void testLinkedDataOf()
    {
        assertEquals(10, survey.HeardDataOf("All of Me", "art"));
        assertEquals(1, survey.HeardDataOf("All of Me", "read"));

    }
}
