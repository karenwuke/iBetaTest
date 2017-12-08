package com.example.ke.ibetatesting.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.ke.ibetatesting.R;

/**
 * Created by ke on 11/22/17.
 */

public class managerMainActivity extends AppCompatActivity{
    Button add, analyze;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_main);
        add =(Button)findViewById(R.id.signup_btn);
        analyze= (Button)findViewById(R.id.dataAnalyze_btn);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =v.getId();
                if(id==R.id.signup_btn){
                    Intent intent = new Intent(managerMainActivity.this,signupActivity.class);
                    startActivity(intent);
                }
            }
        });
        analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.dataAnalyze_btn){
                    Intent intent = new Intent(managerMainActivity.this,analyzeActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
