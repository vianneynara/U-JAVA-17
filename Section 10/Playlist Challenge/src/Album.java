import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) != null) {
            return false;
        }
        return songs.add(new Song(title, duration));
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        if ((trackNumber < 1) || (trackNumber > songs.size())) {
            return false;
        }
        Song song = songs.get(trackNumber - 1);

        // Using list iterator to iterate and find duplicates.
        ListIterator<Song> iterator = playList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitle().equals(song.getTitle())) {
                return false;
            }
        }

        // Using enhanced for loop instead of iterator.
//        for (Song currSong : playList) {
//            if (currSong.getTitle().equals(song.getTitle())) {
//                return false;
//            }
//        }

        return playList.add(song);
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song == null) {
            return false;
        }

        // Using enhanced for loop find duplicates.
        for (Song currSong : playList) {
            if (currSong.getTitle().equals(song.getTitle())) {
                return false;
            }
        }

        // Using list iterator to iterate instead.
//        ListIterator<Song> iterator = playList.listIterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().getTitle().equals(song.getTitle())) {
//                return false;
//            }
//        }

        return playList.add(song);
    }

//    public ArrayList<Song> getSongs() {
//        return songs;
//    }
}
