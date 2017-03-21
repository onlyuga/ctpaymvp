package com.ifs.ctpay.view.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.BannerContract;
import com.ifs.ctpay.contract.home.HomeBodyContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/21/2017.
 */

public class HomeBodyFragment extends BaseFragment implements HomeBodyContract.View {

    private HomeBodyContract.Presenter presenter;
    private Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_body, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void setPresenter(HomeBodyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        assert presenter != null;
        presenter.subscribe();
    }


    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showUserInfo() {

    }
}
