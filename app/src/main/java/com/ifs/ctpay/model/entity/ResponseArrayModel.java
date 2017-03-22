package com.ifs.ctpay.model.entity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K53SV on 8/17/2016.
 */
public class ResponseArrayModel<T> {
    public int Error;
    public List<T> Data;
    public String IsSuccess;
    public String ErrorMessage;

    public String getFieldNameError() {
        return this.getClass().getDeclaredFields()[0].getName();
    }

    public String getFieldNameData() {
        return this.getClass().getDeclaredFields()[1].getName();
    }

    public ResponseArrayModel() {

    }

    public ResponseArrayModel(String json, Class<T> clazz) {
        Data = new ArrayList<>();
        if (json != null && json.length() > 0)
            try {
                JSONObject object = new JSONObject(json.trim());
                if (object.isNull("Error")) {
                    Error = -1;
                } else {
                    Error = object.getInt("Error");
                    if (object.isNull("Data"))
                        Data = new ArrayList<>();
                    else {
                        JSONArray array = object.getJSONArray("Data");
                        for (int i = 0; i < array.length(); i++) {
                            Data.add(new Gson().fromJson(array.getString(i), clazz));
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Error = -1;
                Data = new ArrayList<>();
            }
        else Error = -1;
    }
}
