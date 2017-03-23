package com.ifs.ctpay.presenter.money;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.ifs.ctpay.contract.money.MoneyContract;
import com.ifs.ctpay.view.model.ShortcutModel;

import java.util.List;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by K53SV on 3/22/2017.
 */

public class MoneyPresenter implements MoneyContract.Presenter {
    private Context context;
    private static final String TAG = MoneyPresenter.class.getSimpleName();

    private final MoneyContract.View view;

    private CompositeSubscription subscriptions;

    @Inject
    MoneyPresenter(Context context, MoneyContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
    }


    @Override
    public void subscribe() {
        getMenuAcountManager();
        getMenuDeposit();
        getMenuTransfer();
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void getBalance(long id) {

    }

    @Override
    public void getMenuDeposit() {
        view.showDeposit(Stream.range(0,4).map(i -> new ShortcutModel(i,"Deposit " +i, new Fragment())).collect(Collectors.toList()));

    }

    @Override
    public void getMenuTransfer() {
        view.showTransfer(Stream.range(0,4).map(i -> new ShortcutModel(i,"Transfer " +i, new Fragment())).collect(Collectors.toList()));

    }

    @Override
    public void getMenuAcountManager() {
        view.showAccountManager(Stream.range(0,4).map(i -> new ShortcutModel(i,"Manager " +i, new Fragment())).collect(Collectors.toList()));

    }
}
