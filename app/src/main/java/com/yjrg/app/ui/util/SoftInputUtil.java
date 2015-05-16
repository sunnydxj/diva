package com.yjrg.app.ui.util;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by valuseFeng on 14-6-15.
 */
public class SoftInputUtil {

    public static void hideKeyBoard(Activity activity) {
        try {
            ((InputMethodManager) activity
                    .getSystemService(Activity.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus()
                            .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void showKeyBoard(Context context) {
        if (context != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
