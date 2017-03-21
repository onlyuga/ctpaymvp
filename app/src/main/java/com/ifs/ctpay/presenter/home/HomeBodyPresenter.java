package com.ifs.ctpay.presenter.home;

import android.content.Context;

import com.ifs.ctpay.contract.home.HomeBodyContract;
import com.ifs.ctpay.util.ActivityScoped;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by K53SV on 3/21/2017.
 */

@ActivityScoped
public class HomeBodyPresenter implements HomeBodyContract.Presenter {
    private CompositeSubscription subscriptions;

    private Context context;
    private final HomeBodyContract.View view;

    @Inject
    public HomeBodyPresenter(Context context, HomeBodyContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
    }

    @Override
    public void subscribe() {
        getUser();
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void getUser() {

    }
}
