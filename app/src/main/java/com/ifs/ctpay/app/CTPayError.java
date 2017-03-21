package com.ifs.ctpay.app;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

public class CTPayError extends Throwable {
	public CTPayError(ResponseBody responseBody) {
		super(getMessage(responseBody));
	}

	private static String getMessage(ResponseBody responseBody) {
		try {
			return new JSONObject(responseBody.string()).optString("message");
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		return "Unknown exception";
	}
}
