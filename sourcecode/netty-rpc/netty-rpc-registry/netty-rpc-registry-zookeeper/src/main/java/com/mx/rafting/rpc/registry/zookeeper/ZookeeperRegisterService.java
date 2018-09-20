package com.mx.rafting.rpc.registry.zookeeper;


import com.mx.rafting.rpc.registry.api.RegistryService;
import org.I0Itec.zkclient.ZkClient;

import java.net.URL;

public class ZookeeperRegisterService implements RegistryService {

    private final ZkClient zkClient = null;


    public ZookeeperRegisterService(URL url) {
       
    }

    @Override
    public void register(URL url) {

    }

    @Override
    public void unregister(URL url) {

    }
}
