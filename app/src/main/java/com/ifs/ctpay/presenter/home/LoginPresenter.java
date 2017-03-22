package com.ifs.ctpay.presenter.home;

import android.content.Context;
import android.util.Patterns;

import com.ifs.ctpay.app.AppModule;
import com.ifs.ctpay.app.GitHubService;
import com.ifs.ctpay.contract.LoginContract;
import com.ifs.ctpay.controller.AuthenticationController;
import com.ifs.ctpay.presenter.component.DaggerPresenterComponent;
import com.ifs.ctpay.util.ActivityScoped;
import com.ifs.ctpay.util.AuthUtils;
import com.ifs.ctpay.util.Utils;

import java.util.regex.Pattern;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by K53SV on 3/18/2017.
 */
@ActivityScoped
public class LoginPresenter implements LoginContract.Presenter  {
    private static final String TAG = LoginPresenter.class.getSimpleName();
    private CompositeSubscription subscriptions;

    private Context context;
    private final LoginContract.View view;

    @Inject
    GitHubService gitHubService;

    @Inject
    AuthenticationController autService;

    @Inject
    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
        view.setPresenter(this);
        DaggerPresenterComponent.builder()
                .appModule(new AppModule(context))
                .build().inject(this);
    }

    @Override
    public void subscribe() {
        view.showForm(true);
    }

    @Override
    public void unSubscribe() {
        subscriptions.clear();
    }

    @Override
    public void login(String username, String password) {
        if(!validateUsername(username)){
            view.showErrorUserName(true);
            return;
        }else {
            view.showErrorUserName(false);
        }

        if(!validatePassword(password)){
            view.showErrorPassword(true);
            return;
        }else {
            view.showErrorPassword(false);
        }

        view.showForm(false);
        signIn(username,password);
    }

    private void signIn(String username, String password){
        Subscription subscription = autService.authenticate(username, password)
                .doOnNext(m -> view.showForm(true))
                .doOnNext(m -> {
                    if(m.Error!=0){
                        view.loginSuccess(false);
                    }
                })
                .filter(m -> m.Error==0)
                .map(m -> m.Data)
                .subscribe(m -> {
                    AuthUtils.setClient(m.ClientId);
                    view.loginSuccess(true);
                }, Throwable::printStackTrace);

        subscriptions.add(subscription);
    }

    @Override
    public boolean validateUsername(String userName){
        Pattern patternEmail = Patterns.EMAIL_ADDRESS;
        Pattern patternPhone = Patterns.PHONE;
        if (!patternEmail.matcher(userName).matches()) {
            return patternPhone.matcher(userName).matches();
        }
        return patternEmail.matcher(userName).matches();
    }

    @Override
    public boolean validatePassword(String password){
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&+=])[^\\s]{8,20}$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        return  pattern.matcher(password).matches();
    }


}
