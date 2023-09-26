package com.spring.zoo2.service;

import java.util.List;



import com.spring.zoo2.module.MongoDBConfig;

public interface ConfigService {
	
	//create
	
	MongoDBConfig createConfig(MongoDBConfig config);

	List<MongoDBConfig> getAllRating();
	
	

	

}
