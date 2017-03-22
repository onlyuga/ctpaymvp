package com.ifs.ctpay.util;

import java.text.NumberFormat;
import java.util.Locale;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Utils {
	public static <T> Observable.Transformer<T, T> applySchedulers() {
		return observable -> observable.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

	public static String getCurrency(Double amount) {
		Locale locale = new Locale("vi", "VN");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(amount).replace(".", ",");
	}
}
