package com.ifs.ctpay.contract;

import android.support.v4.app.Fragment;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

/**
 * Created by K53SV on 3/13/2017.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {

        void showBanner(Fragment banner);
        void showPromotion(Fragment promotion);
        void showBody(Fragment body);
    }

    interface Presenter extends BasePresenter {

        void loadFragment(int fragmentId);
    }
}
