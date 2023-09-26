package com.spring.zoo.createFile;


	import org.apache.curator.framework.CuratorFramework;
	import org.apache.curator.framework.CuratorFrameworkFactory;
	import org.apache.curator.retry.ExponentialBackoffRetry;
	import org.apache.zookeeper.CreateMode;

	public class ZooKeeperFileCreator {

	    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
	    private static final String ZOOKEEPER_NODE_PATH = "/mydata/myfile.txt";

	    public static void main(String[] args) throws Exception {
	        // Create a CuratorFramework instance
	        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
	            ZOOKEEPER_CONNECTION_STRING,
	            new ExponentialBackoffRetry(1000, 3)
	        );

	        // Start the connection
	        curatorFramework.start();

	        // Create the file-like structure using the create method
	        byte[] fileData = "This is the content of my file.".getBytes();
	        curatorFramework.create()
	            .creatingParentsIfNeeded()  // Create parent nodes if they don't exist
	            .withMode(CreateMode.PERSISTENT)  // Specify the node type
	            .forPath(ZOOKEEPER_NODE_PATH, fileData);

	        // Close the connection
	        curatorFramework.close();
	    }
	}



