package com.example.ke.ibetatesting.view;

import android.content.Intent;
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
import android.content.Context;
import android.widget.Toast;
import android.location.Criteria;
import java.text.*;

public class addtestdata_location2Activity extends AppCompatActivity implements LocationListener{
    Spinner locType;
    EditText devLon, devLat, locDesc,testid,devsn,contime,acttime,city,acttpye;
    Button  confirm;
    private static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String GooGleLon,GoogleLat,testerID,deviceLat,deviceLon,locationDesc,deviceSN,conTime,actTime,testCity,actType;
    String locationType= "";

    DatabaseHelper databaseHelper;

//    String locationType="", locationDesc="";

    public String bestProvider;
    public Criteria criteria;
    Location location;

    Location currentLocation;
    double currentLatitude,currentLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtestdata_location);

        locType=(Spinner)findViewById(R.id.locType_spinner);
        devLat=(EditText)findViewById(R.id.device_lat);
        devLon=(EditText)findViewById(R.id.device_lon);
        confirm=(Button)findViewById(R.id.confirmdata_btn);
        locDesc=(EditText)findViewById(R.id.loc_desc);
        testid=findViewById(R.id.testerID);
        devsn=findViewById(R.id.device_SN);
        contime=findViewById(R.id.connectedDate_edt);
        acttime=findViewById(R.id.actTime_edt);
        city=findViewById(R.id.testcity_edt);
        acttpye=findViewById(R.id.pickActType_edt);
        databaseHelper = new DatabaseHelper(this);
        LocationManager mylocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try{
            mylocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }catch (SecurityException se){
            se.getStackTrace();
        }
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);


//        getLoc.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//
//            public void onClick(View view) {
////                if (currentLatitude != 0 && currentLongitude != 0) {
////                    devLat.setText("" + currentLatitude);
////                    devLon.setText("" + currentLongitude);
////                }
//            }
//
//
//    });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.confirmdata_btn){
//                    String deviceLon,deviceLat;
//                    String locationType= "";
//                    String locationDesc;
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
                    //Float devLatM = currentLatitude;
                    // DecimalFormat df=new DecimalFormat(".##");
                    //double d=1252.2563;
                    //String st=df.format(d);
                    //System.out.println(st);
                    DecimalFormat df_lat=new DecimalFormat(".####");
                    //GoogleLat=Double.parseDouble(df_lat.format(currentLatitude));
                    GoogleLat=df_lat.format(currentLatitude);
                    DecimalFormat df_lon=new DecimalFormat(".####");
                    GooGleLon= df_lat.format(currentLongitude);

                    deviceLat=devLat.getText().toString();
                    deviceLon=devLon.getText().toString();
                    locationDesc=locDesc.getText().toString();
                    testerID=testid.getText().toString();
                    deviceSN=devsn.getText().toString();
                    conTime=contime.getText().toString();
                    actTime=acttime.getText().toString();
                    testCity=city.getText().toString();
                    actType=acttpye.getText().toString();


//                    GoogleLat=String.valueOf(currentLatitude);
//                    GooGleLon=String.valueOf(currentLongitude);


                    try{
                        databaseHelper.insertNewCaseFileData(deviceLat,deviceLon,GoogleLat,GooGleLon,locationDesc,locationType,deviceSN,testerID,conTime,actTime,actType,testCity);
                        Toast.makeText(getBaseContext(), "Insert data successfully",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(addtestdata_location2Activity.this,testerMainActivity.class);
                        startActivity(intent);
                    }catch (Exception e){
                        e.getStackTrace();
                        Toast.makeText(getBaseContext(),"Insert fail, please try again",Toast.LENGTH_SHORT).show();
                    }
//                    Intent intent = new Intent(addtestdata_location2Activity.this,testerMainActivity.class);
//                    addtestdata_location2Activity.this.startActivity(intent);

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
