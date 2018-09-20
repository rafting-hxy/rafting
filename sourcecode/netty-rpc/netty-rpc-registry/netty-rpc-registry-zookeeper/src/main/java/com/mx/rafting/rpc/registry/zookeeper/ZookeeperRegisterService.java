package com.mx.rafting.rpc.registry.zookeeper;


import com.mx.rafting.rpc.registry.api.RegistryService;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class ZookeeperRegisterService implements RegistryService {

    private final ZooKeeper  zooKeeper;

    private final CountDownLatch latch = new CountDownLatch(1);

    int ZK_SESSION_TIMEOUT = 10000;
    String ZK_CONNECT = "localhost:2181";
    String ZK_REGISTRY_PATH = "/registry";
    String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
    String ZK_IP_SPLIT = ":";

    public ZookeeperRegisterService(URL url) {
        zooKeeper =  connectServer();
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(ZK_CONNECT, ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // 判断是否已连接ZK,连接后计数器递减.
                    if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });

            // 若计数器不为0,则等待.
            latch.await();
        } catch (IOException | InterruptedException e) {

        }
        return zk;
    }

    @Override
    public void register(URL url) {
        zkClient.create(toUrlPath(url), url.getParameter(Constants.DYNAMIC_KEY, true));

    }

    private String toServicePath(URL url) {
        String name = url.getServiceInterface();
        if (Constants.ANY_VALUE.equals(name)) {
            return toRootPath();
        }
        return toRootDir() + URL.encode(name);
    }



    private String toUrlPath(URL url) {
        return toCategoryPath(url) + Constants.PATH_SEPARATOR + URL.encode(url.toFullString());
    }

    @Override
    public void unregister(URL url) {

    }
}
