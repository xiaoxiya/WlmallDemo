package amqp.spittr.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luopeng
 * @date 2019/12/2 15:42
 */
public class ConsumerMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("amqp/amqp-consumer.xml");
    }
}
