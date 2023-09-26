package com.spring.zoo2.module;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mongodb")
public class MongoDBConfig {

    private String host;
    private int port;
    private String database;
	public MongoDBConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MongoDBConfig(String host, int port, String database) {
		super();
		this.host = host;
		this.port = port;
		this.database = database;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	@Override
	public String toString() {
		return "MongoDBConfig [host=" + host + ", port=" + port + ", database=" + database + "]";
	}

    
}

