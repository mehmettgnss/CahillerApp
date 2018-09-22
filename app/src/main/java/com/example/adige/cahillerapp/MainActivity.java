package com.example.adige.cahillerapp;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.example.adige.cahillerapp.fragments.homepage;
import com.example.adige.cahillerapp.fragments.mylist;
import com.example.adige.cahillerapp.fragments.videos;
import com.example.adige.cahillerapp.user.loginpage;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appbarLayout);
        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new homepage(),"Anasayfa");
        adapter.AddFragment(new mylist(),"Kategoriler");
        adapter.AddFragment(new videos(),"Videolar");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    public void accountClick(View view){

      //  Toast.makeText(getApplicationContext(),"Lütfen Giriş Yapınız", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),loginpage.class);
        startActivity(intent);
    }

}
