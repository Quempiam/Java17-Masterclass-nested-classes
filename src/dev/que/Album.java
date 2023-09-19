package dev.que;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String title) {
        if (title != null) {
            for (Song elem : songs) {
                if (elem.getTitle() == title) {
                    return elem;
                }
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(int number, LinkedList<Song> playlist) {
        if (number <= songs.size() && number > 0) {
            if (songs.get(number - 1) != null) {
                playlist.add(songs.get(number - 1));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song s = findSong(title);
        if (s == null) {
            return false;
        }
        playlist.add(s);
        return true;
    }
}
