package com.example.entre31proto3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    DatabaseRegister dbregister;

    EditText UserName ;
    EditText Password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        UserName = (EditText) findViewById(R.id.Username_Login);
        Password = (EditText) findViewById(R.id.Password_Login);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        dbregister= new DatabaseRegister(this);
    }

        public void MoveToRegister2(View view)
    {
        Intent intent = new Intent(this, Register2.class);

        startActivity(intent);
    }

    public void Login(View view)
    {
        String user = UserName.getText().toString().trim();
        String pwd = Password.getText().toString().trim();

        Boolean Check = dbregister.CheckUser(user,pwd);

        if(Check)//Success
        {

        }else if(!Check) //Failed
        {

        }
    }


}
