package marcopolo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author luopeng
 * @date 2019/9/27 15:34
 * DispatcherServlet的配置声明 <br/>
 * 支持使用Servlet3.0的服务器可以不需要通过web.xml来配置dispatcherServlet
 *  @ EnableWebMvc 启动springMvc, @componentScan 启动组件扫描
 */
@Configuration
@EnableWebMvc
@ComponentScan("marcopolo.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置jsp试图解析器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源的处理
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
