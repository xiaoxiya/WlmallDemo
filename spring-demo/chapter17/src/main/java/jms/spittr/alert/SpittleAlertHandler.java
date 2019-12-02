package jms.spittr.alert;

import jms.spittr.domain.Spittle;

/**
 * @author luopeng
 * @date 2019/12/1 20:27
 */
public class SpittleAlertHandler {
    public void handleSpittleAlert(Spittle spittle) {
        System.out.println(spittle.getMessage());
    }
}
