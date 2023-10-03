package dev.que;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public static class SongList {
        private ArrayList<Song> songsArray;

        public SongList() {
            this.songsArray = new ArrayList<>();
        }

        public boolean add(Song song) {
            if (songsArray.contains(song)) {
                return false;
            }
            return songsArray.add(song);
        }

        public Song findSong(String title) {
            if (title != null) {
                for (Song elem : songsArray) {
                    if (elem.getTitle().equals(title)) {
                        return elem;
                    }
                }
            }
            System.out.println("The song " + title + " is not in this album.");
            return null;
        }

        public Song findSong(int trackNumber) {
            if (trackNumber > 0 && trackNumber <= songsArray.size()) {
                return songsArray.get(trackNumber - 1);
            }
            System.out.println("This album does not have a track "+ trackNumber +".");
            return null;
        }
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }


    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int number, LinkedList<Song> playlist) {
        Song temp = songs.findSong(number);
        if (temp != null) {
            playlist.add(temp);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song temp = songs.findSong(title);
        if (temp != null) {
            playlist.add(temp);
            return true;
        }
        return false;
    }
}
