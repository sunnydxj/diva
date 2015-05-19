package com.yjrg.app.ui.util;

import android.content.Context;
import android.content.Intent;

import com.yjrg.app.ui.login.LoginActivity;

/**
 * Created by ${valuesFeng} on ${2014.9.1}.
 */
public class IntentUtil {

    public static void startLogin(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }
}
