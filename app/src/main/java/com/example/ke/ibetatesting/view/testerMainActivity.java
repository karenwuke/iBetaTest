package com.example.ke.ibetatesting.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ke.ibetatesting.R;
import com.example.ke.ibetatesting.util.DatabaseHelper;
import com.example.ke.ibetatesting.constant.SQLCommand;

/**
 * Created by ke on 11/22/17.
 */

public class testerMainActivity extends AppCompatActivity{
    Button addRecord, dataAna;

    DatabaseHelper databaseHelper;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester_main);

        addRecord=(Button)findViewById(R.id.addRecord_btn);
        dataAna=(Button)findViewById(R.id.dataManager_btn);

        databaseHelper = new DatabaseHelper(testerMainActivity.this);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =v.getId();
                if(id==R.id.addRecord_btn){

                    Intent intent = new Intent(testerMainActivity.this,addtestdata_location2Activity.class);
                    startActivity(intent);
                }
            }
        });

        dataAna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql="";
                int id =v.getId();
                if(id==R.id.dataManager_btn){
//                    Intent intent = new Intent(testerMainActivity.this,datamanage.class);
//                    startActivity(intent);
                    // show checkout list result

                    sql = SQLCommand.RECORD_LIST;
                    Intent intent = new Intent(getApplicationContext(),
                            ShowListActivity.class);
                    intent.putExtra("sql", sql);
                    startActivity(intent);

                }
            }
        });


    }

}

