package com.spring.zoo.modules;

import org.springframework.stereotype.Component;

@Component
public class Zookeeper {
	private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    private static final String ZOOKEEPER_NODE_PATH = "/mydata1/sequential-";
    
    public String data;

	public Zookeeper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Zookeeper(String data) {
		super();
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
    
    

}
