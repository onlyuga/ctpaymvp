package com.ifs.ctpay.view.home;


import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.PromotionContract;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/18/2017.
 */

public class PromotionFragment extends BaseFragment implements PromotionContract.View  {

    private PromotionContract.Presenter presenter;
    private Unbinder unbinder;
    @BindView(R.id.news_promotion)
    RecyclerView mRecyclerView;
    NewsPromotionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_promotion, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        LinearLayoutManager ln1 = new LinearLayoutManager(getActivity());
        ln1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(ln1);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }


    @Override
    public void setPresenter(PromotionContract.Presenter presenter) {
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
    public void showPromotion(List<Integer> source) {
        adapter = new NewsPromotionAdapter();
        mRecyclerView.setAdapter(adapter);
    }


    public int getCountPromotion(){
        return adapter.getItemCount();
    }

    @Override
    public void showAnimation(int i) {
        mRecyclerView.smoothScrollToPosition(i);
    }

    public class PromotionHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ImageView ivExtend;

        public PromotionHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivExtend = (ImageView) itemView.findViewById(R.id.iv_extend);
        }
    }

    public class NewsPromotionAdapter extends RecyclerView.Adapter<PromotionHolder>{

        public NewsPromotionAdapter(){

        }

        @Override
        public PromotionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_news_promotion, parent, false);

            return new PromotionHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PromotionHolder holder, int position) {
            String source = "https://cdn3.iconfinder.com/data/icons/ikooni-flat-online-shopping/128/shopping-07-256.png";
            if(position%2==0){
                source = "https://cdn4.iconfinder.com/data/icons/flat-color-sale-tag-set/512/Accounts_label_promotion_sale_tag_29-512.png";
            }
            if(position%3==0){
                source = "https://www.webhostingplanguide.com/wp-content/uploads/2013/06/1_promotion_small.png";
            }

            Picasso.with(getActivity())
                    .load(source)
                    .into(holder.ivExtend);
            holder.tvTitle.setText("Hello android");
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
}
