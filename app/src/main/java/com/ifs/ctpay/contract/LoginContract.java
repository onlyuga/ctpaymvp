package com.ifs.ctpay.contract;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

import java.util.List;

/**
 * Created by K53SV on 3/18/2017.
 */

public class LoginContract {
   public interface View extends BaseView<Presenter> {
        void showForm(boolean isShow);
       void showErrorUserName(boolean error);
       void showErrorPassword(boolean error);
       void loginSuccess(boolean success);
    }

    public interface Presenter extends BasePresenter {
        void login(String username, String password);
        boolean validateUsername(String userName);
        boolean validatePassword(String password);
    }
}
