package com.spring.zoo;


	import org.apache.curator.framework.CuratorFramework;
	import org.apache.curator.framework.CuratorFrameworkFactory;
	import org.apache.curator.retry.ExponentialBackoffRetry;
	import org.apache.zookeeper.CreateMode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

	@SpringBootApplication
	@EnableAutoConfiguration()
   public class ZooKeeperSequentialNodeCreator {

		 private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
	    private static final String ZOOKEEPER_PARENT_NODE_PATH = "/mydata2";
	    private static final byte[] DATA = "Hello from sequential node!".getBytes();

	    public static void main(String[] args) throws Exception {
	        // Create a CuratorFramework instance
	        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
	            ZOOKEEPER_CONNECTION_STRING,
	            new ExponentialBackoffRetry(1000, 3)
	        );

	        // Start the connection
	        curatorFramework.start();

	        // Create a sequential node under the parent node with data using the create method
	        String sequentialNodePath = curatorFramework.create()
	            .creatingParentsIfNeeded()  // Create parent nodes if they don't exist
	            .withMode(CreateMode.PERSISTENT_SEQUENTIAL)  // Specify sequential mode
	            .forPath(ZOOKEEPER_PARENT_NODE_PATH + "/sequential-", DATA);

	        System.out.println("Sequential node path with data: " + sequentialNodePath);

	        // Close the connection
	        curatorFramework.close();
	    }
	}

	    



