package com.ifs.ctpay.util;


public class AuthUtils {
    private static final String TOKEN = "token";
    private static final String CLIENT = "Client";


    public static String getToken() {
        return PrefUtils.getPrefs().getString(TOKEN, "");
    }

    public static void setToken(String token) {
        PrefUtils.getEditor().putString(TOKEN, token).commit();
    }

    public static void setClient(long clientId) {
        PrefUtils.getEditor().putLong(CLIENT, clientId).commit();
    }

    public static long getClientId() {
        return PrefUtils.getPrefs().getLong(CLIENT, 0);
    }
}
