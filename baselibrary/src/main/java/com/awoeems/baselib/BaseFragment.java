package com.awoeems.baselib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.crashlytics.android.Crashlytics;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Crashlytics.setString(Constants.CURRENT_PAGE, getClass().getName());
    }
}
