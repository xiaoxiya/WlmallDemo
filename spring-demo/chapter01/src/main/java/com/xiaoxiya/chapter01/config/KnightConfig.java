package com.xiaoxiya.chapter01.config;

import com.xiaoxiya.chapter01.BraveKnight;
import com.xiaoxiya.chapter01.Knight;
import com.xiaoxiya.chapter01.Quest;
import com.xiaoxiya.chapter01.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luopeng
 * @date 2019/8/22 15:07
 */
@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
