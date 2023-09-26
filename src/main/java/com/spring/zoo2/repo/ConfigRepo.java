package com.spring.zoo2.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.zoo2.module.MongoDBConfig;

public interface ConfigRepo  extends MongoRepository<MongoDBConfig, String>{
	
	//custom finder methods
	
	

}
