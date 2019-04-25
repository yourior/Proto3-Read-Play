package com.example.entre31proto3;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


public class Register2 extends AppCompatActivity {

    Button button;
    EditText email, password ,conpass;
    String server_URL = "http:/192.168.196.1/Entre/Register.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register2);

        button = findViewById(R.id.Register_Button);
        email = findViewById(R.id.Username_Login);
        password = findViewById(R.id.Password_Login);
        conpass = findViewById(R.id.Confirm_Password);
        builder = new AlertDialog.Builder(Register2.this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Email , pass , conpas;

                Email = email.getText().toString();
                pass = password.getText().toString();
                conpas = conpass.getText().toString();

                if(pass.equals(conpas))
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, server_URL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                }else
                {

                }
            }
        });
    }
//    JSONParser jsonParser = new JSONParser();
//
//    private ProgressDialog pDialog;
//    EditText UserName ;
//    EditText Password ;
//    EditText ConPassword ;
//    TextView Info ;
//    DatabaseRegister dbregister;
//
//    private static String URL_Register = "http:/192.168.196.1/Entre/Register.php";
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        dbregister = new DatabaseRegister(this);
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_register2);
//
//        UserName = findViewById(R.id.Username_Login);
//
//        Password = findViewById((R.id.Password_Login));
//
//        ConPassword =  findViewById((R.id.Confirm_Password));
//
//        Info = findViewById(R.id.Info2);
//
//    }
//
//
//    public void RegisterClick(View view)
//    {
//        String user = UserName.getText().toString().trim();
//        String pwd = Password.getText().toString().trim();
//        String conpwd = ConPassword.getText().toString().trim();
//        if(pwd.equals(conpwd)) //true
//        {
//            long val =dbregister.addUser(user,pwd);
//            if(val>0)
//            {
//                //Info.setText("It's a Match");
//                Log.d("Username " ,user);
//                Log.d("Pass",conpwd);
//                new AddUser().execute();
//            }else
//            {
//                Info.setText("Registration Error");
//            }
//        }
//        else // false
//        {
//            Info.setText("Confirm Password Does Not Match !");
//        }
//    }
//    class AddUser extends AsyncTask<String,String,String>{
//
//        @Override
//        protected void  onPreExecute(){
//            super.onPreExecute();
//         pDialog = new ProgressDialog(Register2.this);
//            pDialog.setMessage("Adding User...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
//        }
//
//        String user = UserName.getText().toString().trim();
//        String pwd = Password.getText().toString().trim();
//
//
//        protected String doInBackground(String... args) {
//
//            // Building Parameters
//            List<NameValuePair> params = new ArrayList<>();
//            params.add(new BasicNameValuePair("email", user));
//            params.add(new BasicNameValuePair("password", pwd));
//
//
//            // getting JSON Object
//            // Note that create product url accepts POST method
//            JSONObject json = jsonParser.makeHttpRequest(URL_Register,
//                "POST", params);
//
//            // check log cat fro response
//            Log.d("Create Response", json.toString());
//
//            // check for success tag
//            try {
//                int success = json.getInt("Success!");
//
//                if (success == 1) {
//                    // successfully created product
//                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(i);
//
//                    // closing this screen
//                    finish();
//                } else {
//                    // failed to create product
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//        protected void onPostExecute(String file_url) {
//            // dismiss the dialog once done
//        pDialog.dismiss();
//       }
//
//
//    }

}


