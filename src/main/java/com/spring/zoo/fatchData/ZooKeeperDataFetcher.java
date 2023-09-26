package com.spring.zoo.fatchData;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.zoo.modules.Zookeeper;


public class ZooKeeperDataFetcher {

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    private static final String ZOOKEEPER_NODE_PATH = "/mydata";
    
   
   

    public static void main(String[] args) throws Exception {
        // Create a CuratorFramework instance
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
            ZOOKEEPER_CONNECTION_STRING,
            new ExponentialBackoffRetry(1000, 3)
        );

        // Start the connection
        curatorFramework.start();

        // Fetch data from the node
        byte[] nodeData = curatorFramework.getData().forPath(ZOOKEEPER_NODE_PATH);

        // Convert the byte array to a string (assuming the data is text)
        String dataString = new String(nodeData);
        
        Zookeeper zookeeper = new Zookeeper();
        zookeeper.setData(dataString);
        

        // Print the fetched data
        System.out.println(zookeeper.data);
        System.out.println("Data from ZooKeeper node: " + dataString);
        System.out.println();

        // Close the connection
        curatorFramework.close();
    }
}

