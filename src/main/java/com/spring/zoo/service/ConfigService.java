package com.spring.zoo.service;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.zoo.ZooKeeperConfigWriter;
import com.spring.zoo.modules.Config;

@Service
public class ConfigService {

    private final CuratorFramework curatorFramework;
    private final ObjectMapper objectMapper;

    public ConfigService(CuratorFramework curatorFramework, ObjectMapper objectMapper) {
        this.curatorFramework = curatorFramework;
        this.objectMapper = objectMapper;
    }

    public Config getConfigFromZooKeeper() throws Exception {
        byte[] configData = curatorFramework.getData().forPath(ZooKeeperConfigWriter.ZOOKEEPER_NODE_PATH );
        return objectMapper.readValue(configData, Config.class);
    }
}

