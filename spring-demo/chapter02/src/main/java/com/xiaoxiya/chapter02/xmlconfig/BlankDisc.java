package com.xiaoxiya.chapter02.xmlconfig;


/**
 * @author luopeng
 * @date 2019/8/23 14:38
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

}
