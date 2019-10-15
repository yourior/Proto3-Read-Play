//package com.example.entre31proto3.Catalog;
//
//import android.annotation.SuppressLint;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.example.entre31proto3.R;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class BooktoCatalog extends AppCompatActivity {
//
//    private String jsonURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php";
//    private final int jsoncode = 1;
//    private RecyclerView recyclerView;
//    ArrayList<Book> rogerModelArrayList;
//    private BookAdapter rogerAdapter;
//    private static ProgressDialog mProgressDialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.book_catalog2);
//
//        recyclerView = findViewById(R.id.recycler);
//
//        fetchJSON();
//
//    }
//    @SuppressLint("StaticFieldLeak")
////    private void fetchJSON(){
////
////        showSimpleProgressDialog(this, "Loading...","Fetching Json",false);
////
////        new AsyncTask<Void, Void, String>(){
////            protected String doInBackground(Void[] params) {
////                String response="";
////                HashMap<String, String> map=new HashMap<>();
////                try {
////                    HttpRequest req = new HttpRequest(jsonURL);
////                    response = req.prepare(HttpRequest.Method.POST).withData(map).sendAndReadString();
////                } catch (Exception e) {
////                    response=e.getMessage();
////                }
////                return response;
////            }
////            protected void onPostExecute(String result) {
////                //do something with response
////                Log.d("newwwss",result);
////                onTaskCompleted(result,jsoncode);
////            }
////        }.execute();
////    }
////
////    public void onTaskCompleted(String response, int serviceCode) {
////        Log.d("responsejson", response.toString());
////        switch (serviceCode) {
////            case jsoncode:
////
////                if (isSuccess(response)) {
////                    removeSimpleProgressDialog();  //will remove progress dialog
////                    rogerModelArrayList = getInfo(response);
////                    rogerAdapter = new BookAdapter(this,rogerModelArrayList);
////                    recyclerView.setAdapter(rogerAdapter);
////                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
////
////                }else {
////                    Toast.makeText(BooktoCatalog.this, getErrorCode(response), Toast.LENGTH_SHORT).show();
////                }
////        }
////    }
////
////    public ArrayList<Book> getInfo(String response) {
////        ArrayList<Book> tennisModelArrayList = new ArrayList<>();
////        try {
////            JSONObject jsonObject = new JSONObject(response);
////            if (jsonObject.getString("status").equals("true")) {
////
////                JSONArray dataArray = jsonObject.getJSONArray("data");
////
////                for (int i = 0; i < dataArray.length(); i++) {
////
////                    Book playersModel = new Book();
////                    JSONObject dataobj = dataArray.getJSONObject(i);
////                    playersModel.setName(dataobj.getString("name"));
////                    playersModel.setCountry(dataobj.getString("country"));
////                    playersModel.setCity(dataobj.getString("city"));
////                    playersModel.setImgURL(dataobj.getString("imgURL"));
////                    tennisModelArrayList.add(playersModel);
////
////                }
////            }
////
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////        return tennisModelArrayList;
////    }
////
////    public boolean isSuccess(String response) {
////
////        try {
////            JSONObject jsonObject = new JSONObject(response);
////            if (jsonObject.optString("status").equals("true")) {
////                return true;
////            } else {
////
////                return false;
////            }
////
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////        return false;
////    }
////
////    public String getErrorCode(String response) {
////
////        try {
////            JSONObject jsonObject = new JSONObject(response);
////            return jsonObject.getString("message");
////
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////        return "No data";
////    }
////
////    public static void removeSimpleProgressDialog() {
////        try {
////            if (mProgressDialog != null) {
////                if (mProgressDialog.isShowing()) {
////                    mProgressDialog.dismiss();
////                    mProgressDialog = null;
////                }
////            }
////        } catch (IllegalArgumentException ie) {
////            ie.printStackTrace();
////
////        } catch (RuntimeException re) {
////            re.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////
////    }
////
////    public static void showSimpleProgressDialog(Context context, String title,
////                                                String msg, boolean isCancelable) {
////        try {
////            if (mProgressDialog == null) {
////                mProgressDialog = ProgressDialog.show(context, title, msg);
////                mProgressDialog.setCancelable(isCancelable);
////            }
////
////            if (!mProgressDialog.isShowing()) {
////                mProgressDialog.show();
////            }
////
////        } catch (IllegalArgumentException ie) {
////            ie.printStackTrace();
////        } catch (RuntimeException re) {
////            re.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//}
