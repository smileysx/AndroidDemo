package com.codebear.demo.demo.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codebear.demo.R;
import com.codebear.demo.base.BaseActivity;
import com.codebear.demo.demo.face_detection.activity.FaceDetectionActivity;
import com.codebear.demo.demo.jni.activity.JniTestActivity;
import com.codebear.demo.demo.keyboard.activity.KeyboardActivity;
import com.codebear.demo.demo.main.adapter.MainButtonAdapter;
import com.codebear.demo.demo.main.bean.MainButton;
import com.codebear.demo.demo.starview.StarViewActivity;
import com.codebear.demo.demo.toolbar.ToolbarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rcv_button)
    RecyclerView rcvButton;

    private MainButtonAdapter mainButtonAdapter;
    private List<MainButton> buttonList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        init();
        initData();
        showData();
    }

    private void init() {
        rcvButton.setHasFixedSize(true);
        rcvButton.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mainButtonAdapter = new MainButtonAdapter(this);
        rcvButton.setAdapter(mainButtonAdapter);

        mainButtonAdapter.setOnItemClickListener(new MainButtonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openDemo(position);
            }
        });
    }

    private void initData() {
        buttonList.add(new MainButton(1, "人脸检测"));
        buttonList.add(new MainButton(2, "jni"));
        buttonList.add(new MainButton(3, "Keyboard"));
        buttonList.add(new MainButton(4, "Toolbar"));
        buttonList.add(new MainButton(5, "StarView"));
    }

    private void showData() {
        mainButtonAdapter.addAll(buttonList);
    }

    private void openDemo(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, FaceDetectionActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, JniTestActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, KeyboardActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, ToolbarActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, StarViewActivity.class));
                break;
            default:
                break;
        }
    }
}
