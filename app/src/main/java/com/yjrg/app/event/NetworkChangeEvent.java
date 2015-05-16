package com.yjrg.app.event;

/**
* Created by user on 14-6-17.
*/
public class NetworkChangeEvent {
    private int mStatus;

    public int getStatus() {
        return mStatus;
    }

    public NetworkChangeEvent(int status) {
        mStatus = status;
    }
}
