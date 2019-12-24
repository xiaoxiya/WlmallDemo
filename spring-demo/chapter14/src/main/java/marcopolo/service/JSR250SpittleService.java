package marcopolo.service;

import marcopolo.domain.Spittle;

import javax.annotation.security.RolesAllowed;

/**
 * @author luopeng
 * @date 2019/11/28 22:54
 */
public class JSR250SpittleService implements SpittleService {
    @Override
    @RolesAllowed("ROLE_SPITTER")
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }
}
