package prj5;

public class SongList<E> extends DLList<E> {
    private DLList<Song> songList;


    public SongList(DLList<Song> thissongList) {
        songList = thissongList;
    }


    private void alphabeticalOrder(DLList<String> list) {

        for (int j = 0; j < list.size() - 1; j++) {
            for (int i = 0; i < list.size() - j - 1; i++) {
                if (list.get(i).toString().compareTo(list.get(i + 1)
                    .toString()) > 0) {

                    String first = list.get(i);

                    list.remove(i);
                    list.add(i + 1, first);
                }
            }

        }
    }


    public void sortByArtistName() {
        DLList<String> artistList = new DLList<String>();
        while (!songList.isEmpty()) {
            int count = 0;
            artistList.add(songList.get(count).getArtistName());
            songList.remove(count);
            count++;
        }
        alphabeticalOrder(artistList);
    }


    public void sortBySongTitle() {
        DLList<String> titleList = new DLList<String>();
        while (!songList.isEmpty()) {
            int count = 0;
            titleList.add(songList.get(count).getSongTitle());
            songList.remove(count);
            count++;
        }
        alphabeticalOrder(titleList);
    }


    public void sortByReleaseYear() {
        DLList<Integer> yearList = new DLList<Integer>();
        while (!songList.isEmpty()) {
            int count = 0;
            yearList.add(songList.get(count).getDate());
            songList.remove(count);
            count++;
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
    }


    public void sortByGenre() {
        DLList<String> genreList = new DLList<String>();
        while (!songList.isEmpty()) {
            int count = 0;
            genreList.add(songList.get(count).getGenre());
            songList.remove(count);
            count++;
        }
        alphabeticalOrder(genreList);
    }
}
