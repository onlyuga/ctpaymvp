package com.ifs.ctpay.presenter.home;

import android.content.Context;

import com.ifs.ctpay.contract.BannerContract;
import com.ifs.ctpay.contract.HomeContract;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.util.Utils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by K53SV on 3/18/2017.
 */
@ActivityScoped
public class BannerPresenter implements BannerContract.Presenter  {
    private static final String TAG = BannerPresenter.class.getSimpleName();
    private CompositeSubscription subscriptions;

    private Context context;
    private final BannerContract.View view;

    @Inject
    public BannerPresenter(Context context, BannerContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
    }
    @Override
    public void subscribe() {
        view.showBanner(null);
        loadAnimation();

    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void loadAnimation() {
        Subscription sub = Observable.interval(3, TimeUnit.SECONDS)
                .compose(Utils.applySchedulers())
                .subscribe(v -> {
                    int i = view.getCurrentBanner();
                    if (i < 3)
                        view.animationBanner(i + 1);
                    else
                        view.animationBanner(0);
                });
        subscriptions.add(sub);
    }
}
