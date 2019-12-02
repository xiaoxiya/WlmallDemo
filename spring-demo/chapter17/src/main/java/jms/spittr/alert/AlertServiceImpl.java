package jms.spittr.alert;

import jms.spittr.domain.Spittle;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * @author luopeng
 * @date 2019/12/1 20:02
 */
public class AlertServiceImpl implements AlertService {

    private JmsOperations jmsOperations;

    public AlertServiceImpl(JmsOperations jmsOperations) {
        //注入jms模板
        this.jmsOperations = jmsOperations;
    }

    //public void sendSpittleAlert(final Spittle spittle) {
    //    //指定消息
    //    jmsOperations.send("spittle.alert.queue",
    //            new MessageCreator() {
    //        public Message createMessage(Session session) throws JMSException {
    //            //创建消息
    //            return session.createObjectMessage(spittle);
    //        }
    //    });
    //}


    //public void sendSpittleAlert(final Spittle spittle) {
    //    jmsOperations.send(
    //            new MessageCreator() {
    //                public Message createMessage(Session session)
    //                        throws JMSException {
    //                    return session.createObjectMessage(spittle);
    //                }
    //            }
    //    );
    //}

    public void sendSpittleAlert(Spittle spittle) {
        jmsOperations.convertAndSend(spittle);
    }

    //public Spittle retrieveSpittleAlert() {
    //    try {
    //        //接收消息
    //        ObjectMessage message = (ObjectMessage) jmsOperations.receive();
    //        //获得对象
    //        return (Spittle) message.getObject();
    //    } catch (JMSException e) {
    //        throw JmsUtils.convertJmsAccessException(e);
    //    }
    //}

    public Spittle retrieveSpittleAlert() {
        return (Spittle) jmsOperations.receiveAndConvert();
    }


}
