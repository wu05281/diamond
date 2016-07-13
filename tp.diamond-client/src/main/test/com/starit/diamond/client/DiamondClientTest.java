package com.starit.diamond.client;

import java.util.concurrent.Executor;

import com.starit.diamond.manager.DiamondManager;
import com.starit.diamond.manager.ManagerListener;
import com.starit.diamond.manager.impl.DefaultDiamondManager;

public class DiamondClientTest {
	public static void main(String[] str) {
        DiamondManager manager = new DefaultDiamondManager("develop.test", "test1",
            new ManagerListener() {//填写你服务端后台保存过的group和dataId
            public void receiveConfigInfo(String configInfo) {
                System.out.println("changed config: " + configInfo);
            }
            public Executor getExecutor() {
            return null;
            }
        });
        //设置diamond-server服务的端口
        manager.getDiamondConfigure().setPort(8080);
        String availableConfigureInfomation = manager.getAvailableConfigureInfomation(5000);
        System.out.println("start config: " + availableConfigureInfomation);
    }
}
