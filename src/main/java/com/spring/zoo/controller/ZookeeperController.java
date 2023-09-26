package com.spring.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.zoo.modules.Config;
import com.spring.zoo.service.ConfigService;



@RestController
@RequestMapping(value="/zookeeper")
public class ZookeeperController {
	
	@Autowired
	ConfigService configService;
	
	@GetMapping
	public Config getConfig() throws Exception {
		return configService.getConfigFromZooKeeper();
		
	}
   

}
