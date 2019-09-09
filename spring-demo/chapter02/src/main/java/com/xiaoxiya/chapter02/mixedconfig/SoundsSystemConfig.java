package com.xiaoxiya.chapter02.mixedconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author luopeng
 * @date 2019/9/9 10:59
 */
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:spring/mixedconfig/cdConfig.xml")
public class SoundsSystemConfig {

}
