package com.xiaoxiya.chapter02.xmlconfig;

import org.springframework.stereotype.Component;

/**
 * @author luopeng
 * @date 2019/8/22 15:43
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Club Band 1111";
    private String artist = "The Beatles 1111";
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }
}
