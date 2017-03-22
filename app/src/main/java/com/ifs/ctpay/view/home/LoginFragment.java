package com.ifs.ctpay.view.home;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.gc.materialdesign.views.ProgressBarIndeterminateDeterminate;
import com.ifs.core.fragment.BaseFragment;
import com.ifs.ctpay.R;
import com.ifs.ctpay.contract.LoginContract;
import com.ifs.ctpay.rx.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by K53SV on 3/18/2017.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View  {

    private LoginContract.Presenter presenter;
    private Unbinder unbinder;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.ed_login_user)
    EditText edUser;
    @BindView(R.id.ed_login_password)
    EditText edPassword;
    @BindView(R.id.progress_bar)
    ProgressBarIndeterminateDeterminate progressBar;
    @BindView(R.id.til_user_name)
    TextInputLayout tilUserName;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        assert presenter != null;
        presenter.subscribe();
    }


    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_login)
    public void setBtnLogin(View v){
        presenter.login(edUser.getText().toString(), edPassword.getText().toString());
    }

    public void loginSuccess(boolean success){
        //showForm(true);
        if(success) {
            Toast.makeText(getActivity(), "Login - success", Toast.LENGTH_SHORT).show();
            RxBus.publish(RxBus.SUBJECT_MY_SUBJECT, "Login-success");
        }else {
            Toast.makeText(getActivity(), "Login - failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showErrorUserName(boolean error){
        if(error){
            tilUserName.setErrorEnabled(true);
            tilUserName.setError("Email or password do not pattern");
        }else {
            tilUserName.setErrorEnabled(false);
        }
    }

    @Override
    public void showErrorPassword(boolean error){
        if(error){
            tilPassword.setErrorEnabled(true);
            tilPassword.setError("Password is 8 char!");
        }else {
            tilPassword.setErrorEnabled(false);
        }
    }

    @Override
    public void showForm(boolean isShow){
        if(isShow) {
            progressBar.setVisibility(View.INVISIBLE);
            edPassword.setEnabled(isShow);
            edUser.setEnabled(isShow);
            btnLogin.setEnabled(isShow);
        }else {
            progressBar.setVisibility(View.VISIBLE);
            edPassword.setEnabled(isShow);
            edUser.setEnabled(isShow);
            btnLogin.setEnabled(isShow);
        }
    }
}
