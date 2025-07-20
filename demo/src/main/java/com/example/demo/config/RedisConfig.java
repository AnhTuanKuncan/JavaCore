package com.example.demo.config;

import java.io.ObjectInputFilter.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.demo.dto.ProductDTO;

@Configuration
public class RedisConfig {
	
	private static final String redisUrl ="";
	
	@Bean
	public Config config() {
		Config config = new Config()
	}
	
	@Bean(name ="REDIS_PRODUCT")
	public RedisTemplate<String, ProductDTO> connectProduct(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, ProductDTO> product = new RedisTemplate<>();
	}

}
