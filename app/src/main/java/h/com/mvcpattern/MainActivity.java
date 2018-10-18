package h.com.mvcpattern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import h.com.mvcpattern.activity.LoginControllerListener;
import h.com.mvcpattern.controller.LoginController;
import h.com.mvcpattern.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginControllerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity links the view and the controller
        LoginController loginController = new LoginController((LoginView) this.findViewById(R.id.login), this);
        //the login controller will intercept the events of loginView
        ((LoginView) this.findViewById(R.id.login)).setListener(loginController);
    }

    //controller calls this method if the login was succesfull
    @Override
    public void onLoginSucces() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        this.startActivity(intent);
    }
}
