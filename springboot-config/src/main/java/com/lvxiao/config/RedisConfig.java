package com.lvxiao.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvxiao.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * Author lvxiao
 * Date 2018-12-16 20:40
 * Description: TODO
 * Version V1.0
 */
@EnableCaching
@Configuration
public class RedisConfig {
    private static Jackson2JsonRedisSerializer jackson2JsonRedisSerializer;
    private static  RedisSerializer<String> redisSerializer;
    static {
        jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisSerializer = new StringRedisSerializer();
    }


    @Bean(name = "cacheManagerDay")
    @Primary//当有多个管理器的时候，必须使用该注解在一个管理器上注释：表示该管理器为默认的管理器
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return cacheManagerFactory(connectionFactory, Duration.ofDays(1));
    }

    @Bean(name = "cacheManagerHours")
    public CacheManager cacheManager1(RedisConnectionFactory connectionFactory) {
        return cacheManagerFactory(connectionFactory, Duration.ofHours(1));
    }

    /**
     * 根据不同的缓存时间创建不同的CacheManager
     * @param connectionFactory RedisConnectionFactory
     * @param time Duration
     * @return CacheManager instance
     */
    private CacheManager cacheManagerFactory(RedisConnectionFactory connectionFactory, Duration time) {
        // 配置序列化（解决乱码的问题）
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(time)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();
    }
}
