package com.minhthien.tmt.flash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.minhthien.tmt.flash.Adapter.ViewPagerAdapter;
import com.minhthien.tmt.flash.Fragments.DeliveryLog;
import com.minhthien.tmt.flash.Fragments.Home;
import com.minhthien.tmt.flash.Fragments.Notification;
import com.minhthien.tmt.flash.Fragments.Setting;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        init();
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home(),"Home");
        adapter.addFragment(new DeliveryLog(),"Status");
        adapter.addFragment(new Setting(),"Setting");
        viewPager.setAdapter(adapter);
    }
    private void init(){

    }

}
