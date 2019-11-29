package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import spittr.service.SecuredSpittleService;
import spittr.service.SpittleService;


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
