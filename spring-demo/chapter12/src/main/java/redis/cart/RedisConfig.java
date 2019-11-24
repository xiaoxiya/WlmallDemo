package redis.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author luopeng
 * @date 2019/11/24 21:37
 */
@Configuration
public class RedisConfig {

    /**
     * 默认redis配置 默认端口号6379，无密码
     * @return
     */
    @Bean
    public RedisConnectionFactory redisCF() {
        return new JedisConnectionFactory();
    }

    /**
     * 自定义redis服务器设置
     */
    //@Bean
    //public RedisConnectionFactory redisCF() {
    //    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    //    connectionFactory.setHostName("redis-server");
    //    connectionFactory.setPort(7379);
    //    connectionFactory.setPassword("+123456");
    //    return connectionFactory;
    //}

    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
        redis.setConnectionFactory(cf);
        return redis;
    }

    /**
     * 使用redisTemplate时，希望将Product类型转化为Json格式，key为String类型时
     */
    //@Bean
    //public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory cf) {
    //    RedisTemplate<String, Product> redis = new RedisTemplate<String, Product>();
    //    redis.setConnectionFactory(cf);
    //    redis.setKeySerializer(new StringRedisSerializer());
    //    redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
    //    return redis;
    //}

}
