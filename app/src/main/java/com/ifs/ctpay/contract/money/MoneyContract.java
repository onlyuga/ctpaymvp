package com.ifs.ctpay.contract.money;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;
import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.view.model.ShortcutModel;

import java.util.List;

/**
 * Created by K53SV on 3/22/2017.
 */

public class MoneyContract {
    public interface View extends BaseView<Presenter> {
        void showBalance(List<Account> accounts);
        void showDeposit(List<ShortcutModel> models);
        void showTransfer(List<ShortcutModel> models);
        void showAccountManager(List<ShortcutModel> models);
    }

    public interface Presenter extends BasePresenter {
        void getBalance(long id);
        void getMenuDeposit();
        void getMenuTransfer();
        void getMenuAcountManager();
    }
}
