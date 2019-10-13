package spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author luopeng
 * @date 2019/9/27 15:34
 * DispatcherServlet的配置声明 <br/>
 * 支持使用Servlet3.0的服务器可以不需要通过web.xml来配置dispatcherServlet
 *  @ EnableWebMvc 启动springMvc, @componentScan 启动组件扫描
 */
@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置jsp试图解析器 <br/>
     * 或者也可以通过xml文件配置
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        //将视图解析为jstlview
        resolver.setViewClass(JstlView.class);
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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    /**
     * 配置信息源
     * 可以使用ResourceBundleMessageSource
     * 或者使用ReloadableResourceBundleMessageSource
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        //basename属性可以设置为在类路径下（以“classpath:”作
        //为前缀） 、 文件系统中（以“file:”作为前缀） 或Web应用的根路径
        //下（没有前缀） 查找属性
        messageSource.setBasename("classpath:message");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }
}
