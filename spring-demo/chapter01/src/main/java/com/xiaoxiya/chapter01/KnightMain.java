package com.xiaoxiya.chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luopeng
 * @date 2019/8/22 15:14
 */
public class KnightMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "spring/knight.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

}
