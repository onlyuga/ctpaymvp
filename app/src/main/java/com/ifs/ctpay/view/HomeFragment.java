package com.ifs.ctpay.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifs.core.util.ActivityUtils;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.HomeContract;
import com.ifs.core.fragment.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/14/2017.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomeContract.Presenter presenter;
    private Unbinder unbinder;

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }


    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
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
    public void showBanner(Fragment banner) {
        ActivityUtils.addFragmentToActivity(getChildFragmentManager(), banner, R.id.fragment_banner);
    }

    @Override
    public void showPromotion(Fragment promotion) {
        ActivityUtils.addFragmentToActivity(getChildFragmentManager(), promotion, R.id.fragment_promotion);
    }

    @Override
    public void showBody(Fragment login) {
        ActivityUtils.replaceFragmentToActivity(getChildFragmentManager(), login, R.id.fragment_body);
    }
}
