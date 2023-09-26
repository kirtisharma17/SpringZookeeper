package com.spring.zoo2.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.zoo2.module.MongoDBConfig;
import com.spring.zoo2.service.ConfigService;

@RequestMapping("/zookeeper")
@RestController
public class ZookeeperController {
	
	
	private final CuratorFramework curatorFramework ;
	

     public ZookeeperController(CuratorFramework curatorFramework) {
		super();
		this.curatorFramework = curatorFramework;
	}
	
     @GetMapping("/data")
     public String fetchZooKeeperData()  {
    	 try {
        byte[] zooKeeperDataBytes = curatorFramework.getData().forPath("/mongodb");
        return new String(zooKeeperDataBytes, StandardCharsets.UTF_8);
    }catch(Exception e) {
    	
            // Handle exceptions
            return "Error fetching data from ZooKeeper: " + e.getMessage();
        
    }
     }
	
	@Autowired
	private ConfigService configService ;
	
	//create rating
	@PostMapping
	public ResponseEntity<MongoDBConfig> create(@RequestBody MongoDBConfig config){
		return ResponseEntity.status(HttpStatus.CREATED).body(configService.createConfig(config));
		
		}
	// get all
	@GetMapping
	public ResponseEntity<List<MongoDBConfig>> getRatings(){
		return ResponseEntity.ok(configService.getAllRating());
		
	}
	


}
