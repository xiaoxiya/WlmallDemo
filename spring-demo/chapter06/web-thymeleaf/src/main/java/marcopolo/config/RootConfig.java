package marcopolo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

/**
 * @author luopeng
 * @date 2019/9/27 15:34
 */
@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"marcopolo"},
excludeFilters = {
        @Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
})
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("spittr\\.web"));
        }
    }
}
