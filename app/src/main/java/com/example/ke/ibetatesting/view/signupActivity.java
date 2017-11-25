package com.example.ke.ibetatesting.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ke.ibetatesting.R;
import com.example.ke.ibetatesting.constant.SQLCommand;
import com.example.ke.ibetatesting.util.DatabaseHelper;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {
    Button signup;
    EditText Name;
    EditText Password;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup=(Button)findViewById(R.id.signup_btn);
        Name =(EditText)findViewById(R.id.newtName);
        Password=(EditText)findViewById(R.id.newtpwd);
        databaseHelper = new DatabaseHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id==R.id.signup_btn){
                    String username, password;
                    username = Name.getText().toString();
                    password = Password.getText().toString();
                    try{
                        databaseHelper.signUpTester(username,password);
                        Toast.makeText(getBaseContext(), "Sign up successfully",
                                Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.getStackTrace();
                        Toast.makeText(getBaseContext(),"Sign Up Fail, please try again",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
