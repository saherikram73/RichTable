package com.example.richtable;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class Dashboard extends AppCompatActivity {
Toolbar tool;
DrawerLayout draw;
NavigationView nav;
SliderView sliderView;
int [] image = {R.drawable.s1,
        R.drawable.s2,
        R.drawable.s3,
        R.drawable.s4,
        R.drawable.s1,


};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getIntent();
        draw = findViewById(R.id.drawer);
        //nav = findViewById(R.id.navigation);
        sliderView = findViewById(R.id.slider);
//        tool = findViewById(R.id.toolbar);
//         setSupportActionBar(tool);


//        ActionBarDrawerToggle action = new ActionBarDrawerToggle(this, draw,tool,R.string.NavigationOpen,R.string.NavigationClose);
//        draw.addDrawerListener(action);
//        action.syncState();
        SliderAdopter sliderAdopter = new SliderAdopter(image);

        sliderView.setSliderAdapter(sliderAdopter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();


    }
}