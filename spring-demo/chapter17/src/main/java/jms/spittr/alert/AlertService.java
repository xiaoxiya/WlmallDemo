package jms.spittr.alert;


import jms.spittr.domain.Spittle;

public interface AlertService {

  void sendSpittleAlert(Spittle spittle);

  Spittle retrieveSpittleAlert();
  
}
