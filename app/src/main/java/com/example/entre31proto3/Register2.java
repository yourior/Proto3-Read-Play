package com.example.entre31proto3;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Register2 extends AppCompatActivity {


    JSONParser jsonParser = new JSONParser();

    //private ProgressDialog pDialog;
    EditText UserName ;
    EditText Password ;
    EditText ConPassword ;
    TextView Info ;
    DatabaseRegister dbregister;

    private static String URL_Register = "http:/192.168.100.38/Entre/Register.php";



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
                //Info.setText("It's a Match");
                Log.d("Username " ,user);
                Log.d("Pass",conpwd);
                new AddUser().execute();
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
    class AddUser extends AsyncTask<String,String,String>{

        @Override
        protected void  onPreExecute(){
            super.onPreExecute();
//         pDialog = new ProgressDialog(Register2.this);
//            pDialog.setMessage("Adding User...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
        }
        String user = UserName.getText().toString().trim();
        String pwd = Password.getText().toString().trim();

        protected String doInBackground(String... args) {

            // Building Parameters
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("user", user));
            params.add(new BasicNameValuePair("password", pwd));


            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(URL_Register,
                "POST", params);

            // check log cat fro response
            Log.d("Create Response", json.toString());

            // check for success tag
            try {
                int success = json.getInt("Success!");

                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), LogIn.class);
                    startActivity(i);

                    // closing this screen
                    finish();
                } else {
                    // failed to create product
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

//    protected Object doInBackground(Object[] objects) {
//        return null;
//    }
    }

}


