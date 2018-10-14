package com.example.liangjiacheng.parkinglot.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liangjiacheng.parkinglot.R;

public class Main_Fragment extends Fragment {//Frafment 为app包

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        return view;
    }
}
//        /**隐藏ActionBar的标题*/
//    getSuppotActionBar().setDisplayShowTitleEnabled(false);
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        MenuInflater inflater1 = getMenuInflater();
//
//    }
//}
