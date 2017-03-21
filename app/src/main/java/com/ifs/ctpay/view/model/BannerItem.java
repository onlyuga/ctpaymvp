package com.ifs.ctpay.view.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ifs.ctpay.R;
import com.squareup.picasso.Picasso;

/**
 * Created by K53SV on 3/20/2017.
 */

public class BannerItem extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_item_banner, container, false);
        ImageView image = (ImageView)view.findViewById(R.id.iv_banner);
        Picasso.with(getActivity())
                .load("https://vimo.vn/images/home/slider02.jpg")
                .into(image);

        return view;
    }
}
