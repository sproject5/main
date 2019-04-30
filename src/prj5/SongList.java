/*
 * Virginia Tech Honor Code Pledge:
 *
 * As a Hokie, I will conduct myself with honor
 * and integrity at all times.
 * I will not lie, cheat, or steal, nor will I
 * accept the actions of those who do.
 * -- Drew Pompeii (drewp24)
 * 
 */

package prj5;

import java.util.Iterator;

/**
 * This class manipulates the songs of a list by sorting,
 * and keeping track of their stats.
 * 
 * @param <E>
 *            the generic type for SongList
 *
 * @author Drew Pompeii (drewp24)
 * @version 04/14/2019
 */
public class SongList<E> extends DLList<E> {
    /**
     * The default constructor is intentionally left empty
     */
    public SongList() {
        // intentionally left empty
    }


    /**
     * This private method is used to sort DLLinked
     * list of strings alphabetically
     * 
     * @param
     * list
     *            the DLList that will be sorted
     * @return
     *         the alphabetized list
     */
    private DLList<String> alphabeticalOrder(DLList<String> list) {
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
     * 
     * @return
     *         the alphabetized list of artist names
     */
    public DLList<String> sortByArtistName() {
        DLList<String> artistList = new DLList<String>();
        for (int x = 0; x < this.size(); x++) {
            artistList.add(((Song)this.get(x)).getArtistName().toLowerCase());
        }
        return alphabeticalOrder(artistList);
    }


    /**
     * Get the songList that has the artist names sorted alphabetically
     * 
     * @return the songList that has the artist names sorted alphabetically
     */
    public SongList<E> getSortedByArtistName() {
        DLList<String> sortedList = this.sortByArtistName();
        SongList<E> newSongList = new SongList<E>();
        for (int i = 0; i < sortedList.size(); i++) {
            String name = sortedList.get(i);
            for (int k = 0; k < this.size(); k++) {
                Song tempSong = ((Song)this.get(k));
                if (tempSong.getArtistName().toLowerCase().equals(name)) {
// && !newSongList.contains((E)tempSong)
                    newSongList.add(this.get(k));
                }
            }
        }
        return newSongList; 
    }

 
    /**
     * This method will sort a list of song titles alphabetically
     * 
     * @return
     *         the alphabetized list of song titles
     */
    public DLList<String> sortBySongTitle() {
        DLList<String> titleList = new DLList<String>();
        // System.out.println(this.size());
        for (int x = 0; x < this.size(); x++) {
            titleList.add(((Song)this.get(x)).getSongTitle().toLowerCase());
        }

        DLList<String> newTitleList = alphabeticalOrder(titleList);
        return alphabeticalOrder(newTitleList);
    }


    /**
     * Get the songList that has the artist names sorted alphabetically
     * 
     * @return the songList that has the artist names sorted alphabetically
     */
    public SongList<E> getSortedByTitle() {
        DLList<String> sortedList = this.sortBySongTitle();
        SongList<E> newSongList = new SongList<E>();
        for (int i = 0; i < sortedList.size(); i++) {
            String title = sortedList.get(i);
            for (int k = 0; k < this.size(); k++) {
                Song tempSong = ((Song)this.get(k));
                if (tempSong.getSongTitle().toLowerCase().equals(title
                    .toLowerCase())) {
                    // && !newSongList.contains((E)tempSong)
                    newSongList.add(this.get(k));
                }
            }
        }
        return newSongList;
    }


    /**
     * This method will sort a list of integers representing
     * release years of songs
     * 
     * @return
     *         a list of release years sorted chronologically
     */
    public DLList<Integer> sortByReleaseYear() {
        DLList<Integer> yearList = new DLList<Integer>();

        for (int x = 0; x < this.size(); x++) {
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
     * Get the songList that has the release years sorted
     * 
     * @return the songList of the release
     *         years sorted from oldest to youngest
     */
    public SongList<E> getSortedByYear() {
        DLList<Integer> sortedList = this.sortByReleaseYear();
        SongList<E> newSongList = new SongList<E>();
        for (int i = 0; i < sortedList.size(); i++) {

            int year = sortedList.get(i);
            // System.out.println(year);
            for (int k = 0; k < this.size(); k++) {
                Song tempSong = ((Song)this.get(k));
                if (tempSong.getDate() == year && !newSongList.contains(
                    (E)tempSong)) {
                    newSongList.add(this.get(k));
                } 
            }
        }
        return newSongList;
    }


    /**
     * This method will sort a a list of genres alphabetically
     * 
     * @return
     *         return a list of genres sorted
     *         alphabetically(including capitalization)
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
     * Get the songList that has the genres sorted alphabetically
     * 
     * @return Get the songList that has the genres sorted alphabetically
     */
    public SongList<E> getSortedByGenre() {
        DLList<String> sortedList = this.sortByGenre();
        SongList<E> newSongList = new SongList<E>();
        for (int i = 0; i < sortedList.size(); i++) {
            String genre = sortedList.get(i);
            for (int k = 0; k < this.size(); k++) {
                Song tempSong = ((Song)this.get(k));
                if (tempSong.getGenre().equals(genre) && !newSongList.contains(
                    (E)tempSong)) {
                    newSongList.add(this.get(k));
                }
            }
        }
        return newSongList;
    }


    /**
     * increment Heard
     * 
     * @param index
     *            to keep track
     */
    public void heardToYes(int index) {
        Song song = (Song)this.get(index);

        this.remove(index);
        song.heardIsYes();
        this.add(index, (E)song);
    }


    /**
     * increment Heard
     * 
     * @param index
     *            to keep track
     */
    public void heardToNo(int index) {
        Song song = (Song)this.get(index);

        this.remove(index);
        song.heardIsNo();
        this.add(index, (E)song);
    }


    /**
     * increment Heard
     * 
     * @param index
     *            to keep track
     */
    public void likedToYes(int index) {
        Song song = (Song)this.get(index);

        this.remove(index);
        song.likedIsYes();
        this.add(index, (E)song);
    }


    /**
     * increment Heard
     * 
     * @param index
     *            to keep track
     */
    public void likedToNo(int index) {
        Song song = (Song)this.get(index);

        this.remove(index);
        song.likedIsNo();
        this.add(index, (E)song);
    }


    /**
     * Gets the song in lower case
     * 
     * @param title
     *            the title changing into lower case
     * @return the song in lower case
     */
    public Song getSongInLowerCase(String title) {
        Song targetSong = null;
        for (int k = 0; k < this.size(); k++) {
            // System.out.println(curSongList.get(k).getSongTitle());
            if (((Song)this.get(k)).getSongTitle().toLowerCase().equals(
                title)) {
                // System.out.println(title);
                targetSong = (Song)this.get(k);
            }
        }

        return targetSong;
    }


    /**
     * Creates a string of the song list
     * 
     * @return a string of the song list
     */
    public String toString() {
        String str = "";

        Iterator<E> list = this.iterator();
        while (list.hasNext()) {
            str = str + list.next().toString() + "\n";
        }
        // System.out.println(str);

        return str;
    }
}
