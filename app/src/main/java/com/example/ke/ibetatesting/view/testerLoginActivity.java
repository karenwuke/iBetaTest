package com.example.ke.ibetatesting.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ke.ibetatesting.R;

import com.example.ke.ibetatesting.util.DatabaseHelper;

/**
 * Created by ke on 11/22/17.
 */

public class testerLoginActivity extends AppCompatActivity {
    Button tLogin;
    EditText Name;
    EditText Password;
    DatabaseHelper databaseHelper;
   // DBOperator dbOperator = new DBOperator();



    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester_login);

        tLogin = (Button)findViewById(R.id.testerlogin_btn);
        Name =(EditText)findViewById(R.id.testerName);
        Password = (EditText)findViewById(R.id.testerpwd);

        databaseHelper=new DatabaseHelper(testerLoginActivity.this);

        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkTesterExist(Name.getText().toString(),Password.getText().toString());
                if(isExist){
                    Intent intent= new Intent(testerLoginActivity.this,testerMainActivity.class);

                    startActivity(intent);
                }else {
                    Name.setText(null);
                    Toast.makeText(testerLoginActivity.this,"Login failed. Invalid username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }}
