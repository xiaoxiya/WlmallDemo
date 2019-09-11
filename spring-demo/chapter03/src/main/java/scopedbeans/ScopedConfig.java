package scopedbeans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author luopeng
 * @date 2019/9/11 14:57
 */
@Configuration
public class ScopedConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Notepad notepad() {
        return new Notepad();
    }
    @Bean
    public UniqueThings unique() {
        return new UniqueThings();
    }
}
