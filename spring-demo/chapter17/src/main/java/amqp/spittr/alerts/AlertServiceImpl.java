package amqp.spittr.alerts;

import amqp.spittr.domain.Spittle;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author luopeng
 * @date 2019/12/1 21:35
 */
public class AlertServiceImpl implements AlertService {

    private RabbitTemplate rabbit;

    @Autowired
    public AlertServiceImpl(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public void sendSpittleAlert(Spittle spittle) {
        rabbit.convertAndSend("spittle.alert.exchange", "spittle.alerts", spittle);
    }
}
