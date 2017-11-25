package com.example.ke.ibetatesting.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ke.ibetatesting.R;

public class choosingActivity extends AppCompatActivity implements View.OnClickListener{

    Button testerLogin, managerLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);
        testerLogin = (Button)this.findViewById(R.id.testerLogin_btn);
        managerLogin = (Button)findViewById(R.id.managerLogin_btn);
        testerLogin.setOnClickListener(this);
        managerLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.testerLogin_btn){
            Intent intent = new Intent(this,testerLoginActivity.class);
            this.startActivity(intent);
        }else if(id==R.id.managerLogin_btn){
            Intent intent= new Intent(this,managerLoginActivity.class);
            this.startActivity(intent);
        }
    }
}

