package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static maes.tech.intentanim.CustomIntent.customType;

public class loginActivity extends AppCompatActivity {
    private EditText Mobilenumber,Name;
    private TextView gender;
    private RadioButton male,female,others;
    private Button button2;
    static String name;
    static String mob;
    static String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("REGISTRATION");
        final EditText editText = (EditText) findViewById(R.id.username);
        {

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        Mobilenumber = (EditText) findViewById(R.id.mobilenumber);
                        Name = (EditText) findViewById(R.id.username);
                        male= (RadioButton) findViewById(R.id.male);
                        female= (RadioButton) findViewById(R.id.female);
                        others=(RadioButton) findViewById(R.id.others);
                        String name = Mobilenumber.getText().toString();
                        String pass = Name.getText().toString();

                        boolean a = name.isEmpty() ;
                        boolean b = pass.isEmpty();
                        boolean c =false;
                        boolean  d=false;
                        boolean e = male.isChecked();
                        boolean f = female.isChecked();
                        boolean g = others.isChecked();
                        boolean h = true;
                        if((e)||(f)||(g)){
                            h=false;
                        }
                        if(name.length()== 10){
                            c=false;
                        }else {
                            c=true;
                        }

                        if ((a) || (b) || (c) ||(h)) {
                            Toast toast=Toast.makeText(getApplicationContext(),"Please enter all the details and check the phone number",Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            startActivity(new Intent(getApplicationContext(), login2Activity.class));
                            customType(loginActivity.this,"left-to-right");
                        }


                        return true;
                    }
                    return false;
                }
            });
        }

    }

    public void button2(View view) {

        Mobilenumber = (EditText) findViewById(R.id.mobilenumber);
        Name = (EditText) findViewById(R.id.username);
        male= (RadioButton) findViewById(R.id.male);
        female= (RadioButton) findViewById(R.id.female);
        others=(RadioButton) findViewById(R.id.others);
        String name = Mobilenumber.getText().toString();
        String pass = Name.getText().toString();
        this.name=pass;
        this.mob=name;

        boolean a = name.isEmpty() ;
        boolean b = pass.isEmpty();
        boolean c =false;
        boolean  d=false;
        boolean e = male.isChecked();
        boolean f = female.isChecked();
        boolean g = others.isChecked();
        boolean h = true;
        if((e)||(f)||(g)){
            h=false;
        }
        if(name.length()== 10){
            c=false;
        }else {
            c=true;
        }

        if ((a) || (b) || (c) ||(h)) {
            Toast.makeText(this, "Please enter all details or Enter the correct phone number", Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(getApplicationContext(), login2Activity.class));
            customType(loginActivity.this,"left-to-right");
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(loginActivity.this,"right-to-left");
    }
}