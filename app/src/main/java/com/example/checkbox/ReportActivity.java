package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.checkbox.model.user;

import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;
import com.example.checkbox.MapsActivity;

public class ReportActivity extends AppCompatActivity {
    Realm realm;
    EditText rep;
    String username;
    String mobile;
    String address,dob;
    String pname,pmob,prelation,p2name,p2mob,p2relation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    public void ok(View view) {
        rep=findViewById(R.id.repoort);
        realm=Realm.getDefaultInstance();
        RealmResults<user> guests = realm.where(user.class).findAll();
        realm.beginTransaction();
        for (final user guest:guests) {
            username = guest.getName();
            mobile = guest.getNumber();
            dob=guest.getDob();
            address=guest.getAddress();
            pname=guest.getPname();
            pmob=guest.getPmob();
            prelation=guest.getPrelation();
            p2name=guest.getP2name();
            p2mob=guest.getP2mob();
            p2relation=guest.getP2relation();
        }
            //Toast.makeText(this,username,Toast.LENGTH_LONG).show();
        //Toast.makeText(this,guest.getName(),Toast.LENGTH_LONG).show();
        realm.commitTransaction();
        String URLline="http://100.127.35.240:3000/rest/report";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ReportActivity.this,response,Toast.LENGTH_LONG).show();
                        //parseData(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ReportActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("username",username);
                params.put("mobile",mobile);
                params.put("dob",dob);
                params.put("address",address);
                params.put("pname",pname);
                params.put("pmob",pmob);
                params.put("prelation",prelation);
                params.put("p2name",p2name);
                params.put("p2mob",p2mob);
                params.put("p2relation",p2relation);
                params.put("report",rep.getText().toString());
                params.put("latitude",MapsActivity.lattitude);
                params.put("longitude",MapsActivity.longitude);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }
    public void cancel(View view) {
        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }
}
