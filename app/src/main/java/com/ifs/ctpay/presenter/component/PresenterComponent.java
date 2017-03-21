package com.ifs.ctpay.presenter.component;

import com.ifs.ctpay.activities.home.module.FragmentHomeModule;
import com.ifs.ctpay.app.AppModule;
import com.ifs.ctpay.presenter.home.LoginPresenter;
import com.ifs.ctpay.view.home.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by K53SV on 3/13/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface PresenterComponent {
    void inject(LoginPresenter presenter);
}
