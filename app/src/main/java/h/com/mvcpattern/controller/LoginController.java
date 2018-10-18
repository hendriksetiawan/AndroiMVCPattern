package h.com.mvcpattern.controller;

import android.util.Log;
import android.view.View;

import h.com.mvcpattern.activity.LoginControllerListener;
import h.com.mvcpattern.constant.ErrorConstants;
import h.com.mvcpattern.view.LoginView;

public class LoginController implements View.OnClickListener {

    private final String TAG = "Login controller";

    private LoginView loginView;
    private LoginControllerListener listener;

    public LoginController(LoginView loginView, LoginControllerListener listener){
        this.loginView = loginView;
        this.listener = listener;
    }

    /**
     * Login button was clicked
     */

    @Override
    public void onClick(View v) {
        Log.i(TAG, "onCLick");
        //check for valid email
        if (loginView.getLogin().isEmpty() || loginView.getLogin().equals(""))
            loginView.setLoginError(ErrorConstants.ERROR_FIELD_REQUIRED);
        else
            if (!loginView.getLogin().contains("@"))
                loginView.setLoginError(ErrorConstants.ERROR_INVALID_EMAIL);

        //check for a valid password
        if (loginView.getPassword().isEmpty() || loginView.getPassword().equals(""))
            loginView.setPasswordError(ErrorConstants.ERROR_FIELD_REQUIRED);
        else
            if (loginView.getPassword().length()<3)
                loginView.setPasswordError(ErrorConstants.ERROR_INVALID_PASSWORD);
        else
            //if all inputs are rights than go next
        //Here you'll probably call a web service that will verify
        //the login
        //we just inform the LoginActivity that login is successfull
        listener.onLoginSucces();


    }
}
