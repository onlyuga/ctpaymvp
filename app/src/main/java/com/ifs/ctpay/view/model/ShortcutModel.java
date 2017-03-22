package com.ifs.ctpay.view.model;

import android.support.v4.app.Fragment;

/**
 * Created by K53SV on 3/21/2017.
 */

public class ShortcutModel {
    public int icon;
    public String title;
    public Fragment fragment;

    public ShortcutModel(int icon, String title, Fragment fragment) {
        this.icon = icon;
        this.title = title;
        this.fragment = fragment;
    }
}
