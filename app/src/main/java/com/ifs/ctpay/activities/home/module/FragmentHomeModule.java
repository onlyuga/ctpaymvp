package com.ifs.ctpay.activities.home.module;

import com.ifs.ctpay.contract.BannerContract;
import com.ifs.ctpay.contract.LoginContract;
import com.ifs.ctpay.contract.PromotionContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K53SV on 3/18/2017.
 */

@Module
public class FragmentHomeModule {
    private BannerContract.View vBanner;
    private PromotionContract.View vPromotion;
    private LoginContract.View vLogin;

    public FragmentHomeModule(BannerContract.View vBanner, PromotionContract.View vPromotion, LoginContract.View vLogin) {
        this.vBanner = vBanner;
        this.vPromotion = vPromotion;
        this.vLogin = vLogin;
    }

    @Provides
    BannerContract.View provideBannerView() {
        return vBanner;
    }

    @Provides
    PromotionContract.View provideContractView() {
        return vPromotion;
    }

    @Provides
    LoginContract.View provideLoginView() {
        return vLogin;
    }
}
