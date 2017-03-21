package com.ifs.ctpay.contract.home;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

/**
 * Created by K53SV on 3/21/2017.
 */

public class HomeBodyContract {
    public interface View extends BaseView<Presenter> {
        void showUserInfo();
    }

    public interface Presenter extends BasePresenter {
        void getUser();
    }
}
