package com.ifs.ctpay.util;

import android.support.v4.app.Fragment;

/**
 * Created by K53SV on 3/18/2017.
 */

public class FragmentData {
    private int view;
    private Fragment fragment;

    public FragmentData(int view, Fragment fragment) {
        this.view = view;
        this.fragment = fragment;
    }

    public int getView() {
        return view;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
