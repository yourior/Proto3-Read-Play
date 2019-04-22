package com.example.entre31proto3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {



    EditText UserName_Log ;
    EditText Password_Log ;
    private Button login;
    TextView UsernameView;
    TextView Money;
    private static final String URL = "http:/192.168.196.1/Entre/user_config.php";

    private RequestQueue requestQueue;

    private StringRequest request;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        UserName_Log =  findViewById(R.id.Username_Login);
        Password_Log =  findViewById(R.id.Password_Login);
        login =  findViewById(R.id.button);
        UsernameView =  findViewById(R.id.Username_View);
        Money = findViewById(R.id.InAppsCredit_View);

        requestQueue = Volley.newRequestQueue(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success")){
                                Toast.makeText(getApplicationContext(),"SUCCESS"+jsonObject.get("success"),
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Welcome.class));
                            }else
                            {
                                Toast.makeText(getApplicationContext(),"ERROR"+jsonObject.get("error"),
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Welcome.class));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    }, new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error)
                        {

                        }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError{
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("email",UserName_Log.getText().toString());
                        hashMap.put("password",Password_Log.getText().toString());

                        return hashMap;
                    }
                };
                requestQueue.add(request);
            }
        });
    }

        public void MoveToRegister2(View view)
    {
        Intent intent = new Intent(this, Register2.class);

        startActivity(intent);
    }









}
