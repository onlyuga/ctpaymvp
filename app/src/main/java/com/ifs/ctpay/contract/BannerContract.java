package com.ifs.ctpay.contract;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

import java.util.List;

/**
 * Created by K53SV on 3/18/2017.
 */

public class BannerContract {

    public  interface View extends BaseView<Presenter> {
        void showBanner(List<Integer> source);
        void animationBanner(int i);
        int getCurrentBanner();
    }

    public interface Presenter extends BasePresenter {
        void loadAnimation();
    }
}
