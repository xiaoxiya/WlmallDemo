package com.xiaoxiya.chapter01;

/**
 * @author luopeng
 * @date 2019/8/22 15:06
 */
public class BraveKnight implements Knight{
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
