package com.xiaoxiya.chapter02.mixedconfig;

import org.springframework.stereotype.Component;

/**
 * @author luopeng
 * @date 2019/8/22 15:43
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Club Band mixedconfig";
    private String artist = "The Beatles mixedconfig";
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }
}
