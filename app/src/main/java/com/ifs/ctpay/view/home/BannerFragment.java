package com.ifs.ctpay.view.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.BannerContract;
import com.ifs.ctpay.view.model.BannerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/18/2017.
 */

public class BannerFragment  extends BaseFragment implements BannerContract.View  {

    private BannerContract.Presenter presenter;
    private Unbinder unbinder;

    @BindView(R.id.vp_banner)
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_banner, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void setPresenter(BannerContract.Presenter presenter) {
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
    public void showBanner(List<Integer> source) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new BannerItem(), "");
        adapter.addFrag(new BannerItem(), "");
        adapter.addFrag(new BannerItem(), "");
        adapter.addFrag(new BannerItem(), "");
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    @Override
    public void animationBanner(int i) {
        mViewPager.setCurrentItem(i);
    }

    @Override
    public int getCurrentBanner() {
        return mViewPager.getCurrentItem();
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
