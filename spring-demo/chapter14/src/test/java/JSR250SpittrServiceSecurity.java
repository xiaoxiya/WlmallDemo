import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.JSR250Config;
import spittr.domain.Spitter;
import spittr.domain.Spittle;
import spittr.service.SpittleService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/28 23:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JSR250Config.class)
public class JSR250SpittrServiceSecurity {
    @Autowired
    private SpittleService spittleService;

    @Before
    public void cleanContext() {
        SecurityContextHolder.clearContext();
    }

    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void TestSecureMethodNoCredentials() {
        Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
        Spittle spittle = new Spittle(1L, spitter, "", new Date());
        spittleService.addSpittle(spittle);
    }

    @Test(expected = AccessDeniedException.class)
    public void testSecuredMethodInsufficentPrivilege() {
        setupUser();

        Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
        Spittle spittle = new Spittle(1L, spitter, "", new Date());
        spittleService.addSpittle(spittle);
    }

    @Test
    public void testSecuredMethodWithSufficientPrivilege() {
        setupUser("ROLE_SPITTER");

        Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
        Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());
        spittleService.addSpittle(spittle);
    }

    @Test(expected = AccessDeniedException.class)
    public void testSecuredMethodWithSufficientPrivilegeButLongText() {
        setupUser("ROLE_SPITTER");

        Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
        Spittle spittle = new Spittle(1L, spitter, "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", new Date());
        spittleService.addSpittle(spittle);
    }

    public void testSecuredMethodWithPremimumPrivilegeAndLongText() {
        setupUser("ROLE_PREMIUM");

        Spitter spitter = new Spitter(1L, "habuma", null, "Craig Walls", "craig@habuma.com", true);
        Spittle spittle = new Spittle(1L, spitter, "123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", new Date());
        spittleService.addSpittle(spittle);
    }

    private void setupUser(String... privs) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String priv : privs) {
            authorities.add(new SimpleGrantedAuthority(priv));
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("user", "password", authorities);
        securityContext.setAuthentication(authenticationToken);
    }
}
