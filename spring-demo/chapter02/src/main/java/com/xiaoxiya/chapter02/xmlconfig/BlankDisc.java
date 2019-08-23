package com.xiaoxiya.chapter02.xmlconfig;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/8/23 14:38
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;

    //public BlankDisc(String title, String artist, List<String> tracks) {
    //    this.title = title;
    //    this.artist = artist;
    //    this.tracks = tracks;
    //}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + "by " + artist);
        for (String track : tracks) {
            System.out.println("Track: " + track);
        }
    }
}
