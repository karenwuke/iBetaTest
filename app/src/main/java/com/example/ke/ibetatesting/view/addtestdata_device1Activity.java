//package com.example.ke.ibetatesting.view;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//
//import com.example.ke.ibetatesting.R;
//import com.example.ke.ibetatesting.util.DatabaseHelper;
//
//public class addtestdata_device1Activity extends AppCompatActivity {
//    static EditText dev_SN, dev_desc;
//    Button submit_dev;
//    //DatabaseHelper databaseHelper;
//    static String dev_sn = dev_SN.getText().toString();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_addtestdata_device1);
//        //dev_desc = (EditText)findViewById(R.id.dev_desc_edt);
//        dev_SN =(EditText)findViewById(R.id.dev_SN_edt);
//        submit_dev = (Button)findViewById(R.id.device_data_btn);
//        //databaseHelper = new DatabaseHelper(addtestdata_device1Activity.this);
//
//        submit_dev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id = v.getId();
//                if (id==R.id.device_data_btn){
////                    String devSN = dev_SN.getText().toString();
////                    String devDesc = dev_desc.getText().toString();
////                    try{
////                        databaseHelper.insertDeviceData(devSN,devDesc);
////                        Toast.makeText(getBaseContext(), "Insert device data successfully",
////                                Toast.LENGTH_SHORT).show();
////                    }catch (Exception e){
////                        e.getStackTrace();
////                        Toast.makeText(getBaseContext(),"Insert fail, please check again",Toast.LENGTH_SHORT).show();
////                    }
//                    Intent intent = new Intent(addtestdata_device1Activity.this,addtestdata_location2Activity.class);
//                    addtestdata_device1Activity.this.startActivity(intent);
//
//                }
//            }
//        });
//    }
//}
