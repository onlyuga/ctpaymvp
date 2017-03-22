package com.ifs.ctpay.app;

import android.app.Application;

import com.ifs.imobile.network.app.MobileApplication;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;

/**
 * Created by K53SV on 3/13/2017.
 */

public class CTPayApp extends MobileApplication {
    private AppComponent applicationComponent;

    private static CTPayApp mInstance;

    public static CTPayApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        Iconify.with(new SimpleLineIconsModule())
                .with(new FontAwesomeModule())
                .with(new MaterialModule());

        mInstance = this;
    }

    public AppComponent getApplicationComponent() {

        return applicationComponent;
    }
}
