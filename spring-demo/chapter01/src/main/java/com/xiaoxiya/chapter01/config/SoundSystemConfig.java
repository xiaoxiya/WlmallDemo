package com.xiaoxiya.chapter01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
/**
 * @author luopeng
 * @date 2019/8/22 15:08
 */
@Configuration
@ComponentScan(basePackages = "com.xiaoxiya.chapter01",
        excludeFilters = { @Filter(Configuration.class) })
public class SoundSystemConfig {
}