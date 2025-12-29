package org.example.expert.config;

import org.example.expert.domain.user.dto.response.UserResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisCacheConfig {

    //@Cacheable 사용시
    @Bean
    public RedisCacheManager cacheConfig(RedisConnectionFactory cf) {

        RedisCacheConfiguration config =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(1))    //1분
                        .disableCachingNullValues();

        return RedisCacheManager.builder(cf)
                .cacheDefaults(config)
                .build();
    }

    @Bean
    public RedisTemplate<String, UserResponse> usereRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, UserResponse> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        template.setKeySerializer(new StringRedisSerializer());

        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}
