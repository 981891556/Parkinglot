package com.example.liangjiacheng.parkinglot.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**这个Fragment 的基类，用于代码复用，提高性能*/
public abstract class BaseFragment  extends Fragment{
    public Activity content;

    /**
     * 当Fragment被创建时回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = getActivity();
    }

    /**当视图被创建时回调这个方法
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    //让孩子实现自己的视图，达到自己特有的效果
    public abstract View initView();

    /**当Activity被创建之后回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    //如果子页面没有数据，联网请求数据，并且绑定到initView（）方法初始化的视图上
    //如果有数据就直接绑定
    public  void initDate(){

    }
}

