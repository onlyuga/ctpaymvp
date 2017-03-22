package com.ifs.ctpay.contract.home;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;
import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.model.entity.UserInfo;

import java.util.List;

/**
 * Created by K53SV on 3/21/2017.
 */

public class HomeBodyContract {
    public interface View extends BaseView<Presenter> {
        void showUserInfo(UserInfo user);
        void showBalance(List<Account> account);
        void loadDataComplete(boolean success);
    }

    public interface Presenter extends BasePresenter {
        void getUser(long id);
    }
}
