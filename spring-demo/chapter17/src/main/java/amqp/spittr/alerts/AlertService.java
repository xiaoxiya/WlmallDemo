package amqp.spittr.alerts;


import amqp.spittr.domain.Spittle;

public interface AlertService {

  void sendSpittleAlert(Spittle spittle);

}
