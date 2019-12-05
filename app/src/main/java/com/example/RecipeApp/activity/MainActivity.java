package com.example.RecipeApp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.RecipeApp.R;
import com.example.RecipeApp.adapter.TabPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar appToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(appToolbar);

        ViewPager viewPager = findViewById(R.id.pager);
        TabPagerAdapter tmpPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tmpPagerAdapter);

        TabLayout tmpTabLayout = findViewById(R.id.sliding_tabs);
        tmpTabLayout.setupWithViewPager(viewPager);
    }
}
