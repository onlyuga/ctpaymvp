package com.ifs.ctpay.view.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.gc.materialdesign.views.ProgressBarIndeterminateDeterminate;
import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.home.HomeBodyContract;
import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.model.entity.UserInfo;
import com.ifs.ctpay.util.Utils;
import com.ifs.ctpay.view.adapter.ShortcutAdapter;
import com.ifs.ctpay.view.model.ShortcutModel;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;
import java.util.List;

import at.markushi.ui.CircleButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/21/2017.
 */

public class HomeBodyFragment extends BaseFragment implements HomeBodyContract.View {

    private HomeBodyContract.Presenter presenter;
    private Unbinder unbinder;
    private boolean arrow = false;

    @BindView(R.id.progress_bar)
    ProgressBarIndeterminateDeterminate progressBar;
    @BindView(R.id.tv_full_name)
    TextView tvFullName;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.itv_arrow)
    IconTextView itvArrow;
    @BindView(R.id.rv_info)
    RecyclerView mRecyclerView;

    List<Account> accounts;

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
    public void showUserInfo(UserInfo user) {
        tvFullName.setText(user.FullName);
    }

    @Override
    public void showBalance(List<Account> accounts) {
        this.accounts = accounts;

        setTotalBanlance(accounts);
        setShortcut();
    }

    @Override
    public void loadDataComplete(boolean success) {
        progressBar.setVisibility(View.GONE);

        if (!success) {
            Toast.makeText(getActivity(), "Get info error", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.itv_arrow)
    public void btnArrow(View v) {
        arrow =!arrow;
        if (arrow) {
            itvArrow.setText("{md-keyboard-arrow-down}");
            setBalanceAccount();
        } else {
            itvArrow.setText("{md-keyboard-arrow-up}");
            setShortcut();
        }
    }

    private void setTotalBanlance(List<Account> accounts) {
        tvBalance.setText("Banlance "
                + Utils.getCurrency(Stream.of(accounts)
                .map(n -> n.Balance)
                .reduce(0.0, (x, y) -> x + y)));
    }

    private void setShortcut(){
        GridLayoutManager ln = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(ln);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        List<ShortcutModel> models = Stream.range(0,4).map(i -> new ShortcutModel(i,"Hello " +1, new Fragment())).collect(Collectors.toList());
        ShortcutAdapter adapter = new ShortcutAdapter(getActivity(),models);
        mRecyclerView.setAdapter(adapter);
    }

    private void setBalanceAccount(){
        LinearLayoutManager ln = new LinearLayoutManager(getActivity());
        ln.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(ln);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        BalanceAdapter adapter = new BalanceAdapter(getActivity(), accounts);
        mRecyclerView.setAdapter(adapter);
    }


    public class BalanceHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvBalance;

        public BalanceHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_account_name);
            tvBalance = (TextView) itemView.findViewById(R.id.tv_account_balance);
        }
    }

    public class BalanceAdapter extends RecyclerView.Adapter<BalanceHolder>{
        Context context;
        List<Account> accounts;

        public BalanceAdapter(Context context, List<Account> accounts){
            this.context =context;
            this.accounts = accounts;
        }

        @Override
        public BalanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_item_account_balance, parent, false);

            return new BalanceHolder(itemView);
        }

        @Override
        public void onBindViewHolder(BalanceHolder holder, int position) {
            Account account = accounts.get(position);

            holder.tvName.setText(account.Account_Type);
            holder.tvBalance.setText(Utils.getCurrency(account.Balance));
        }

        @Override
        public int getItemCount() {
            return accounts.size();
        }
    }
}
