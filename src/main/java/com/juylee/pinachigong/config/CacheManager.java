package com.juylee.pinachigong.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheManager {
	@Value("${spring.redis.port}")
	public int port;
	  
	@Value("${spring.redis.host}")
	public String host;
	
	@Bean
	public RedisConnectionFactory redisConnectionFacroty() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setPort(port);
		redisStandaloneConfiguration.setHostName(host);
		LettuceConnectionFactory lettuceConnectionFactory = 
				new LettuceConnectionFactory(redisStandaloneConfiguration);
		
		return lettuceConnectionFactory;
	}
	
	@Bean
	public RedisCacheManager redisCacheManager() {
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
								.serializeKeysWith(
										RedisSerializationContext.SerializationPair.fromSerializer(
												new StringRedisSerializer()))
								.serializeValuesWith(
										RedisSerializationContext.SerializationPair.fromSerializer(
												new GenericJackson2JsonRedisSerializer()));
		
		return RedisCacheManager.RedisCacheManagerBuilder
					.fromConnectionFactory(redisConnectionFacroty())
					.cacheDefaults(redisCacheConfiguration)
					.build();
		
	}
}
