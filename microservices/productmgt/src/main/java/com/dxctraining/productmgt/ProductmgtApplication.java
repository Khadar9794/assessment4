package com.dxctraining.productmgt;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
public class ProductmgtApplication {
	
	@Value("${spring.data.mongodb.database}")
	private String databaseName;


	public static void main(String[] args) {
		SpringApplication.run(ProductmgtApplication.class, args);

	}
	
	@Bean
	public MongoTemplate mongoTemplate(MongoClient client){
		MongoTemplate template=new MongoTemplate(client,databaseName);
		return template;
	}

	

}
