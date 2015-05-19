package com.yjrg.app.manager.login;

import android.content.Context;

import com.yjrg.app.enumerate.HttpUrl;
import com.yjrg.app.manager.RestClient;
import com.yjrg.app.manager.vo.BasicRequest;
import com.yjrg.app.manager.vo.CodeResponse;

import de.greenrobot.event.EventBus;
import retrofit.RestAdapter;

/**
 * Created by ${valuesFeng} on ${2014.9.1}.
 */
public class LoginManager {

    private static LoginManager sInstance;
    private ILoginAPI mIUserApi;
    private Context context;

    public LoginManager() {
    }

    public LoginManager(Context context) {
        this.context = context;
    }

    public synchronized static LoginManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new LoginManager(context);
            RestAdapter restAdapter = RestClient.getAdapter(context);
            sInstance.mIUserApi = restAdapter.create(ILoginAPI.class);
        }
        return sInstance;
    }


    public static class LoginRequest extends BasicRequest {
        private String mobile;
        private String passwd;
        private String uuid;
        private String platforminfo;
        private String systeminfo;

        public LoginRequest(String mobile, String passwd, String uuid, String platforminfo, String systeminfo) {
            this.version = HttpUrl.VERSION.getUrl();
            this.mobile = mobile;
            this.passwd = passwd;
            this.uuid = uuid;
            this.platforminfo = platforminfo;
            this.systeminfo = systeminfo;
        }

    }

    public static class LoginResponse {
        private CodeResponse codeResponse;

        public LoginResponse(CodeResponse codeResponse) {
            this.codeResponse = codeResponse;
        }

        public CodeResponse getCodeResponse() {
            return codeResponse;
        }
    }

    public static class LoginResponseError {

    }

    public void onEventAsync(LoginRequest request) {
        try {
            CodeResponse codeResponse = mIUserApi.login(HttpUrl.LOGIN.getUrl(),
                    request.getVersion(),
                    request.mobile,
                    request.passwd,
                    request.uuid,
                    request.platforminfo,
                    request.systeminfo);
            EventBus.getDefault().post(new LoginResponse(codeResponse));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            EventBus.getDefault().post(new LoginResponseError());
        }
    }
}
