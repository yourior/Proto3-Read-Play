package com.example.entre31proto3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LoginBackground  extends AsyncTask<String,Void,String>  {

    LogIn log = new LogIn();
    Context context;
    //int LogOrReg;
    AlertDialog alertDialog;
    LoginBackground (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //LogOrReg =1;
        Log.d("Pesan3","masuk");
        String login_url = "http://read-play.id/Login.php";
        String register_url = "http://read-play.id/Register.php";
        //103.129.220.250
        if(type.equals("login")) {
            //LogOrReg =1;
            try {
                String username = params[1];
                String password = params[2];

                Log.d("Pesan3","login");
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //Log.d("Pesan2","" +" : ["+email+"] , ["+password+"]");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                //Log.d("Pesan4","" + bufferedReader.readLine());
                while((line = bufferedReader.readLine())!= null) {
                    //Log.d("Pesan1","" + line);
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("Pesan3","" + result +" : ["+username+"] , ["+password+"]");
                if(result.equals("Login Success"))
                {
                    StillLogin.setUserName(context,username,"0");
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //Log.d("Pesan2",e+"");
            } catch (IOException e) {
                e.printStackTrace();
                //Log.d("Pesan1",e+"");
            }
        }else if(type.equals("register"))
        {
            //LogOrReg =2;
            try {
                String email = params[1];
                String password = params[2];
                String username = params[3];
                Log.d("Pesan3","register");
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //Log.d("Pesan2","" +" : ["+email+"] , ["+password+"]");
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        +URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                //Log.d("Pesan4","" + bufferedReader.readLine());
                while((line = bufferedReader.readLine())!= null) {
                  //  Log.d("Pesan1","" + line);
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                //Log.d("Pesan3","" + result +" : ["+email+"] , ["+password+"]");

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //Log.d("Pesan2",e+"");
            } catch (IOException e) {
                e.printStackTrace();
                //Log.d("Pesan1",e+"");
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Status");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
        alertDialog.getWindow().setLayout(1000, 900);

        //log.movetoMAin();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }






}
