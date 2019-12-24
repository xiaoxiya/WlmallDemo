package marcopolo.service;

import org.springframework.security.access.prepost.PreAuthorize;
import marcopolo.domain.Spittle;

/**
 * @author luopeng
 * @date 2019/11/28 22:38
 */
public class ExpressionSecuredSpittlesService implements SpittleService  {

    @Override
    @PreAuthorize("(hasRole('ROLE_SPITTER') and #spittle.text.length() le 140) or hasRole('ROLE_PREMIUM')")
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }
}
