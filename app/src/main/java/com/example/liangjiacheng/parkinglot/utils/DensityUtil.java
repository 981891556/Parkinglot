package com.example.liangjiacheng.parkinglot.utils;

import android.content.Context;

public class DensityUtil {
    /** 单位转换工具：为了适应手机屏幕分辨率不同导致的布局显示有所不同
     * px和dp互相转换工具
     * */
    public static int dip2px(Context context ,float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    /**
     * 根据手机的分辨率从px（像素）转换成dp
     * */
    public static int px2dip(Context context ,float pxValue){
        final float scale  = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }
}
