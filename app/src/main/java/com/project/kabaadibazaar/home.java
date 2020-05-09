package com.project.kabaadibazaar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.LinearLayout;

public class home extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle abdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        allocatememory();
        navbar();
    }

    private void allocatememory() {
        toolbar=findViewById(R.id.toolbar);
        drawer=findViewById(R.id.drawer);
    }

    private void navbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final LinearLayout content = (LinearLayout) findViewById(R.id.content);
        abdt=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close){

        };
        drawer.addDrawerListener(abdt);
        abdt.syncState();
    }
}
