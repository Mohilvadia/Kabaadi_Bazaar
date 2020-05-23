package com.project.kabaadibazaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class home extends AppCompatActivity {
    Toolbar toolbar;

    DrawerLayout drawer;
    ActionBarDrawerToggle abdt;
    Context ctx=this;
    NavigationView navbar;
    LinearLayout homefrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        allocatememory();
        loadFragment(new BlankFragment());
        navbar();
    }


    private void allocatememory() {
        toolbar=findViewById(R.id.toolbar);
        drawer=findViewById(R.id.drawer);
       navbar=findViewById(R.id.navbar);
    }

    private void navbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        abdt=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(abdt);
        abdt.syncState();
        navbar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                if(id==R.id.book){
                    Toast.makeText(ctx,"book reqquset",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(id==R.id.about){
                    Toast.makeText(ctx,"about",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(id==R.id.howit){
                    Toast.makeText(ctx,"how it works",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(id==R.id.rate){
                    Toast.makeText(ctx,"Rate us",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(id==R.id.share){
                    Toast.makeText(ctx,"Share",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                if(id==R.id.contact){
                    Toast.makeText(ctx,"Contact",Toast.LENGTH_LONG).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
        navbar.bringToFront();


    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.homefrag, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }


}
