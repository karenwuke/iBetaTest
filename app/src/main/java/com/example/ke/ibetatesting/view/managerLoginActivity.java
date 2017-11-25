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

public class managerLoginActivity extends AppCompatActivity {
    Button tLogin;
    EditText Name;
    EditText Password;
    DatabaseHelper databaseHelper;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_login);

        tLogin = (Button)findViewById(R.id.managerlogin_btn);
        Name =(EditText)findViewById(R.id.managerName);
        Password = (EditText)findViewById(R.id.managerpwd);

        databaseHelper=new DatabaseHelper(managerLoginActivity.this);

        tLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkManagerExist(Name.getText().toString(),Password.getText().toString());
                if(isExist){
                    Intent intent= new Intent(managerLoginActivity.this,managerMainActivity.class);

                    startActivity(intent);
                }else {
                    Name.setText(null);
                    Toast.makeText(managerLoginActivity.this,"Login failed. Invalid username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
