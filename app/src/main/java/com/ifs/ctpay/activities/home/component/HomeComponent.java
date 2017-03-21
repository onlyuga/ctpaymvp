package com.ifs.ctpay.activities.home.component;


import com.ifs.ctpay.activities.MainActivity;
import com.ifs.ctpay.activities.home.module.HomeModule;
import com.ifs.ctpay.app.AppComponent;
import com.ifs.ctpay.util.ActivityScoped;

import dagger.Component;

/**
 * Created by K53SV on 3/13/2017.
 */

@ActivityScoped
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(MainActivity mainActivity);
}

