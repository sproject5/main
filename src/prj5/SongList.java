package prj5;

import java.util.Iterator;

/**
 * Add the class description here.
 *
 * @author Drew Pompeii (drewp24)
 * @version 04/14/2019
 */
public class SongList<E> extends DLList<E> {
    /**
     * The default constructor is intentionally left empty
     */
    public SongList() {
    }


    /**
     * This private method is used to sort DLLinked list of strings alphabetically
     * @param 
     *      list the DLList that will be sorted
     * @return
     *      the alphabetized list
     */
    private DLList<String> alphabeticalOrder(DLList<String> list) 
    {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String first = list.get(j);

                    list.remove(j);
                    list.add(j + 1, first);
                }
            }

        }
        return list;
    }

    /**
     * This method will sort a list of artist names alphabetically
     * @return
     *      the alphabetized list of artist names
     */
    public DLList<String> sortByArtistName() 
    {
        DLList<String> artistList = new DLList<String>();
        for (int x = 0; x < this.size(); x++) {
            artistList.add(((Song)this.get(x)).getArtistName());
        }
        return alphabeticalOrder(artistList);
    }

    /**
     * This method will sort a list of song titles alphabetically
     * @return
     *      the alphabetized list of song titles
     */
    public DLList<String> sortBySongTitle() 
    {
        DLList<String> titleList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            titleList.add(((Song)this.get(x)).getSongTitle().toLowerCase());
        }

        DLList<String> newTitleList = alphabeticalOrder(titleList);
        return alphabeticalOrder(newTitleList);
    }



    /**
     * This method will sort a list of integers representing 
     * release years of songs 
     * @return
     *      a list of release years sorted chronologically
     */
    public DLList<Integer> sortByReleaseYear() 
    {
        DLList<Integer> yearList = new DLList<Integer>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) 
        {
            yearList.add(((Song)this.get(x)).getDate());
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

    /**
     * This method will sort a a list of genres alphabetically
     * @return
     *      return a list of genres sorted alphabetically(including capitalization)
     */
    public DLList<String> sortByGenre() {
        DLList<String> genreList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
            genreList.add(((Song)this.get(x)).getGenre());
        }
        for (int i = 0; i < genreList.size() - 1; i++) {
            for (int j = 0; j < genreList.size() - 1; j++) {
                if (genreList.get(j).compareTo(genreList.get(j + 1)) > 0) {
                    String first = genreList.get(j);

                    genreList.remove(j);
                    genreList.add(j + 1, first);
                }
            }

        }
        return genreList;
    }



    /**
     * increment Heard 
     * @param index
     */
    public void heardToYes(int index) {
        Song song = (Song) this.get(index);

        this.remove(index);
        song.heardIsYes();
        this.add(index, (E) song);
    }

   
    /**
     * increment Heard 
     * @param index
     */
    public void heardToNo(int index) {
        Song song = (Song) this.get(index);

        
        this.remove(index);
        song.heardIsNo();
        this.add(index, (E) song);
    }
    /**
     * increment Heard 
     * @param index
     */
    public void likedToYes(int index) {
        Song song = (Song) this.get(index);

        this.remove(index);
        song.likedIsYes();
        this.add(index, (E) song);
    }
        /**
     * increment Heard 
     * @param index
     */
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

    public Song getSongInLowerCase(String title)
    {
        Song targetSong = null;
        for (int k = 0; k < this.size(); k++)
        {
            //System.out.println(curSongList.get(k).getSongTitle());
            if (((Song) this.get(k)).getSongTitle().toLowerCase().equals(title))
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