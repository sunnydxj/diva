package com.yjrg.app.ui.base;

import android.app.Activity;

import de.greenrobot.event.EventBus;

/**
 * Created by valuesFeng on 15-5-16.
 */
public abstract class EventFragment extends BaseFragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

}
