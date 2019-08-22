package com.xiaoxiya.chapter01;

/**
 * @author luopeng
 * @date 2019/8/22 15:03
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
