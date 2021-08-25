package com.aisyahharum.pegawaiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String JSON_STRING="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GetJSON getJSON=new GetJSON();
        getJSON.execute();
    }

    public class GetJSON extends AsyncTask<Void, Void, String>{
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog= ProgressDialog.show(MainActivity.this, "Mengambil Data",
                    "Mohon Tunggu...", false, false);

        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestMandler rh=new RequestMandler();
            String s=rh.sendGetRequest(konfigurasi.URL_GET_ALL);
            return s;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            JSON_STRING=s;
        }
    }
    private void showEmployee(){
        JSONObject jsonObject=null;
        ArrayList<HashMap<String, String>> list=new ArrayList<>();

        try {
            jsonObject=new JSONObject(JSON_STRING);
            JSONArray result=jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for (int i=0); i<length ();1++{
                JSONObject jsonresult.jsonresult.getJSONObject(1);
                String id=jsonObject.getString(konfigurasi.TAG_ID);
                String name=jsonObject.getString(konfigurasi.TAG_NAME);
                MashMap<String, String>employess=new MashMap<>();
                employess.put(konfigurasi.TAG_ID, id);
                employess.put(konfigurasi.TAG_NAME, name);
                list.add(employess);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SimpleAdapter adapter=new SimpleAdapter(this.list.R.layout.list_item, new String[]
        (konfigurasi.TAG_ID, konfigurasi.TAG_NAME), new int[](R.id.id, R.id.name));
        listView.setAdapter(adapter);
    }

    private class length {
    }
    
}