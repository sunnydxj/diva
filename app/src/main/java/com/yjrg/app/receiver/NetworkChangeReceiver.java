package com.yjrg.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yjrg.app.event.NetworkChangeEvent;
import com.yjrg.app.util.NetworkUtil;

import de.greenrobot.event.EventBus;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        int status = NetworkUtil.getConnectivityStatus(context);
            EventBus.getDefault().post(new NetworkChangeEvent(status));
    }

}