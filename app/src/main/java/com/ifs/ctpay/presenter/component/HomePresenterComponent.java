package com.ifs.ctpay.presenter.component;

import com.ifs.ctpay.activities.home.component.HomeComponent;
import com.ifs.ctpay.activities.home.module.FragmentHomeModule;
import com.ifs.ctpay.activities.home.module.HomeModule;
import com.ifs.ctpay.app.AppComponent;
import com.ifs.ctpay.presenter.HomePresenter;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.view.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by K53SV on 3/13/2017.
 */

@ActivityScoped
@Component(modules = {FragmentHomeModule.class})
public interface HomePresenterComponent {

    //void inject(HomePresenter homePresenter);
    //void inject(StrangerPresenter strangerPresenter);
}
