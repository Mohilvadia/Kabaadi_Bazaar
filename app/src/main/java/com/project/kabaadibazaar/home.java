package com.project.kabaadibazaar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {
    Toolbar toolbar;
    TextView bookreq,howit,ratelist;
    DrawerLayout drawer;
    ActionBarDrawerToggle abdt;
    Context ctx=this;
    LinearLayout book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        allocatememory();
        navbar();
        setevent();
    }

    private void setevent() {
        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=getTaskId();
                if(R.id.bookrequest==id){
                    Toast.makeText(ctx,"Book request",Toast.LENGTH_LONG).show();

                }

            }
        });
        bookreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Book request",Toast.LENGTH_LONG).show();
            }
        });
        ratelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Book request",Toast.LENGTH_LONG).show();
            }
        });
        howit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Book request",Toast.LENGTH_LONG).show();
            }
        });


    }

    private void allocatememory() {
        toolbar=findViewById(R.id.toolbar);
        drawer=findViewById(R.id.drawer);
        bookreq=findViewById(R.id.bookrequest);
        howit=findViewById(R.id.howit);
        ratelist=findViewById(R.id.ratelist);
        book=findViewById(R.id.book);
    }

    private void navbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final LinearLayout content = (LinearLayout) findViewById(R.id.drawer1);
        abdt=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {

                book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ctx,"Book request",Toast.LENGTH_LONG).show();
                        Log.d("no","nahi");

                    }
                });
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.addDrawerListener(abdt);
        abdt.syncState();

    }

}
