package com.example.entre31proto3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Register2 extends AppCompatActivity {

    EditText UserName ;
    EditText Password ;
    EditText ConPassword ;
    TextView Info ;
    DatabaseRegister dbregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbregister = new DatabaseRegister(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        UserName = findViewById(R.id.Username_Login);

        Password = findViewById((R.id.Password_Login));

        ConPassword =  findViewById((R.id.Confirm_Password));
        Info = findViewById(R.id.Info2);
    }


    public void RegisterClick(View view)
    {
        String user = UserName.getText().toString().trim();
        String pwd = Password.getText().toString().trim();
        String conpwd = ConPassword.getText().toString().trim();
        if(pwd.equals(conpwd)) //true
        {
            long val =dbregister.addUser(user,pwd);
            if(val>0)
            {
                Info.setText("It's a Match");

                Intent intent = new Intent(this, LogIn.class);
                startActivity(intent);
            }else
            {
                Info.setText("Registration Error");
            }
        }
        else // false
        {
            Info.setText("Confirm Password Does Not Match !");
        }
    }


}
