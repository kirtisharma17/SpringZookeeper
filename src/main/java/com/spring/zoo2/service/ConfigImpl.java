package com.spring.zoo2.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.zoo2.module.MongoDBConfig;
import com.spring.zoo2.repo.ConfigRepo;

@Service
public class ConfigImpl implements ConfigService {
	
	@Autowired
	private ConfigRepo Repository;


	@Override
	public MongoDBConfig createConfig(MongoDBConfig config) {
		// TODO Auto-generated method stub
		return Repository.save(config);
	}


	@Override
	public List<MongoDBConfig> getAllRating() {
		// TODO Auto-generated method stub
		return Repository.findAll();
	}


	

}
