package com.example.ke.ibetatesting.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ke.ibetatesting.R;
import com.example.ke.ibetatesting.util.DatabaseHelper;

public class addDevInfo extends AppCompatActivity {
    Button devInfo;
    EditText devsn, devdescription, devVersion;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dev_info);
        devInfo=findViewById(R.id.addDevInfo_btn);
        devsn=findViewById(R.id.devInfo_SN_edt);
        devdescription=findViewById(R.id.devInfo_desc_edt);
        devVersion=findViewById(R.id.dev_ver_edt);
        databaseHelper = new DatabaseHelper(this);

        devInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id==R.id.addDevInfo_btn){
                    String devSN=devsn.getText().toString();
                    String devDesc=devdescription.getText().toString();
                    String devVer=devVersion.getText().toString();
                    try{
                        databaseHelper.insertDeviceInfo(devSN,devDesc,devVer);
                        Toast.makeText(getBaseContext(), "Insert location data successfully",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(addDevInfo.this,testerMainActivity.class);
                        startActivity(intent);
                    }catch (Exception e){
                        e.getStackTrace();
                        Toast.makeText(getBaseContext(),"Insert fail, please check the input",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
