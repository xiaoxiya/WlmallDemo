package marcopolo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import marcopolo.service.SecuredSpittleService;
import marcopolo.service.SpittleService;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecuredConfig extends GlobalMethodSecurityConfiguration {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
    .inMemoryAuthentication()
      .withUser("user").password("password").roles("USER");
  }
  

  @Bean
  public SpittleService spittleService() {
    return new SecuredSpittleService();
  }

}
