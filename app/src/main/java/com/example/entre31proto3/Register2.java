package com.example.entre31proto3;

import android.provider.BaseColumns;
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

    //DatabaseRegister dbregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //dbregister= new DatabaseRegister(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        UserName = findViewById(R.id.Username);

        Password = findViewById((R.id.Password));

        ConPassword =  findViewById((R.id.Confirm_Password));
        Info = findViewById(R.id.Info2);
    }


    public void RegisterClick(View view)
    {
        if(Password.equals(ConPassword)) //true
        {
            Info.setText("It's a Match");
        }
        else // false
        {
            Info.setText("Confirm Password Does Not Match !");
        }
    }


}
