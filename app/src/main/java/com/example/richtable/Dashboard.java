package com.example.richtable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
Toolbar tool;
DrawerLayout draw;
NavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getIntent();
        draw = findViewById(R.id.drawer);
        nav = findViewById(R.id.navigation);
        tool = findViewById(R.id.toolbar);
         setSupportActionBar(tool);

        ActionBarDrawerToggle action = new ActionBarDrawerToggle(this, draw,tool,R.string.NavigationOpen,R.string.NavigationClose);
        draw.addDrawerListener(action);
        action.syncState();

    }
}