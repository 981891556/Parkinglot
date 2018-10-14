package com.example.liangjiacheng.parkinglot.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * create by liangjiacheng on 2018/10/14  9:45
 * 这个类的作用是：自定义Viewp使其不可以滑动
 */
public class NoScrollViewPager extends ViewPager {
    /**
     * 通常在代码实例化的时候用该方法
     * @param context
     */
    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    /**    在布局文件中使用该类的时候，实例化该类用该构造方法，这个构造方法不能少，少了会崩溃
     * @param context
     * @param attrs
     */
    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**重写触摸时间，消耗掉
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
