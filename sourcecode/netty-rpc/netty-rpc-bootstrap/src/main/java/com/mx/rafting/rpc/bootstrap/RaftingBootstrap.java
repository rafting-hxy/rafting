package com.mx.rafting.rpc.bootstrap;

import com.mx.rafting.rpc.config.ServiceConfig;

import java.util.List;

/**
 * Created by admin on 2018/9/20.
 */
public class RaftingBootstrap {
    private List<ServiceConfig> serviceConfigList;

    public void start() {
        for (ServiceConfig serviceConfig: serviceConfigList) {
            serviceConfig.export();
        }
    }
}
