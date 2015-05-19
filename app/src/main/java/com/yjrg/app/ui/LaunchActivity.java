package com.yjrg.app.ui;

import android.os.Handler;

import com.yjrg.app.R;
import com.yjrg.app.ui.base.BaseActivity;
import com.yjrg.app.ui.util.IntentUtil;


public class LaunchActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        super.init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                IntentUtil.startLogin(LaunchActivity.this);
            }
        }, 3000);
    }
}