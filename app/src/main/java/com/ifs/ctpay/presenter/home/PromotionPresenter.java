package com.ifs.ctpay.presenter.home;

import android.content.Context;

import com.ifs.ctpay.contract.PromotionContract;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.util.Utils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by K53SV on 3/18/2017.
 */

@ActivityScoped
public class PromotionPresenter implements PromotionContract.Presenter {
    private static final String TAG = PromotionPresenter.class.getSimpleName();
    private CompositeSubscription subscriptions;

    private Context context;
    private final PromotionContract.View view;

    @Inject
    public PromotionPresenter(Context context, PromotionContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        view.showPromotion(null);
        loadPromotion();
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void loadPromotion() {
        Subscription sub = Observable.interval(3, TimeUnit.SECONDS)
                .compose(Utils.applySchedulers())
                .subscribe(l -> {
                    view.showAnimation(l.intValue() % view.getCountPromotion());
                });
        subscriptions.add(sub);
    }
}
