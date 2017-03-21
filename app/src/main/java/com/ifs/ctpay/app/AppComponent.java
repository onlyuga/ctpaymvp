package com.ifs.ctpay.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by K53SV on 3/13/2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    CTPayApp getApplication();

    Context getContext();

    GitHubService getSuriService();
}
