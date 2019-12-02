package jms.spittr;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsOperations;

/**
 * @author luopeng
 * @date 2019/12/1 19:23
 */
public class JMSMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jms/messaging.xml");
        JmsOperations jms = context.getBean(JmsOperations.class);
        for (int i = 0; i < 10; i++) {
            jms.convertAndSend("hello.queue", "Hello");
        }
        context.close();
    }
}
