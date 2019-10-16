package spittr.config;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author luopeng
 * @date 2019/10/15 23:44
 */
public class MyFilter implements Filter  {

    private Logger logger = Logger.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器初始化！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.info("执行过滤器!");

        Map<String, String[]> parameterMap = servletRequest.getParameterMap();

        Set<String> keySet = parameterMap.keySet();

        for (String key : keySet) {
            logger.info("执行过滤器11111111!");
            logger.info(String.format("参数名：%s,参数值：%s", key, parameterMap.get(key) ));
        }

        /**
         * 执行该方法，如果有下一个过滤器则执行下一个过滤器，如果没有，则执行目标方法
         * 如果不执行该方法，将无法访问目标路径请求
         */
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("过滤器销毁！");
    }
}
