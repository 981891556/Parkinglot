package com.example.liangjiacheng.parkinglot.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.liangjiacheng.parkinglot.Activity.About_us;
import com.example.liangjiacheng.parkinglot.Activity.feedback_feedback;
import com.example.liangjiacheng.parkinglot.Activity.my_car_Activity;
import com.example.liangjiacheng.parkinglot.Activity.my_message;
import com.example.liangjiacheng.parkinglot.Activity.nocturnal_pattern;
import com.example.liangjiacheng.parkinglot.Activity.person_setting;
import com.example.liangjiacheng.parkinglot.Activity.setting_background;
import com.example.liangjiacheng.parkinglot.Activity.setting_head;
import com.example.liangjiacheng.parkinglot.Activity.subject_skin;
import com.example.liangjiacheng.parkinglot.R;

public class My_Fragment extends Fragment {//Frafment 为app包
    private LinearLayout ll_header_bg; //背景图片
    private ImageView iv_head;//头像
    private LinearLayout personal_center;//个人中心
    private LinearLayout my_car;//我的爱车
    private LinearLayout last_information;//我的消息
    private LinearLayout skin;//主题换肤
    private LinearLayout night_mode;//夜间模式
    private LinearLayout last_advise;//意见反馈
    private LinearLayout about_us;//关于我们

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ll_header_bg = getActivity().findViewById(R.id.ll_header_bg);
        iv_head = getActivity().findViewById(R.id.iv_head);
        personal_center = getActivity().findViewById(R.id.personal_center);
        my_car = getActivity().findViewById(R.id.my_car);
        last_information = getActivity().findViewById(R.id.last_information);
        skin = getActivity().findViewById(R.id.skin);
        night_mode = getActivity().findViewById(R.id.night_mode);
        last_advise = getActivity().findViewById(R.id.last_advise);
        about_us = getActivity().findViewById(R.id.about_us);

        //设置背景
        ll_header_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), setting_background.class);
                startActivity(intent);
            }
        });

        //设置头像
        iv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), setting_head.class);
                startActivity(intent);

            }
        });


//个人中心
        personal_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), person_setting.class);
                startActivity(intent);

            }
        });

        //我的爱车
        my_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), my_car_Activity.class);
                startActivity(intent);

            }
        });

        //我的消息
        last_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), my_message.class);
                startActivity(intent);

            }
        });

        //主题换肤
        skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), subject_skin.class);
                startActivity(intent);
            }
        });

        //夜间模式
        night_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), nocturnal_pattern.class);
                startActivity(intent);

            }
        });

        //意见反馈
        last_advise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), feedback_feedback.class);
                startActivity(intent);

            }
        });

        //关于我们
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), About_us.class);
                startActivity(intent);
            }
        });
    }
}

