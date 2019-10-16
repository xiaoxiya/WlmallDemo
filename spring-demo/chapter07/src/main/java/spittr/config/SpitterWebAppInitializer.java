package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @author luopeng
 * @date 2019/9/27 15:26
 */
public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * AbstractAnnotationConfigDispatcherServletInitializer 会同时创建 DispatcherServlet 和 ContextLoaderListener 。
     * GetServlet-ConfigClasses() 方法返回的带有 @Configuration 注解的类将会用来定义 DispatcherServlet 应用上下文中的 bean 。
     * getRootConfigClasses() 方法返回的带有 @Configuration 注解的类将会用来配置 ContextLoaderListener 创建的应用上下文中的 bean
     *
     * 为了注册Filter并将其映射到DispatcherServlet， 所需要做的仅仅是重
     * 载AbstractAnnotationConfigDispatcherServletInitializer
     * 的getServlet-Filters()方法
     *
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置DispatcherServlet的Servlet初始化类继承了
     * Abstract AnnotationConfigDispatcherServletInitializer
     * 或AbstractDispatcher-ServletInitializer
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("C:\\Users\\18370\\Desktop\\uploads", 2097152, 4194394, 0));
    }

    /**
     * 注册过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        //将自定义过滤器实例数组返回
        return new Filter[] { new MyFilter() };
    }




}
