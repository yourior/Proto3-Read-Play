package com.example.entre31proto3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entre31proto3.Catalog.Book;
import com.example.entre31proto3.Catalog.BookAdapter;
import com.example.entre31proto3.Catalog.HttpRequest;
import com.example.entre31proto3.Login.LogIn;
import com.example.entre31proto3.Login.StillLogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        MenuItem nav_Login;
        View navuser;

    private String jsonURL= "http://read-play.id/ShowCatalog.php";


    //private String jsonURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php";
    //private String jsonURL = "read-play.id";
    private final int jsoncode = 1;
    private RecyclerView recyclerView;
    ArrayList<Book> rogerModelArrayList;
    private BookAdapter rogerAdapter;
    private static ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //activity_main_drawer Set
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //Nav_Header_Main Set
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        nav_Login = menu.findItem(R.id.LogIn_Button);
        navuser = navigationView.getHeaderView(0);
        TextView usernameview = navuser.findViewById(R.id.Username_View);
        TextView usercrediteview = navuser.findViewById(R.id.InAppsCredit_View);


        if(StillLogin.getUserName(MainActivity.this).length() == 0) //cek masi login atau tidak
        {
            nav_Login.setTitle("Log In");

            usernameview.setText("Please Login");
            usercrediteview.setText("Credit : Coming Soon");
        }
        else
        {
            nav_Login.setTitle("Log off");

            usernameview.setText(StillLogin.getUserName(this));
            usercrediteview.setText("Credit : Coming Soon");
        }

//        mList = findViewById(R.id.main_list);
//
//        BookList = new ArrayList<>();
//        adapter = new BooktoCatalog(getApplicationContext(),BookList);

//        linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

//        mList.setHasFixedSize(true);
//        mList.setLayoutManager(linearLayoutManager);
//        mList.addItemDecoration(dividerItemDecoration);
//        mList.setAdapter(adapter);
//        getData();

        recyclerView = findViewById(R.id.recycler);

        fetchJSON();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        TextView usernameview = navuser.findViewById(R.id.Username_View);
        TextView usercrediteview = navuser.findViewById(R.id.InAppsCredit_View);



        if (id == R.id.Setting_Button) {

            Intent intent = new Intent(this, DisplayMessageActivity.class);
            startActivity(intent);

        } else if (id == R.id.Basket_Button) {

            Intent intent = new Intent(this, Basket.class);
            startActivity(intent);

        }else if(id == R.id.LogIn_Button)
        {

            if(StillLogin.getUserName(MainActivity.this).length() == 0) //cek masi login atau tidak
            {
                // call Login Activity
                Intent intent = new Intent(this, LogIn.class);
                startActivity(intent);
            }
            else
            {
                // Log out
                StillLogin.Logout(this);
                usernameview.setText("Please Login");
                usercrediteview.setText("Credit : Coming Soon");
                nav_Login.setTitle("Log In");
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //public static final String Extra_Message = "com.example.myfirstapp.MESSAGE";

    //Show Catalog
    private void fetchJSON(){

        showSimpleProgressDialog(this, "Loading...","Fetching Json",false);

        new AsyncTask<Void, Void, String>(){
            protected String doInBackground(Void[] params) {
                String response="";
                HashMap<String, String> map=new HashMap<>();
                try {
                    HttpRequest req = new HttpRequest(jsonURL);
                    response = req.prepare(HttpRequest.Method.POST).withData(map).sendAndReadString();
                } catch (Exception e) {
                    response=e.getMessage();
                }
                return response;
            }
            protected void onPostExecute(String result) {
                //do something with response
                Log.d("newwwss",result);
                onTaskCompleted(result,jsoncode);
            }
        }.execute();
    }

    public void onTaskCompleted(String response, int serviceCode) {
        Log.d("responsejson", response.toString());
        switch (serviceCode) {
            case jsoncode:

                if (isSuccess(response)) {
                    removeSimpleProgressDialog();  //will remove progress dialog
                    rogerModelArrayList = getInfo(response);
                    rogerAdapter = new BookAdapter(this,rogerModelArrayList);
                    recyclerView.setAdapter(rogerAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                }else {
                    Toast.makeText(MainActivity.this, getErrorCode(response), Toast.LENGTH_SHORT).show();
                }
        }
    }

//    public ArrayList<Book> getInfo(String response) {
//        ArrayList<Book> tennisModelArrayList = new ArrayList<>();
//        //ArrayList<Book> BookModelArray = new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(response);
//            if (jsonObject.getString("status").equals("true")) {
//
//                JSONArray dataArray = jsonObject.getJSONArray("data");
//
//                for (int i = 0; i < dataArray.length(); i++) {
//
//                    Book playersModel = new Book();
//                    JSONObject dataobj = dataArray.getJSONObject(i);
//                    playersModel.setName(dataobj.getString("name"));
//                    playersModel.setCountry(dataobj.getString("country"));
//                    playersModel.setCity(dataobj.getString("city"));
//                    playersModel.setImgURL(dataobj.getString("imgURL"));
//                    tennisModelArrayList.add(playersModel);
//
//                }
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//       return tennisModelArrayList;
//        //return BookModelArray;
//    }
public ArrayList<Book> getInfo(String response) {
    ArrayList<Book> tennisModelArrayList = new ArrayList<>();
    //ArrayList<Book> BookModelArray = new ArrayList<>();
    try {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.getString("status").equals("true")) {

            JSONArray dataArray = jsonObject.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {

                Book playersModel = new Book();
                JSONObject dataobj = dataArray.getJSONObject(i);
                playersModel.setBook_Name(dataobj.getString("name"));
                playersModel.setBook_Price(dataobj.getInt("price"));
                playersModel.setCreator(dataobj.getString("creator"));
                playersModel.setImg_Location(dataobj.getString("image"));
                tennisModelArrayList.add(playersModel);

            }
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
    return tennisModelArrayList;
    //return BookModelArray;
}

    public boolean isSuccess(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.optString("status").equals("true")) {
                return true;
            } else {

                return false;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getErrorCode(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.getString("message");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "No data";
    }

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showSimpleProgressDialog(Context context, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
