package com.example.ke.ibetatesting.view;

import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ke.ibetatesting.R;
import com.example.ke.ibetatesting.util.DatabaseHelper;

import android.support.v4.app.ActivityCompat;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;
import android.location.Criteria;

public class addtestdataActivity extends AppCompatActivity implements LocationListener{
    Spinner locType;
    EditText devLon, devLat, locDesc;
    Button getLoc, confirmLoc;
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String GooGleLon,GoogleLat;
    DatabaseHelper databaseHelper;
    public String bestProvider;
    public Criteria criteria;
    Location location;

    Location currentLocation;
    double currentLatitude,currentLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtestdata);

        locType=(Spinner)findViewById(R.id.locType_spinner);
        devLat=(EditText)findViewById(R.id.device_lat);
        devLon=(EditText)findViewById(R.id.device_lon);
        getLoc=(Button)findViewById(R.id.getLocation_btn);
        confirmLoc=(Button)findViewById(R.id.LocConfirm_btn);
        locDesc=(EditText)findViewById(R.id.loc_desc);
        LocationManager mylocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try{
            mylocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }catch (SecurityException se){
            se.getStackTrace();
        }
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);


        getLoc.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
//                if (currentLatitude != 0 && currentLongitude != 0) {
//                    devLat.setText("" + currentLatitude);
//                    devLon.setText("" + currentLongitude);
//                }
            }


    });

        confirmLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.LocConfirm_btn){
                    String deviceLon,deviceLat;
                    String locationType= "";
                    String Desc;
                    int pos=locType.getSelectedItemPosition();
                    if(pos==1){
                        locationType = "Mountain";
                    }else if(pos==2){
                        locationType="City";
                    }else if(pos==3){
                        locationType="Plain";
                    }else if(pos==4){
                        locationType="Underground";
                    }else if(pos==5){
                        locationType="Coastal";
                    }else if(pos==6){
                        locationType="Water Body";
                    }

                    deviceLat=devLat.getText().toString();
                    deviceLon=devLon.getText().toString();
                    Desc=locDesc.getText().toString();
                    GoogleLat=String.valueOf(currentLatitude);
                    GooGleLon=String.valueOf(currentLongitude);

                    try{
                        databaseHelper.insertLocationData(deviceLat,deviceLon,GoogleLat,GooGleLon,Desc,locationType);
                        Toast.makeText(getBaseContext(), "Insert location data successfully",
                                Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.getStackTrace();
                        Toast.makeText(getBaseContext(),"Insert fail, please try again",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    @Override
    public void onLocationChanged(Location location) {
        currentLongitude = location.getLongitude();
        currentLatitude = location.getLatitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
