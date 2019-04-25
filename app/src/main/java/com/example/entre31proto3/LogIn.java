package com.example.entre31proto3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LogIn extends AppCompatActivity {



    EditText UserName_Log ;
    EditText Password_Log ;
    private Button login;
    TextView UsernameView;
    TextView Money;
    //private static final String URL = "http:/192.168.196.1/Entre/user_config.php";

    private RequestQueue requestQueue;

    private StringRequest request;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        UserName_Log =  findViewById(R.id.Username_Login);
        Password_Log =  findViewById(R.id.Password_Login);
        login =  findViewById(R.id.Login_Button);
        UsernameView =  findViewById(R.id.Username_View);
        Money = findViewById(R.id.InAppsCredit_View);

        requestQueue = Volley.newRequestQueue(this);

    }

    public void login (View v)
    {
        String email = UserName_Log.getText().toString();
        String pass = Password_Log.getText().toString();
        String Type = "login";

        LoginBackground lg = new LoginBackground(this);
        lg.execute(Type, email, pass);


    }

    public void movetoMAin()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

        public void MoveToRegister2(View view)
    {
        Intent intent = new Intent(this, Register2.class);

        startActivity(intent);
    }









}
