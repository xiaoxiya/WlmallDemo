package marcopolo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("marcopolo.db")
@Import({DataConfig.class, CachingConfig.class})
public class RootConfig {

}
