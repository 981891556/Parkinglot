package com.example.liangjiacheng.parkinglot.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.liangjiacheng.parkinglot.Fragment.ContentFragment;
import com.example.liangjiacheng.parkinglot.Fragment.LeftmenuFragment;
import com.example.liangjiacheng.parkinglot.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import com.example.liangjiacheng.parkinglot.utils.DensityUtil;


/**
 * 继承的类 是由 SlidingMenu_library提供
 * */
public class MainActivity extends SlidingFragmentActivity {

    public static final String MAIN_CONTENT_TAG = "main_content_tag";
    public static final String LEFTMENU_TAG = "leftmenu_tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSlidingMenu();
        //初始化Fragment
        initFragment();
    }

    private void initSlidingMenu(){
        //1.设置主页面
        setContentView(R.layout.activity_main);
        //2.设置左侧菜单
        setBehindContentView(R.layout.activity_left_menu);
        //3.设置右侧菜单,但是我这个项目没有用到右侧菜单
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.activity_righty_menu);//设置右侧菜单
        //4.设置显示模式：左侧菜单+主菜单；左侧菜单+主菜单+右侧菜单；主菜单+右侧菜单
        slidingMenu.setMode(SlidingMenu.LEFT);
        //5.设置滑动模式：滑动边缘，全屏滑动，不可以滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏滑动
        //6.设置主页占据的宽度  ,主页面占据的宽度
        slidingMenu.setBehindOffset(DensityUtil.dip2px(MainActivity.this,200));
    }
    private void initFragment() {
        //1.得到Framgment V4包
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft =  fm.beginTransaction();
        // 3.替换Fragment
        ft.replace(R.id.fl_main_content,new ContentFragment(), MAIN_CONTENT_TAG);//主页
        ft.replace(R.id.fl_leftmenu,new LeftmenuFragment(), LEFTMENU_TAG);//左侧
        //提交
        ft.commit();
    }
}























/***下面是自己写的代码不能删除*/
//    private Main_Fragment main_fragment;
//    private Now_Fragment now_fragment;
//    private About_Fragment about_fragment;
//    private My_Fragment my_fragment;
//
//
//    /**单选组件*/
//    private RadioButton radio_btn1;
//    private RadioButton radio_btn2;
//    private RadioButton radio_btn3;
//    private RadioButton radio_btn4;
//
//
//    /**
//     * 用于对Fragment进行管理
//     */
//    private FragmentManager fragmentManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initViews();
//        fragmentManager = getSupportFragmentManager();
//        // 第一次启动时选中第0个tab
//        setTabSelection(0);
//    }
//
//    /**
//     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
//     */
//
//    private void initViews() {
//        radio_btn1 = findViewById(R.id.radio_btn1);
//        radio_btn2 = findViewById(R.id.radio_btn2);
//        radio_btn3 = findViewById(R.id.radio_btn3);
//        radio_btn4 = findViewById(R.id.radio_btn4);
//        radio_btn1.setOnClickListener(this);
//        radio_btn2.setOnClickListener(this);
//        radio_btn3.setOnClickListener(this);
//        radio_btn4.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.radio_btn1:
//                // 当点击了消息tab时，选中第1个tab
//                setTabSelection(0);
//                break;
//            case R.id.radio_btn2:
//                // 当点击了联系人tab时，选中第2个tab
//                setTabSelection(1);
//                break;
//            case R.id.radio_btn3:
//                // 当点击了动态tab时，选中第3个tab
//                setTabSelection(2);
//                break;
//            case R.id.radio_btn4:
//                // 当点击了设置tab时，选中第4个tab
//                setTabSelection(3);
//                break;
//            default:
//                break;
//        }
//
//    }
//
//    /**
//     * 根据传入的index参数来设置选中的tab页。
//     *
//     * @param index
//     * 每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
//     */
//    private void setTabSelection(int index) {
//        // 每次选中之前先清楚掉上次的选中状态
//        clearSelection();
//        // 开启一个Fragment事务
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
//        hideFragments(transaction);
//        switch (index) {
//            case 0:
//                radio_btn1.setBackgroundColor(0x808080);
//
//                if (main_fragment == null) {
//                    // 如果MessageFragment为空，则创建一个并添加到界面上
//                    main_fragment = new Main_Fragment();
////                    transaction.addToBackStack(null);/**添加到堆栈中。*/
//                    transaction.add(R.id.content, main_fragment);
//                } else {
//                    // 如果MessageFragment不为空，则直接将它显示出来
//                    transaction.show(main_fragment);
//                }
//                break;
//            case 1:
//                // 当点击了联系人tab时，改变控件的图片和文字颜色
//                radio_btn2.setBackgroundColor(0x808080);
//                if (now_fragment == null) {
//                    // 如果ContactsFragment为空，则创建一个并添加到界面上
//                    now_fragment = new Now_Fragment();
////                    transaction.addToBackStack(null);/**添加到堆栈中。*/
//                    transaction.add(R.id.content, now_fragment);
//                } else {
//                    // 如果ContactsFragment不为空，则直接将它显示出来
//                    transaction.show(now_fragment);
//                }
//                break;
//            case 2:
//                // 当点击了动态tab时，改变控件的图片和文字颜色
//                radio_btn3.setBackgroundColor(0x808080);
//                if (about_fragment == null) {
//                    // 如果NewsFragment为空，则创建一个并添加到界面上
//                    about_fragment = new About_Fragment();
////                    transaction.addToBackStack(null);/**添加到堆栈中。*/
//                    transaction.add(R.id.content, about_fragment);
//                } else {
//                    // 如果NewsFragment不为空，则直接将它显示出来
//                    transaction.show(about_fragment);
//                }
//                break;
//            case 3:
//            default:
//                // 当点击了设置tab时，改变控件的图片和文字颜色
//                radio_btn4.setBackgroundColor(0x808080);
//                if (my_fragment == null) {
//                    // 如果SettingFragment为空，则创建一个并添加到界面上
//                    my_fragment = new My_Fragment();
////                    transaction.addToBackStack(null);  /**添加到堆栈中。*/
//                    transaction.add(R.id.content, my_fragment);
//                } else {
//                    // 如果SettingFragment不为空，则直接将它显示出来
//                    transaction.show(my_fragment);
//                }
//                break;
//        }
//        transaction.commit();
//    }
//
//    /**
//     * 将所有的Fragment都置为隐藏状态。
//     *
//     * @param transaction
//     * 用于对Fragment执行操作的事务
//     */
//    private void hideFragments(FragmentTransaction transaction) {
//        if (main_fragment != null) {
//            transaction.hide(main_fragment);
//        }
//        if (now_fragment != null) {
//            transaction.hide(now_fragment);
//        }
//        if (about_fragment!= null) {
//            transaction.hide(about_fragment);
//        }
//        if (my_fragment != null) {
//            transaction.hide(my_fragment);
//        }
//    }
//
//    /**
//     * 清除掉所有的选中状态。
//     */
//    private void clearSelection() {
//        radio_btn1.setBackgroundColor(0x808080);
//        radio_btn2.setBackgroundColor(0x808080);
//        radio_btn3.setBackgroundColor(0x808080);
//        radio_btn4.setBackgroundColor(0x808080);//0xffffffff
//    }
//}
//
