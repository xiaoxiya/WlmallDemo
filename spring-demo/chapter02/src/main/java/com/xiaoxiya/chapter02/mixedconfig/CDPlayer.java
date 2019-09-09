package com.xiaoxiya.chapter02.mixedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luopeng
 * @date 2019/8/22 15:49
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }


    public void play() {
        cd.play();
    }
}
