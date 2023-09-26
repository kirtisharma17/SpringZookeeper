package com.spring.zoo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZooKeeperConfigWriter {

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    public static final String ZOOKEEPER_NODE_PATH = "/config2";
    private static final String CONFIG_JSON = "{\"property1\":\"value1\",\"property2\":\"value2\",\"property3\":\"value3\","
			+ "\"uri\":\"mongodb://localhost:27017\",\"database\":\"microservice\"}";


    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
            ZOOKEEPER_CONNECTION_STRING,
            new ExponentialBackoffRetry(1000, 3)
        );

        curatorFramework.start();

        curatorFramework.create()
            .creatingParentsIfNeeded()
            .withMode(CreateMode.PERSISTENT)
            .forPath(ZOOKEEPER_NODE_PATH, CONFIG_JSON.getBytes());

        curatorFramework.close();
    }
}
