package com.ifs.ctpay.activities.home.module;


import com.ifs.ctpay.contract.HomeContract;
import com.ifs.ctpay.contract.StrangerContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K53SV on 3/13/2017.
 */

@Module
public class HomeModule {
    private HomeContract.View view;
    private StrangerContract.View v;

    public HomeModule(HomeContract.View view, StrangerContract.View v) {
        this.v = v;
        this.view = view;
    }

    @Provides
    HomeContract.View provideHomePageContractView() {
        return view;
    }

    @Provides
    StrangerContract.View provideStrangerContractView() {
        return v;
    }
}
