package com.spring.zoo2.module;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "my.config")
@Document("Zookeeper_Config")
public class Config {
	
	@Id
	private String id="1";
    private String property1;
    private String property2;
    private String property3;
    private String uri;
    private String database;
    

    public Config() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProperty1() {
        return property1;
    }
	

    public Config(String id, String property1, String property2, String property3, String uri, String database) {
		super();
		this.id = id;
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
		this.uri = uri;
		this.database = database;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public Config(String property1, String property2, String property3, String uri, String database) {
		super();
		this.property1 = property1;
		this.property2 = property2;
		this.property3 = property3;
		this.uri = uri;
		this.database = database;
		
	}

	@Override
	public String toString() {
		return "Config [property1=" + property1 + ", property2=" + property2 + ", property3=" + property3 + ", uri="
				+ uri + ", database=" + database + "]";
	}
	
    
}

