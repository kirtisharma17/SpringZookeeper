package com.spring.zoo2;

import java.nio.charset.StandardCharsets;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.zoo2.module.Config;
import com.spring.zoo2.module.MongoDBConfig;

@SpringBootApplication
@EnableAutoConfiguration()
public class SpringCloudWeb1ZookeeperApplication {
	
	 private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
	    private static final String ZOOKEEPER_NODE_PATH = "/mongodb";
	    
	   


	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringCloudWeb1ZookeeperApplication.class, args);
		
		
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
	            ZOOKEEPER_CONNECTION_STRING,
	            new ExponentialBackoffRetry(1000, 3)
	        );

	        
		curatorFramework.start();
		
          
	        byte[] jsonData = curatorFramework.getData().forPath(ZOOKEEPER_NODE_PATH);
	        String jsonStr = new String(jsonData, StandardCharsets.UTF_8);

	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode configJson = objectMapper.readTree(jsonStr);
	        
	        System.out.println("JsonNode: " + configJson);
	        
	        MongoDBConfig mongoDB = objectMapper.readValue(jsonStr, MongoDBConfig.class);

	        System.out.println("MongoDb Config: " + mongoDB);

	        String host = configJson.get("host").asText();
	        int port = configJson.get("port").asInt();
	        String database = configJson.get("database").asText();
	        
	        System.out.println("host name= "+host+"port= "+port+"database= "+ database);
	        
	        MongoDBConfig mongoDBConfig = new MongoDBConfig();
	        
	        mongoDBConfig.setHost(host);
	        mongoDBConfig.setPort(port);
	        mongoDBConfig.setDatabase(database);
	        
	        
	        curatorFramework.close();
	      
	        System.out.println("String Config: " + jsonStr);
	        System.out.println("object of mongodb= "+mongoDBConfig.getHost()+" "+mongoDBConfig.getPort()+" "+mongoDBConfig.getDatabase());
            }
          
	}


