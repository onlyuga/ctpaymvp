package com.ifs.ctpay.presenter.home;

import android.content.Context;

import com.ifs.ctpay.app.AppModule;
import com.ifs.ctpay.contract.home.HomeBodyContract;
import com.ifs.ctpay.controller.UserAccountController;
import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.model.entity.ResponseArrayModel;
import com.ifs.ctpay.model.entity.ResponseModel;
import com.ifs.ctpay.model.entity.UserInfo;
import com.ifs.ctpay.presenter.component.DaggerPresenterComponent;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.util.AuthUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
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
    UserAccountController accountService;

    @Inject
    public HomeBodyPresenter(Context context, HomeBodyContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
        DaggerPresenterComponent.builder()
                .appModule(new AppModule(context))
                .build().inject(this);
    }

    @Override
    public void subscribe() {
        long clientId = AuthUtils.getClientId();
        getUser(clientId);
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void getUser(long id) {
        Observable<ResponseModel<UserInfo>> user = accountService.getUserById(id);
        Observable<ResponseArrayModel<Account>> account = accountService.listActiveClientAccount();
        Subscription sub = Observable.zip(user, account,(mUser, mAccount) ->{
            boolean success = true;
            if(mUser.Error!=0){
                success = false;
            }else {
                view.showUserInfo(mUser.Data);
            }

            if(mAccount.Error!=0){
                success = false;
            }else {
                view.showBalance(mAccount.Data);
            }

            return success;
        }).subscribe(view::loadDataComplete, e -> view.loadDataComplete(false));
        subscriptions.add(sub);
    }
}
