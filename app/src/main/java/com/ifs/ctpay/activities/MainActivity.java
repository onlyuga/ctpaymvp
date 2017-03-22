package com.ifs.ctpay.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ifs.ctpay.R;
import com.ifs.ctpay.activities.home.component.DaggerHomeComponent;
import com.ifs.ctpay.activities.home.module.HomeModule;
import com.ifs.ctpay.app.CTPayApp;
import com.ifs.ctpay.presenter.HomePresenter;
import com.ifs.ctpay.presenter.StrangerPresenter;
import com.ifs.ctpay.presenter.money.MoneyPresenter;
import com.ifs.ctpay.rx.RxBus;
import com.ifs.ctpay.util.FragmentData;
import com.ifs.ctpay.view.HomeFragment;
import com.ifs.ctpay.view.StrangerFragment;
import com.ifs.core.activity.BaseActivity;
import com.ifs.core.util.ActivityUtils;
import com.ifs.ctpay.view.money.MoneyFragment;
import com.ifs.wiget.bottombar.BottomBar;
import com.ifs.wiget.bottombar.BottomBarTab;
import com.ifs.wiget.bottombar.OnTabClickListener;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    @Inject
    HomePresenter homePresenter;
    @Inject
    MoneyPresenter strangerPresenter;

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HomeFragment homePageFragment = HomeFragment.newInstance();
        MoneyFragment moneyFragment = MoneyFragment.newInstance();
        fragmentList.add(homePageFragment);
        fragmentList.add(moneyFragment);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homePageFragment, R.id.fragment_container);

        DaggerHomeComponent.builder()
                .appComponent(CTPayApp.getInstance().getApplicationComponent())
                .homeModule(new HomeModule(homePageFragment, moneyFragment))
                .build().inject(this);

        RxBus.subscribe(RxBus.SUBJECT_MY_SUBJECT, "F1", message -> {
            if (message instanceof FragmentData) {
                FragmentData fragmentData = (FragmentData) message;
                ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), fragmentData.getFragment(), fragmentData.getView());
                Log.v("Testing", message.toString());
            }
        });

        setUpBottomBar();

        CTPayApp.getInstance().initialize();
    }

    private void setUpBottomBar() {
        mBottomBar.setItems(new BottomBarTab(R.drawable.ic_action_home, "HOME"),
                new BottomBarTab(R.drawable.ic_action_money, "MONEY"),
                new BottomBarTab(R.drawable.ic_action_cart, "Tài khoản"),
                new BottomBarTab(R.drawable.ic_action_user, "USER"),
                new BottomBarTab(R.drawable.ic_action_more, "MORE"));
        mBottomBar.selectTabAtPosition(0);
        mBottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                if (position < 2)
                    ActivityUtils.replaceFragmentToActivity(getSupportFragmentManager(), fragmentList.get(position), R.id.fragment_container);
            }

            @Override
            public void onTabReSelected(int position) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.unregister("F1");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
