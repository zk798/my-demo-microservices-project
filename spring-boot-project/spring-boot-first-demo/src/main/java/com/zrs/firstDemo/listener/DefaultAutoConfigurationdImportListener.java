package com.zrs.firstDemo.listener;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;

public class DefaultAutoConfigurationdImportListener implements AutoConfigurationImportListener {
    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        System.out.println("进入监听"+event);
    }
}
