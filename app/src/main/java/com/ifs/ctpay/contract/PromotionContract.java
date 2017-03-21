package com.ifs.ctpay.contract;

import com.ifs.core.presenter.BasePresenter;
import com.ifs.core.view.BaseView;

import java.util.List;

/**
 * Created by K53SV on 3/18/2017.
 */

public class PromotionContract {
    public interface View extends BaseView<Presenter> {
        void showPromotion(List<Integer> source);

        int getCountPromotion();

        void showAnimation(int i);
    }

    public interface Presenter extends BasePresenter {
        void loadPromotion();
    }
}
