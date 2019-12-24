package marcopolo.config;


import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author luopeng
 * @date 2019/11/25 23:23
 */
@Configuration
@EnableCaching
public class CachingConfig {

    /**
     * 配置EhCacheCacheManager
     * @param cm
     * @return
     */
    @Bean
    public EhCacheCacheManager cacheCacheManager(CacheManager cm) {
        //传入EhCacheCacheManager实例创建EhCacheCacheManager实例
        return new EhCacheCacheManager(cm);
    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource(("spittr/cache/ehcache.xml")));
        return ehCacheManagerFactoryBean;
    }
}
