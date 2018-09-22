package com.example.adige.cahillerapp.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adige.cahillerapp.R;

public class loginpage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


    }
    public  void  signUpClick(View view){
        Intent intentReg = new Intent(getApplicationContext(),registerpage.class);
        startActivity(intentReg);
    }
}
