package prj5;
import java.io.FileNotFoundException;
import java.text.ParseException;
import student.TestCase;

public class SongReaderTest extends TestCase
{

    private SongReader reader;

    /**
     * setup the inital condition
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public void setUp() throws FileNotFoundException, ParseException
    {
        reader = new SongReader("SongList2018.csv", "MusicSurveyData2018.cvs");
    }

    public void testReadSongFile()
    {
        DLList<Song> songList = reader.getSongList();
        System.out.println(songList.get(10).getArtistName());
        
    }
}
