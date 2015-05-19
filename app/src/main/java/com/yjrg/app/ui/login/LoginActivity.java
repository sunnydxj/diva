package com.yjrg.app.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yjrg.app.R;
import com.yjrg.app.manager.login.LoginManager;
import com.yjrg.app.ui.base.EventActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by ${valuesFeng} on ${2014.9.1}.
 */
public class LoginActivity extends EventActivity {

    @InjectView(R.id.et_user_name)
    EditText mEtUserName;
    @InjectView(R.id.et_user_pwd)
    EditText mEtUserPwd;
    @InjectView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    void login() {
//        EventBus.getDefault().post(new LoginManager.LoginRequest("13020121809",
//                "123123", "", "", ""));
        EventBus.getDefault().post(new LoginManager.LoginRequest(mEtUserName.getText().toString(),
                mEtUserPwd.getText().toString(), "", "", ""));
    }

    public void onEventMainThread(LoginManager.LoginResponse response) {
        if (response.getCodeResponse().getCode() == 200) {
            Toast.makeText(this, "登录成功!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, response.getCodeResponse().getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onEventMainThread(LoginManager.LoginResponseError error) {
        Toast.makeText(this, "未知错误", Toast.LENGTH_SHORT).show();
    }
}
