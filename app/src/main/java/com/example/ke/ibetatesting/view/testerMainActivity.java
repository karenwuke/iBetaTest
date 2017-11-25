package com.example.ke.ibetatesting.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ke.ibetatesting.R;

/**
 * Created by ke on 11/22/17.
 */

public class testerMainActivity extends AppCompatActivity{
    Button addRecord, dataAna;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester_main);

        addRecord=(Button)findViewById(R.id.addRecord_btn);
        dataAna=(Button)findViewById(R.id.dataAnalyze_btn);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =v.getId();
                if(id==R.id.addRecord_btn){
                    Intent intent = new Intent(testerMainActivity.this,addtestdataActivity.class);
                    startActivity(intent);
                }
            }
        });

//        dataAna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int id =v.getId();
//                if(id==R.id.dataAnalyze_btn){
//                    Intent intent = new Intent(testerMainActivity.this,datamanage.class);
//                    startActivity(intent);
//                }
//            }
//        });


    }

}

