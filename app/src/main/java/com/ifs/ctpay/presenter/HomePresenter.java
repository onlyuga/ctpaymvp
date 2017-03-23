package com.ifs.ctpay.presenter;

import android.content.Context;

import com.ifs.ctpay.contract.HomeContract;
import com.ifs.ctpay.presenter.home.BannerPresenter;
import com.ifs.ctpay.presenter.home.HomeBodyPresenter;
import com.ifs.ctpay.presenter.home.LoginPresenter;
import com.ifs.ctpay.presenter.home.PromotionPresenter;
import com.ifs.ctpay.rx.RxBus;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.util.AuthUtils;
import com.ifs.ctpay.util.PrefUtils;
import com.ifs.ctpay.util.Utils;
import com.ifs.ctpay.view.home.BannerFragment;
import com.ifs.ctpay.view.home.HomeBodyFragment;
import com.ifs.ctpay.view.home.LoginFragment;
import com.ifs.ctpay.view.home.PromotionFragment;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

@ActivityScoped
public class HomePresenter implements HomeContract.Presenter {
    private Context context;
    private static final String TAG = HomePresenter.class.getSimpleName();
    private boolean isAuth;
    private final HomeContract.View view;

    private CompositeSubscription subscriptions;

    public void setIsAut(boolean isAuth){
        this.isAuth = isAuth;
        loadBodyFragment();
    }

    @Inject
    HomePresenter(Context context, HomeContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
        isAuth = false;
    }


    @Override
    public void subscribe() {
        loadFragment(1);
        RxBus.subscribe(RxBus.SUBJECT_MY_SUBJECT, "Login", data -> {
            String message = (String) data;
            if (message.equals("Login-success")) {
                isAuth = true;
                HomeBodyFragment mHomeBodyFragment = new HomeBodyFragment();
                new HomeBodyPresenter(context, mHomeBodyFragment);
                view.showBody(mHomeBodyFragment);
            }
        });
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
        RxBus.unregister("Login");
    }

    @Override
    public void loadFragment(int fragmentId) {
        BannerFragment mBannerFragment = new BannerFragment();
        new BannerPresenter(context, mBannerFragment);
        view.showBanner(mBannerFragment);

        PromotionFragment mPromotionFragment = new PromotionFragment();
        new PromotionPresenter(context, mPromotionFragment);
        view.showPromotion(mPromotionFragment);

        loadBodyFragment();
    }

    private void loadBodyFragment(){
        if (!isAuth) {
            LoginFragment mLoginFragment = new LoginFragment();
            new LoginPresenter(context, mLoginFragment);
            view.showBody(mLoginFragment);
        } else {
            HomeBodyFragment mHomeBodyFragment = new HomeBodyFragment();
            new HomeBodyPresenter(context, mHomeBodyFragment);
            view.showBody(mHomeBodyFragment);
        }
    }
}
