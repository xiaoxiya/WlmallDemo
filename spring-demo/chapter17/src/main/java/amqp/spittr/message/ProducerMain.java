package amqp.spittr.message;

import jms.spittr.domain.Spittle;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author luopeng
 * @date 2019/12/2 15:43
 */
public class ProducerMain {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("amqp/amqp-producer.xml");
        AmqpTemplate template = (AmqpTemplate) context.getBean("rabbitTemplate");

        for (int i = 0; i < 20; i++) {
            System.out.println("Sending message #" + i);
            Spittle spittle = new Spittle((long) i, null, "Hello world (" + i + ")", new Date());
            template.convertAndSend(spittle);
            Thread.sleep(5000);
        }
        System.out.println("Done!");
    }
}
