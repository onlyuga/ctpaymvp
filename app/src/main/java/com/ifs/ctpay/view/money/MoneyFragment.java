package com.ifs.ctpay.view.money;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.money.MoneyContract;
import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.view.adapter.ShortcutAdapter;
import com.ifs.ctpay.view.model.ShortcutModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/22/2017.
 */

public class MoneyFragment extends BaseFragment implements MoneyContract.View {

    private MoneyContract.Presenter presenter;
    private Unbinder unbinder;

    @BindView(R.id.block_deposit_money)
    RecyclerView rvDeposit;
    @BindView(R.id.block_money_transfer)
    RecyclerView rvTransfer;
    @BindView(R.id.block_management)
    RecyclerView rvManager;

    public static MoneyFragment newInstance() {

        return new MoneyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_money, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
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
    public void setPresenter(MoneyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showBalance(List<Account> accounts) {

    }

    @Override
    public void showDeposit(List<ShortcutModel> models) {
        GridLayoutManager ln = new GridLayoutManager(getActivity(), 4);
        rvDeposit.setLayoutManager(ln);
        rvDeposit.setHasFixedSize(false);
        rvDeposit.setItemAnimator(new DefaultItemAnimator());

        ShortcutAdapter adapter = new ShortcutAdapter(getActivity(),models);
        rvDeposit.setAdapter(adapter);
    }

    @Override
    public void showTransfer(List<ShortcutModel> models) {
        GridLayoutManager ln = new GridLayoutManager(getActivity(), 4);
        rvTransfer.setLayoutManager(ln);
        rvTransfer.setHasFixedSize(false);
        rvTransfer.setItemAnimator(new DefaultItemAnimator());

        ShortcutAdapter adapter = new ShortcutAdapter(getActivity(),models);
        rvTransfer.setAdapter(adapter);
    }

    @Override
    public void showAccountManager(List<ShortcutModel> models) {
        GridLayoutManager ln = new GridLayoutManager(getActivity(), 4);
        rvManager.setLayoutManager(ln);
        rvManager.setHasFixedSize(false);
        rvManager.setItemAnimator(new DefaultItemAnimator());

        ShortcutAdapter adapter = new ShortcutAdapter(getActivity(),models);
        rvManager.setAdapter(adapter);
    }
}
