package com.spring.zoo.fatchData;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZooKeeperJsonReader {

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    private static final String ZOOKEEPER_NODE_PATH = "/config2";

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
            ZOOKEEPER_CONNECTION_STRING,
            new ExponentialBackoffRetry(1000, 3)
        );

        curatorFramework.start();

        byte[] jsonData = curatorFramework.getData().forPath(ZOOKEEPER_NODE_PATH);
        String jsonStr = new String(jsonData);

        curatorFramework.close();
        System.out.println();

        System.out.println("JSON Data from ZooKeeper: " + jsonStr);
    }
}
