/**
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)

 */
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
     * 
     * @param list
     * @return
     */
    private DLList<String> alphabeticalOrder(DLList<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            // System.out.println(list.size());

            // System.out.println("erdtf");

            for (int j = 0; j < list.size() - 1; j++) {
                // System.out.println(list.get(j).compareTo(list.get(j + 1)));

                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String first = list.get(j);

                    list.remove(j);
                    list.add(j + 1, first);
                }
            }

        }
        return list;
    }


    public DLList<String> sortByArtistName() {
        DLList<String> artistList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
            artistList.add(((Song)this.get(x)).getArtistName());
        }
        return alphabeticalOrder(artistList);
    }


    public DLList<String> sortBySongTitle() {
        DLList<String> titleList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
            titleList.add(((Song)this.get(x)).getSongTitle());
        }
        return alphabeticalOrder(titleList);
    }


    public DLList<Integer> sortByReleaseYear() {
        DLList<Integer> yearList = new DLList<Integer>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
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


    public DLList<String> sortByGenre() {
        DLList<String> genreList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            // System.out.println("wedfrg");
            genreList.add(((Song)this.get(x)).getGenre());
        }
        return alphabeticalOrder(genreList);
    }
    
    /**
     * increment Heard 
     * @param index
     */
    public void incrementHeard(int index) {
        Song song = (Song) this.get(index);
        //System.out.println(song.getSongTitle());
        //System.out.println("before: " + song.getHeard());
        this.remove(index);
        song.addHeard();
        this.add(index, (E) song);
        //System.out.println("after: " + song.getHeard());


    }

    public void incrementLike(int index) {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.addLiked();
        this.add(index, (E) song);
    }

    public void decrementHeard(int index) {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.minusHeard();
        this.add(index, (E) song);
    }

    public void decrementLike(int index) {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.minusLiked();
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
