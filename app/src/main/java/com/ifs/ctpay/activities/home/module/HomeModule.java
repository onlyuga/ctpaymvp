package com.ifs.ctpay.activities.home.module;


import com.ifs.ctpay.contract.HomeContract;
import com.ifs.ctpay.contract.StrangerContract;
import com.ifs.ctpay.contract.money.MoneyContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K53SV on 3/13/2017.
 */

@Module
public class HomeModule {
    private HomeContract.View homeView;
    private MoneyContract.View moneyView;

    public HomeModule(HomeContract.View homeView, MoneyContract.View moneyView) {
        this.homeView = homeView;
        this.moneyView = moneyView;
    }

    @Provides
    HomeContract.View provideHomePageContractView() {
        return homeView;
    }

    @Provides
    MoneyContract.View provideMoneyView() {
        return moneyView;
    }
}
