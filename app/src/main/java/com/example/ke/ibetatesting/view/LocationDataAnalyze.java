package com.example.ke.ibetatesting.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

import com.example.ke.ibetatesting.R;

public class LocationDataAnalyze extends AppCompatActivity {

    ImageButton devl,devc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_analyze_main);
        devc=findViewById(R.id.devcallcon_btn);
        devl=findViewById(R.id.devloccy_btn);
        devl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= v.getId();
                if(id==R.id.devloccy_btn){
                    Intent intent = new Intent(LocationDataAnalyze.this,locationAccuracyActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
