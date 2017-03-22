package com.ifs.ctpay.model.entity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by K53SV on 8/17/2016.
 */
public class ResponseModel<T> {
    public int Error;
    public T Data;
    public String IsSuccess;
    public String ErrorMessage;

    public String getFieldNameError() {
        return this.getClass().getDeclaredFields()[0].getName();
    }

    public String getFieldNameData() {
        return this.getClass().getDeclaredFields()[1].getName();
    }

    public ResponseModel() {

    }

    public ResponseModel(String json, Class<T> clazz) {
        if (json != null && json.length() > 0)
            try {
                JSONObject object = new JSONObject(json);
                if (object.isNull("Error")) {
                    Error = -1;
                } else {
                    Error = object.getInt("Error");
                    if (object.isNull("Data"))
                        Data = null;
                    else {
                        try {
                            Data = new Gson().fromJson(object.getString("Data").trim(), clazz);
                        } catch (com.google.gson.JsonSyntaxException ex) {
                            Data = (T) object.getString("Data");
                        }

                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
                Error = -1;
                Data = null;
            }
        else
            Error = -1;
    }
}
