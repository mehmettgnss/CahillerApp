package com.example.adige.cahillerapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adige.cahillerapp.fragments.cloud;
import com.example.adige.cahillerapp.fragments.homepage;
import com.example.adige.cahillerapp.fragments.mylist;
import com.example.adige.cahillerapp.navigationFragments.interest;
import com.example.adige.cahillerapp.navigationFragments.settings;
import com.example.adige.cahillerapp.user.loginpage;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    NavigationView navigationView;
    ImageView accountface;
    TextView titleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = (TextView) findViewById(R.id.textTitle);
        accountface = (ImageView) findViewById(R.id.account);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.myList:
                        titleText.setText("İlgi Alanlarım");
                        interest interest = new interest();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, interest);
                        fragmentTransaction.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.settings:
                        titleText.setText("Ayarlar");
                        settings settings = new settings();
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_container, settings);
                        fragmentTransaction2.commit();
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setUp1();
        toolbar.setTitle("");
      /*  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new homepage()).commit();

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,
        R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

    }
   /* public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new homepage();
                    setUp1();
                    break;
                case R.id.category:
                    selectedFragment = new mylist();
                    setUp2();
                    break;
                case R.id.cloud:
                    selectedFragment = new cloud();
                    setUp3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return  true;
        }
    };

    private void setUp1(){
        setSupportActionBar(toolbar);
        titleText.setText("Anasayfa");
    }
    private void setUp2(){
        setSupportActionBar(toolbar);
        titleText.setText("Listeler");
    }
    private void setUp3(){
        setSupportActionBar(toolbar);
        titleText.setText("Beğeniler");
    }

    public void accountClick(View view){

      //  Toast.makeText(getApplicationContext(),"Lütfen Giriş Yapınız", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),loginpage.class);
        startActivity(intent);
    }

}
