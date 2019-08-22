package com.xiaoxiya.chapter01;

import java.io.PrintStream;

/**
 * @author luopeng
 * @date 2019/8/22 15:06
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
