package com.ifs.ctpay.network;

import android.util.Log;

import com.ifs.ctpay.model.entity.ResponseArrayModel;
import com.ifs.ctpay.model.entity.ResponseModel;
import com.ifs.ctpay.model.entity.ResponsePageModel;
import com.ifs.imobile.network.SendingMessage;
import com.ifs.imobile.network.app.MobileApplication;
import com.ifs.imobile.network.security.FxUtils;

import org.json.JSONObject;

import rx.Observable;


/**
 * Created by K53SV on 8/20/2016.
 */
public class FetchData<T> {
    private String controller;
    private String action;
    private JSONObject parameters;

    public FetchData(String controller, String action, JSONObject parameters) {
        this.controller = controller;
        this.action = action;
        this.parameters = parameters;
    }

    private SendingMessage getSendingMessage() {
        return FxUtils.getInstance()
                .createRequestDataMessage(controller, action, parameters);
    }

    public Observable<ResponseModel<T>> getObservable(Class<T> clazz) {
        return Observable.create(
                subscriber -> {
                    MobileApplication.getInstance().getConnection()
                            .send(getSendingMessage(), json ->
                            {
                                ResponseModel<T> responseModel = new ResponseModel<>(json, clazz);
                                subscriber.onNext(responseModel); // Emit the contents
                                subscriber.onCompleted();
                            });
                });
    }

    public Observable<ResponsePageModel<T>> getPageObservable(Class<T> clazz) {
        return Observable.create(
                subscriber -> {
                    MobileApplication.getInstance().getConnection()
                            .send(getSendingMessage(), json ->
                            {
                                ResponsePageModel<T> responseModel = new ResponsePageModel<>(json, clazz);

                                subscriber.onNext(responseModel); // Emit the contents

                                subscriber.onCompleted();
                            });
                });
    }

    public Observable<ResponseArrayModel<T>> getArrayObservable(Class<T> clazz) {
        return Observable.create(
                subscriber -> {
                    MobileApplication.getInstance().getConnection()
                            .send(getSendingMessage(), json ->
                            {
                                Log.e("FetchData", json);
                                ResponseArrayModel<T> responseModel = new ResponseArrayModel<>(json, clazz);
                                subscriber.onNext(responseModel); // Emit the contents
                                subscriber.onCompleted();
                            });
                });
    }

}
