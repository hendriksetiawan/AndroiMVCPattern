package h.com.mvcpattern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

import h.com.mvcpattern.R;

public class LoginView extends LinearLayout {

    public LoginView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public void setListener(OnClickListener onClickListener){
        findViewById(R.id.sign_in_button).setOnClickListener(onClickListener);
    }

    public String getLogin(){
        return ((EditText) this.findViewById(R.id.email_login)).getText().toString();
    }

    public String getPassword(){
        return ((EditText) this.findViewById(R.id.password)).getText().toString();
    }

    public void setPasswordError(String error){
        ((EditText) this.findViewById(R.id.password)).setError(error);
    }
    public void setLoginError(String error){
        ((EditText) this.findViewById(R.id.email_login)).setError(error);
    }
}
