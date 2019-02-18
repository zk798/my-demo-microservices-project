package com.zrs.dubbo.server.provider;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

public class App {

    public static void main(String[] args) {
        Protocol protocol =
                ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();

        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);

        System.out.println(extensionLoader.getDefaultExtensionName());
        System.out.println(extensionLoader.getDefaultExtension().getDefaultPort());
    }
}
