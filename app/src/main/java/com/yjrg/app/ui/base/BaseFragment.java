package com.yjrg.app.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by valuesFeng on 15-5-16.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    protected abstract int getLayout();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    public void init() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(getClass().getSimpleName()); //统计页面
    }

    public void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(getClass().getSimpleName());
    }
}
