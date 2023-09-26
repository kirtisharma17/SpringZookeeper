package com.spring.zoo2.createZoofile;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZooKeeperConfigiWriter {

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    public static final String ZOOKEEPER_NODE_PATH = "/mongodb2";
    private static final String CONFIG_JSON = "{\"host\":\"localhost\",\"port\":\"27017\",\"database\":\"BookStore\"}";


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
