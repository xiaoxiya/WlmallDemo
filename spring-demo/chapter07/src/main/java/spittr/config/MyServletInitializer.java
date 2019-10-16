package spittr.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * @author luopeng
 * @date 2019/10/15 23:27
 * Servlet3.0以上支持java配置和web.xml配置，3.0以下只能通过web.xml配置
 * 如果我们想往Web容器中注册其他组件
 * 的话（想注册其他的Servlet、Filter或Listener的话），
 * 只需创建一个新的初始化器就可以了，实现WebApplicationInitializer即可
 *
 */
public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //注册servlet
        //ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        ////映射servlet
        //myServlet.addMapping("/custom/**");
        //
        ////注册Filter
        //FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
        ////添加Filter的映射路径
        //filter.addMappingForUrlPatterns(null, false, "/test07/**");

        //额外配置Multiple，采用Servlet初始化类的方式来配置DispatcherServlet
        //DispatcherServlet ds = new DispatcherServlet();
        //ServletRegistration.Dynamic registration = servletContext.addServlet("appServlet", ds);
        //registration.addMapping("/");
        //registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads"));
    }
}
