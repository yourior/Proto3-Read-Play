package com.example.entre31proto3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

        public void MoveToRegister2(View view)
    {
        Intent intent = new Intent(this, Register2.class);

        startActivity(intent);
    }
}
