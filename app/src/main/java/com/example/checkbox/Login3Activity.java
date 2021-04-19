package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import static maes.tech.intentanim.CustomIntent.customType;

public class Login3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText EPmobilenumber,EPName,EPRelation;
    Button Register;


    static String pmob,prelation,pname,srelation;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        srelation=adapterView.getSelectedItem().toString();
        Toast.makeText(this,srelation,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        final EditText editText = (EditText) findViewById(R.id.EPRelationShip);
        {

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        EPmobilenumber= findViewById(R.id.EPmobilenumber);
                        EPName=findViewById(R.id.EPName);
                        EPRelation=findViewById(R.id.EPRelationShip);
                        pmob=EPmobilenumber.getText().toString();
                        pname=EPName.getText().toString();
                        prelation=EPRelation.getText().toString();
                        boolean a=pmob.isEmpty() ;
                        boolean c=pname.isEmpty();
                        boolean e=prelation.isEmpty();
                        boolean g=true;
                        if (pmob.length()==10){
                            g=false;
                        }

                        if((a)|| (c) || (e) || (g)){
                            Toast toast=Toast.makeText(getApplicationContext(),"Please enter all the deatils",Toast.LENGTH_SHORT);
                            toast.show();
                        }else{
                            startActivity(new Intent(getApplicationContext(),login4Activity.class));
                            customType(Login3Activity.this,"left-to-right");
                        }


                        return true;
                    }
                    return false;
                }
            });
        }
    }
    public void button4(View view) {
        EPmobilenumber= findViewById(R.id.EPmobilenumber);
        EPName=findViewById(R.id.EPName);
        EPRelation=findViewById(R.id.EPRelationShip);
        pmob=EPmobilenumber.getText().toString();
        pname=EPName.getText().toString();
        prelation=EPRelation.getText().toString();
        boolean a=pmob.isEmpty() ;
        boolean c=pname.isEmpty();
        boolean e=prelation.isEmpty();
        boolean g=true;
        if (pmob.length()==10){
            g=false;
        }

        if((a)|| (c) || (e) || (g)){
            Toast.makeText(this,"Please enter all the deatils and check the phone number",Toast.LENGTH_LONG).show();
        }else{
            startActivity(new Intent(getApplicationContext(),login4Activity.class));
            customType(Login3Activity.this,"left-to-right");
        }}
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(Login3Activity.this,"right-to-left");
    }

}
