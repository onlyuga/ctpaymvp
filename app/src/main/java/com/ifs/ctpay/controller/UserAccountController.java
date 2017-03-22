package com.ifs.ctpay.controller;

import android.app.Application;

import com.ifs.ctpay.model.entity.Account;
import com.ifs.ctpay.model.entity.ResponseArrayModel;
import com.ifs.ctpay.model.entity.ResponseModel;
import com.ifs.ctpay.model.entity.UserInfo;
import com.ifs.ctpay.network.FetchData;
import com.ifs.ctpay.network.PGWService;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by K53SV on 3/21/2017.
 */

public class UserAccountController {

    @Inject
    public UserAccountController(){

    }

    public Observable<ResponseModel<UserInfo>> getUserById(long clientId) {
        JSONObject params = new JSONObject();
        try {

            params.put(PGWService.PARAM_USER_ID, clientId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new FetchData<UserInfo>(PGWService.CONTROLLER_AUTHEN,
                PGWService.ACTION_GET_USER, params)
                .getObservable(UserInfo.class);
    }

    public Observable<ResponseArrayModel<Account>> listActiveClientAccount() {
        return new FetchData<Account>(PGWService.CONTROLLER_USER_ACCOUNT,
                PGWService.ACTION_LIST_ACTIVE_CLIENT_ACCOUNT, null)
                .getArrayObservable(Account.class);
    }
}
