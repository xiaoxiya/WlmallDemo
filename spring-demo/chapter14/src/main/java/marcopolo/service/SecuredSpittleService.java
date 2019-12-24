package marcopolo.service;

import org.springframework.security.access.annotation.Secured;
import marcopolo.domain.Spittle;

/**
 * @author luopeng
 * @date 2019/11/28 22:55
 */
public class SecuredSpittleService implements SpittleService {
    @Override
    @Secured({"ROLE_SPITTER","ROLE_ADMIN"})
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }
}
