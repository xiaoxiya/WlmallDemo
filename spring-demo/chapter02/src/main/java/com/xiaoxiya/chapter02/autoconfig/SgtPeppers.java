package com.xiaoxiya.chapter02.autoconfig;

import org.springframework.stereotype.Component;

/**
 * @author luopeng
 * @date 2019/8/22 15:43
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }
}
