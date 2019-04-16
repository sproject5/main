package prj5;

import java.util.Iterator;

/**
 * @author Ruba Shawkat
 * @version 2019-04-15 The class SongList extends the DLList class
 */
public class SongList<E> extends DLList<E> {

    /**
     * The default constructor is intentionally left empty
     */
    public SongList() {
    }

    /**
     * 
     * @param list
     * @return
     */
    private DLList<String> alphabeticalOrder(DLList<String> list) {

        for (int i = 0; i < list.size() - 1; i++) 
        {
            for (int j = 0; j < list.size() - 1; j++) 
            {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String first = list.get(j);

                    list.remove(j);
                    list.add(j + 1, first);
                }
            }

        }
        return list;
    }

    public DLList<String> sortByArtistName() 
    {
        DLList<String> artistList = new DLList<String>();
        for (int x = 0; x < this.size(); x++) 
        {
            artistList.add(((Song) this.get(x)).getArtistName());
        }
        return alphabeticalOrder(artistList);
    }

    public DLList<String> sortBySongTitle() {
        DLList<String> titleList = new DLList<String>();
        for (int x = 0; x < this.size(); x++) {
            titleList.add(((Song) this.get(x)).getSongTitle());
        }
        return alphabeticalOrder(titleList);
    }

    public DLList<Integer> sortByReleaseYear() {
        DLList<Integer> yearList = new DLList<Integer>();
        for (int x = 0; x < this.size(); x++) {
            yearList.add(((Song) this.get(x)).getDate());
        }

        for (int j = 0; j < yearList.size() - 1; j++) {
            for (int i = 0; i < yearList.size() - j - 1; i++) {
                if (yearList.get(i) > yearList.get(i + 1)) {

                    Integer first = yearList.get(i);

                    yearList.remove(i);
                    yearList.add(i + 1, first);
                }
            }

        }
        return yearList;
    }

    public DLList<String> sortByGenre() {
        DLList<String> genreList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
            genreList.add(((Song) this.get(x)).getGenre());
        }
        return alphabeticalOrder(genreList);
    }

    /**
     * increment Heard 
     * @param index
     */
    public void heardToYes(int index) 
    {
        Song song = (Song) this.get(index);

        this.remove(index);
        song.heardIsYes();
        this.add(index, (E) song);

    }

    public void likedToYes(int index) 
    {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.likedIsYes();
        this.add(index, (E) song);
    }

    public void heardToNo(int index) 
    {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.heardIsNo();
        this.add(index, (E) song);
    }

    public void likedToNo(int index) {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.likedIsNo();
        this.add(index, (E) song);
    }


    public Song getSong(String title)
    {
        Song targetSong = null;
        for (int k = 0; k < this.size(); k++)
        {
            //System.out.println(curSongList.get(k).getSongTitle());
            if (((Song) this.get(k)).getSongTitle().equals(title))
            {
                //System.out.println(title);
                targetSong = (Song) this.get(k);
            }
        }


        return targetSong;
    }

    public String toString() {
        String str = "";

        Iterator<E> list = this.iterator();
        while(list.hasNext())
        {
            str = str + list.next().toString() + "\n";
        }
        //System.out.println(str);

        return str;
    }
}
