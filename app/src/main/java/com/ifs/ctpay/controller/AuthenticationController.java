package com.ifs.ctpay.controller;

import com.ifs.ctpay.model.entity.Login;
import com.ifs.ctpay.model.entity.ResponseModel;
import com.ifs.ctpay.network.FetchData;
import com.ifs.ctpay.network.PGWService;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by K53SV on 3/21/2017.
 */

public class AuthenticationController {

    @Inject
    public AuthenticationController(){

    }

    public Observable<ResponseModel<Login>> authenticate(String username, String password) {
        JSONObject params = new JSONObject();
        try {
            params.put(PGWService.PARAM_USER_NAME, username);
            params.put(PGWService.PARAM_PASSWORD, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new FetchData<Login>(PGWService.CONTROLLER_AUTHEN, PGWService.ACTION_AUTHENTICATE, params)
                .getObservable(Login.class);

    }

}
