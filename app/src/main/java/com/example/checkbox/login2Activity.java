package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import static maes.tech.intentanim.CustomIntent.customType;

import java.util.Calendar;

public class login2Activity extends AppCompatActivity {
    EditText mDisplayDate,door_street,area,district,pincode;
    Button Next;
    static int year_x,month_x,day_x;
    static String dob,doorstreet,ddistrict,aarea,ppincode,address;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        getSupportActionBar().setTitle("REGISTRATION");
        showDialogOnEditTextClick();
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x =  cal.get(Calendar.DAY_OF_MONTH);
        final EditText editText = (EditText) findViewById(R.id.pincode);
        {

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        door_street = findViewById(R.id.door_street);
                        area=findViewById(R.id.Area);
                        district=findViewById(R.id.district);
                        pincode=findViewById(R.id.pincode);
                        Next=findViewById(R.id.lbutton);
                        dob=mDisplayDate.getText().toString();
                        doorstreet=door_street.getText().toString();
                        aarea=area.getText().toString();
                        ddistrict=district.getText().toString();
                        ppincode=pincode.getText().toString();
                        boolean a =doorstreet.isEmpty();
                        boolean b=aarea.isEmpty();
                        boolean c=ppincode.isEmpty();
                        boolean d=ddistrict.isEmpty();
                        boolean e=dob.isEmpty();
                        boolean f=true;
                        if(pincode.length()==6){
                            f=false;
                        }
                        if( (a)|| (b) || (c) || (d) || (e) ||(f)){
                            Toast toast=Toast.makeText(getApplicationContext(),"Please enter all the deatils",Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        else{
                            startActivity(new Intent(getApplicationContext(), Login3Activity.class));
                            customType(login2Activity.this,"left-to-right");
                        }

                        return true;
                    }
                    return false;
                }
            });
        }

    }

    public void showDialogOnEditTextClick(){
        mDisplayDate = (EditText)findViewById(R.id.dob);
            mDisplayDate.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showDialog(DIALOG_ID);

                        }
                    }
            );
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this,dpickerListener,year_x,month_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListener
            =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear +1;
            day_x = dayOfMonth;
            mDisplayDate.setText(day_x+"/"+month_x+"/"+year_x);


        }
    };

    public void lbutton(View view) {
        door_street = findViewById(R.id.door_street);
        area=findViewById(R.id.Area);
        district=findViewById(R.id.district);
        pincode=findViewById(R.id.pincode);
        Next=findViewById(R.id.lbutton);
        dob=mDisplayDate.getText().toString();
        doorstreet=door_street.getText().toString();
        aarea=area.getText().toString();
        ddistrict=district.getText().toString();
        ppincode=pincode.getText().toString();
        boolean a =doorstreet.isEmpty();
        boolean b=aarea.isEmpty();
        boolean c=ppincode.isEmpty();
        boolean d=ddistrict.isEmpty();
        boolean e=dob.isEmpty();
        address=doorstreet+","+aarea+","+ddistrict+","+ppincode;
        boolean f=true;
        if(pincode.length()==6){
            f=false;
        }
        if( (a)|| (b) || (c) || (d) || (e) ||(f)){
            Toast.makeText(this,"Please enter the deatils and check the pincode",Toast.LENGTH_LONG).show();
        }
        else{
            startActivity(new Intent(getApplicationContext(), Login3Activity.class));
            customType(login2Activity.this,"left-to-right");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        customType(login2Activity.this,"right-to-left");
    }
}
