package com.example.liangjiacheng.parkinglot.JAVA;

import org.xutils.x;

/**
 * create by liangjiacheng on 2018/10/13
 * 这个类的作用是：代表整个软件的最先入口
 * 注意需要在AndroidManifest.xml里面配置（即功能清单）：  android:name=".JAVA.Application"，不然会报错 。
 */
public class Application extends android.app.Application{
    //所有组件被创建之前执行
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.setDebug(true);
        x.Ext.init(this);
    }
}
