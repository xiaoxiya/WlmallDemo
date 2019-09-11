package external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author luopeng
 * @date 2019/9/11 15:46
 */
@Configuration
@PropertySource("classpath:external/dataTest.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }
}
