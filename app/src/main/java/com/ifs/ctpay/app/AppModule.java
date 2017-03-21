package com.ifs.ctpay.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K53SV on 3/13/2017.
 */

@Module(includes = ApiModule.class)
public class AppModule {
    Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    CTPayApp provideApplication() {
        return (CTPayApp) context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public GitHubService provideGithubService(GitHubApi authApi) {
        return new GitHubService(authApi);
    }
}
