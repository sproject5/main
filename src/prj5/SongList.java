package prj5;

/**
 * @author Ruba Shawkat
 * @version 2019-04-15
 *          The class SongList extends the DLList class
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
            //System.out.println(list.size());

            //System.out.println("erdtf");

            for (int j = 0; j < list.size() - 1; j++) {
                //System.out.println(list.get(j).compareTo(list.get(j + 1)));

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
        //System.out.println(this.size());
        for(int x = 0; x < this.size() ; x++) {
            //System.out.println("wedfrg");
            artistList.add(((Song)this.get(x)).getArtistName());
        }
        return alphabeticalOrder(artistList);
    }


    public DLList<String> sortBySongTitle() {
        DLList<String> titleList = new DLList<String>();
        //System.out.println(this.size());
        for(int x = 0; x < this.size() ; x++) {
            //System.out.println("wedfrg");
            titleList.add(((Song)this.get(x)).getSongTitle());
        }
        return alphabeticalOrder(titleList);
    }


    public DLList<Integer> sortByReleaseYear() {
        DLList<Integer> yearList = new DLList<Integer>();
        //System.out.println(this.size());
        for(int x = 0; x < this.size() ; x++) {
            //System.out.println("wedfrg");
            yearList.add(((Song)this.get(x)).getDate());
        }

        for (int j = 0; j < yearList.size() - 1; j++) {
            for (int i = 0; i < yearList.size() - j - 1; i++) {
                if (yearList.get(i).toString().compareTo(yearList.get(i + 1)
                    .toString()) > 0) {

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
        //System.out.println(this.size());
        for(int x = 0; x < this.size() ; x++) {
            //System.out.println("wedfrg");
            genreList.add(((Song)this.get(x)).getGenre());
        }
        return alphabeticalOrder(genreList);
    }

    public void incrementHeard(int index)
    {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.addHeard();
        this.add(index, (E) song);
    }

    public void incrementLike(int index)
    {
        Song song = (Song) this.get(index);
        this.remove(index);
        song.addLiked();
        this.add(index, (E) song);
    }


}
