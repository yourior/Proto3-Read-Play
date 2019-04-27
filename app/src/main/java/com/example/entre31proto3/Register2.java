package com.example.entre31proto3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Register2 extends AppCompatActivity {

    Button button;
    EditText emailreg, passwordreg ,conpassreg,userreg;
    TextView info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register2);

        info = findViewById(R.id.Info2);
        userreg = findViewById(R.id.Username_Register);
        button = findViewById(R.id.Register_Button);
        emailreg = findViewById(R.id.Username_Login);
        passwordreg = findViewById(R.id.Password_Login);
        conpassreg = findViewById(R.id.Confirm_Password);


    }
    public void register(View v)
    {
        String email = emailreg.getText().toString();
        String password = passwordreg.getText().toString();
        String conpass = conpassreg.getText().toString();
        String username = userreg.getText().toString();

        if(password.equals(conpass))
        {
            String Type = "register";

            LoginBackground lg = new LoginBackground(this);
            lg.execute(Type, email, password, username);
        }else
        {
            info.setText("Password and Confirm Password must match");
        }
    }


}


