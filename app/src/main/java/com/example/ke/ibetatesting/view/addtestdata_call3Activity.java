//package com.example.ke.ibetatesting.view;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.ke.ibetatesting.R;
//import com.example.ke.ibetatesting.util.DatabaseHelper;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.text.ParseException;
//import java.util.Calendar;
//
//
//public class addtestdata_call3Activity extends AppCompatActivity {
//    Button getTime,addFile;
//    DatabaseHelper databaseHelper;
//    EditText conDateTime,actType;
//    Date actDateTimeDate;
//    Date connectedDateTime;
//    final String conDate = null;
//    final String actDateTime = null;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_addtestdata_call3);
//        addFile=findViewById(R.id.addAllFileData_btn);
//        getTime=findViewById(R.id.getTime_btn);
//        conDateTime=findViewById(R.id.connectedTime_edt);
//        actType=findViewById(R.id.pickActType_edt);
//        //conDate=findViewById(R.id.connectedDate_edt);
//
//        databaseHelper = new DatabaseHelper(this);
//
//        Date currentdate = new Date();
//        //long actDateTime=currentdate.getTime();
//        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss.SSSZ");
//
//        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => " + c.getTime());
//
//        //SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//        final String actDateTime = format.format(c.getTime());
////        try {
////            Date actDateTimeDate = format.parse(actDateTime);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//
//
//        getTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id = v.getId();
//                if (id==R.id.getTime_btn){
//                    String cdate=conDateTime.getText().toString();
//
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    final String conDate = sdf.format(cdate);
////                    try {
//                        //Date connectedDateTime = sdf.parse(cdate);
////                    } catch (ParseException ex) {
////                        //Logger.getLogger(Prime.class.getName()).log(Level.SEVERE, null, ex);
////                    }
//                }
//            }
//        });
//
//        addFile.setOnClickListener(new View.OnClickListener() {
////            Double BC_lat,Double BC_lon,Double GOG_lat, Double GOG_lon;
////            String locDesc, String locType,String devSN, String testerID, Date conDate, Date curDate;
//            @Override
//            public void onClick(View v) {
//                int id = v.getId();
//                if (id==R.id.addAllFileData_btn){
//                    try{
//                        databaseHelper.insertNewCaseFileData(addtestdata_location2Activity.deviceLat,addtestdata_location2Activity.deviceLon,addtestdata_location2Activity.GoogleLat,addtestdata_location2Activity.GooGleLon,addtestdata_location2Activity.locationDesc,addtestdata_location2Activity.locationType,addtestdata_device1Activity.dev_sn,testerMainActivity.testerID,conDate,actDateTime);
//                        Toast.makeText(getBaseContext(), "Insert case file data successfully",
//                                Toast.LENGTH_SHORT).show();
//                    }catch (Exception e){
//                        e.getStackTrace();
//                        Toast.makeText(getBaseContext(),"Insert fail, please check again",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//
//    }
//}
