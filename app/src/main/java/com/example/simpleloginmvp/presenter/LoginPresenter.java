package com.example.simpleloginmvp.presenter;

import com.example.simpleloginmvp.model.User;
import com.example.simpleloginmvp.view.ILoginView;

public class LoginPresenter implements ILoginPresenter{

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int logincode = user.isValidData();

        if (logincode == 0){
            loginView.onLoginError("Anda harus memasukkan email anda");
        }
        else if (logincode == 1){
            loginView.onLoginError("Email anda tidak valid");
        }
        else if (logincode == 2){
            loginView.onLoginError("Password harus lebih dari 6 karakter");
        }
        else {
            loginView.onLoginSccess("Login sukses");
        }
    }
}
