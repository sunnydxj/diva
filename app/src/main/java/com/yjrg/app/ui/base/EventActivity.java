package com.yjrg.app.ui.base;

import de.greenrobot.event.EventBus;

/**
 * Created by valuesFeng on 15-5-16.
 */
public abstract class EventActivity extends BaseActivity {

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}