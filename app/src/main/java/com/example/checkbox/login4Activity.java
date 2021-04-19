package com.example.checkbox;
import androidx.appcompat.app.AppCompatActivity;
import com.example.checkbox.login2Activity;
import com.example.checkbox.Login3Activity;
import com.example.checkbox.loginActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.checkbox.model.user;

import io.realm.Realm;

import static maes.tech.intentanim.CustomIntent.customType;

public class login4Activity extends AppCompatActivity {
    EditText EP2mobilenumber,EP2Name,EP2Relation;
    Button Register;
    static String p2mob,p2name,p2relation;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login4);
        final EditText editText = (EditText) findViewById(R.id.EP2relationship);
        {

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        EP2mobilenumber= findViewById(R.id.EP2mobilenumber);
                        EP2Name=findViewById(R.id.EP2Name);
                        EP2Relation=findViewById(R.id.EP2relationship);
                        p2mob=EP2mobilenumber.getText().toString();
                        p2name=EP2Name.getText().toString();
                        p2relation=EP2Relation.getText().toString();
                        boolean d=p2name.isEmpty();
                        boolean e=p2relation.isEmpty();
                        boolean f=p2relation.isEmpty();
                        boolean g=true;
                        if (p2mob.length()==10){
                            g=false;
                        }

                        if((d) || (e) || (f) || (g)){
                            Toast toast=Toast.makeText(getApplicationContext(),"Please enter all the deatils",Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            startActivity(new Intent(getApplicationContext(),MapsActivity.class));
                            Toast toast=Toast.makeText(getApplicationContext(),"Registration was successful",Toast.LENGTH_SHORT);
                            toast.show();
                            customType(login4Activity.this,"fadein-to-fadeout");

                        }


                        return true;
                    }
                    return false;
                }
            });
        }
    }
    public void button7(View view) {
        EP2mobilenumber= findViewById(R.id.EP2mobilenumber);
        EP2Name=findViewById(R.id.EP2Name);
        EP2Relation=findViewById(R.id.EP2relationship);
        p2mob=EP2mobilenumber.getText().toString();
        p2name=EP2Name.getText().toString();
        p2relation=EP2Relation.getText().toString();
        boolean d=p2name.isEmpty();
        boolean e=p2relation.isEmpty();
        boolean f=p2relation.isEmpty();
        boolean g=true;
        if (p2mob.length()==10){
            g=false;
        }

        if((d) || (e) || (f) || (g)){
            Toast.makeText(this,"Please enter all the deatils and check the phone number",Toast.LENGTH_LONG).show();
        }else{
            writetodb();
            startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            Toast.makeText(this,"Regristration was Succesfull",Toast.LENGTH_SHORT).show();
            customType(login4Activity.this,"fadein-to-fadeout");
        }}
    public void writetodb(){
        realm=Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                user user = bgRealm.createObject(user.class);
                user.setName(loginActivity.name);
                user.setNumber(loginActivity.mob);
                user.setGender(loginActivity.gen);
                user.setDob(login2Activity.dob);
                user.setAddress(login2Activity.address);
                user.setPmob(Login3Activity.pmob);
                user.setPname(Login3Activity.pname);
                user.setPrelation(Login3Activity.prelation);
                user.setP2mob(p2mob);
                user.setP2relation(p2relation);
                user.setP2name(p2name);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                //Toast.makeText(MainActivity.this,"successfully written",Toast.LENGTH_LONG).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Toast.makeText(login4Activity.this, (CharSequence) error,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(login4Activity.this,"right-to-left");
    }
}
