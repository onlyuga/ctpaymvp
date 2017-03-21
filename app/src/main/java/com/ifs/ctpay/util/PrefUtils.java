package com.ifs.ctpay.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.ifs.ctpay.app.CTPayApp;

public class PrefUtils {
	private static final String PREF_NAME = "sur";

	public static SharedPreferences getPrefs() {
		return CTPayApp.getInstance().getApplicationComponent().getContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
	}

	public static SharedPreferences.Editor getEditor() {
		return getPrefs().edit();
	}
}
