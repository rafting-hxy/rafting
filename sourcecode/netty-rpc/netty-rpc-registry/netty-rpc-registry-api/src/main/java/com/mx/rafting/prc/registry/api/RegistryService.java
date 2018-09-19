package com.mx.rafting.prc.registry.api;

import java.net.URL;

public interface RegistryService {
    void register(URL url);
    void unregister(URL url);
}
