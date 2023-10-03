package dev.que;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            return songs.add(song);
        }

        private Song findSong(String title) {
            if (title != null) {
                for (Song elem : songs) {
                    if (elem.getTitle().equals(title)) {
                        return elem;
                    }
                }
            }
            System.out.println("The song " + title + " is not in this album.");
            return null;
        }

        private Song findSong(int trackNumber) {
            if (trackNumber > 0 && trackNumber <= songs.size()) {
                return songs.get(trackNumber - 1);
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
