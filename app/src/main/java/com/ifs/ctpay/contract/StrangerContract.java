package com.ifs.ctpay.contract;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

/**
 * Created by K53SV on 3/13/2017.
 */

public interface StrangerContract {

    interface View extends BaseView<Presenter> {

        void displayInformation(String name);
    }

    interface Presenter extends BasePresenter {

        void loadName(String name);
    }
}
