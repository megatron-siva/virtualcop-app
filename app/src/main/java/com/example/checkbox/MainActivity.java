package com.example.checkbox;
import com.example.checkbox.model.user;

import io.realm.Realm;
import io.realm.RealmResults;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.checkbox.model.user;

import io.realm.Realm;
import io.realm.RealmResults;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
    private CheckBox License;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        License = findViewById(R.id.License);
        getSupportActionBar().setTitle("Agreement");
        Realm realm;
        realm=Realm.getDefaultInstance();
        RealmResults<user> guests = realm.where(user.class).findAll();
        user userschedule=guests.first();
        if (userschedule!=null){
            //Toast.makeText(MainActivity.this,"empty",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),MapsActivity.class));
        }
        else {
            //Toast.makeText(MainActivity.this,"written",Toast.LENGTH_LONG).show();

        }}
        catch (Exception e){
            //Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
        }

    }



    public void Button1(View view) {
        if(License.isChecked()){
            startActivity(new Intent(getApplicationContext(),loginActivity.class));
            customType(MainActivity.this,"left-to-right");

        }
        else{
            Toast.makeText(this,"Please Agree the TREM AND CONDITION",Toast.LENGTH_SHORT).show();

        }

    }
}
