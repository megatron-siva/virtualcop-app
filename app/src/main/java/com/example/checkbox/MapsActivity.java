package com.example.checkbox;
import com.example.checkbox.loginActivity;
import com.example.checkbox.login2Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.example.checkbox.Login3Activity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import com.example.checkbox.model.user;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import io.realm.Realm;
import io.realm.RealmResults;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    //private GoogleMap oMap;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private final long MIN_TIME = 1000;//1 Second
    private final long MIN_DIS = 1;//1 Meters
    private LatLng latLng;
    static String lattitude="11.285591";
    static String longitude="77.620991";
    private BottomSheetBehavior mBottomSheetBehavior;
    Realm realm;
    String username;
    String mobile;
    String address,dob;
    String pname,pmob,prelation,p2name,p2mob,p2relation;
    //float zoomLevel = 50.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        //ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},PackageManager.PERMISSION_GRANTED);
        View bottomSheet=findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior=BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);



    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Location location = null;
        //Location location = googleMap.getMyLocation();
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(11.33333,77.666666);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Oscillation"));
        //float zoomLevel=40.0f;
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //latLng = new LatLng(11.301359, 77.699263);
        //oMap.addMarker(new MarkerOptions().position(latLng).title("Erode Taluk Policestation"));
        //oMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.301359, 77.699263);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Erode Taluk Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.320365,77.676078);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Thindal PoliceStation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.301359, 77.699169);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Erode Taluk Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.328287, 77.711119);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Surampatti Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.327741, 77.725785);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Raliway Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.337993, 77.728267);
        mMap.addMarker(new MarkerOptions().position(latLng).title("South Traffic Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.339977, 77.728812);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Erode City Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.338538, 77.726650);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Central AWPS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.339459, 77.722559);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Town Policestation Erode"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.340044, 77.717117);
        mMap.addMarker(new MarkerOptions().position(latLng).title("GH Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.353964, 77.728840);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Karungalpalayam Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.345486, 77.698459);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Erode North Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.343855, 77.637148);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Traffic Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.277646, 77.586567);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Perundhurai Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.273534, 77.411194);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Kunnathur Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.429228, 77.561586);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Kavindapadi Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.404656, 77.669937);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Chittode Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.448408, 77.683103);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Women's Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.448420, 77.684567);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Bhavani Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.441211, 77.693120);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Komarapalayam Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.363053, 77.747627);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Pallipalayam Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.338127, 77.726838);
        mMap.addMarker(new MarkerOptions().position(latLng).title("District Superintendent Of Police"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.338082, 77.727122);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Chithambaram Colony Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.337460, 77.728407);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Police Shorthand Bureau Office"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.360186, 77.322747);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Nambiyar Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.503762, 77.244541);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Sathiyamangalam Policestation"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        latLng = new LatLng(11.285591, 77.620991);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        final Marker[] marker = {mMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Current Location"))};
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try{
                    mMap.animateCamera( CameraUpdateFactory.zoomTo( 17.0f ) );
                    //mMap.animateCamera(CameraUpdateFactory.zoomTo(mMap.getCameraPosition().zoom - 0.5f));
                    marker[0].remove();
                    latLng = new LatLng(location.getLatitude(),location.getLongitude());
                    MarkerOptions a=new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Your Location");
                    marker[0] = mMap.addMarker(a);
                    //latLng = new LatLng(location.getLatitude(),location.getLongitude());
                    //MarkerOptions a=new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Your Location");
                    //marker = oMap.addMarker(a);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    lattitude=Double.toString(location.getLatitude());
                    longitude=Double.toString(location.getLongitude());
                    Toast.makeText(MapsActivity.this, "LATITUDE :"+location.getLatitude()+"\nLONGTITUDE :"+location.getLongitude(), Toast.LENGTH_SHORT).show();
                }catch (SecurityException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
            @Override
            public void onProviderEnabled(String provider) {
            }
            @Override
            public void onProviderDisabled(String provider) {
            }
        };
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        try{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME,MIN_DIS,locationListener);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
    }
        public void floating_action_button3(View view){

           //Toast.makeText(MapsActivity.this, "alert in development", Toast.LENGTH_SHORT).show();
            realm= Realm.getDefaultInstance();
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
            String URLline="http://100.127.35.240:3000/rest/emergency";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MapsActivity.this,response,Toast.LENGTH_LONG).show();
                            //parseData(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MapsActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                    params.put("latitude",MapsActivity.lattitude);
                    params.put("longitude",MapsActivity.longitude);
                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }


    public void floating_action_button2(View view){
        //openDialog();
        startActivity(new Intent(getApplicationContext(),ReportActivity.class));

    }

    private void openDialog() {
        try{
    ExampleDialog exampleDialog = new ExampleDialog();
    exampleDialog.show(getSupportFragmentManager(),"");
    TextView dd=findViewById(R.id.report_txt);

        Toast.makeText(MapsActivity.this,dd.getText().toString(),Toast.LENGTH_LONG).show();
    }
    catch (Exception e){
        Toast.makeText(MapsActivity.this,e.toString(),Toast.LENGTH_LONG).show();
    }}

    public void floating_action_button1(View view){
        realm= Realm.getDefaultInstance();
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
        String URLline="http://100.127.35.240:3000/rest/intimate";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MapsActivity.this,response,Toast.LENGTH_LONG).show();
                        //parseData(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MapsActivity.this,error.toString(),Toast.LENGTH_LONG).show();
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
                params.put("latitude",MapsActivity.lattitude);
                params.put("longitude",MapsActivity.longitude);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void floating_action_button4(View view) {
        about();
    }
    private void about() {
        ExampleDialog1 exampleDialog1 = new ExampleDialog1();
        exampleDialog1.show(getSupportFragmentManager(),"");
    }
    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
    }
}