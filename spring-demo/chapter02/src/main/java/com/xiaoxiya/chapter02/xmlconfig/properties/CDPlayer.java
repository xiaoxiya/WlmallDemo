package com.xiaoxiya.chapter02.xmlconfig.properties;

import com.xiaoxiya.chapter02.xmlconfig.CompactDisc;
import com.xiaoxiya.chapter02.xmlconfig.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author luopeng
 * @date 2019/8/22 15:49
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc compactDisc;

    @Autowired
    public void setCompactDisc(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public void play() {
        compactDisc.play();
    }

}
