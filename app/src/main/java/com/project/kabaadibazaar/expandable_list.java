package com.project.kabaadibazaar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class expandable_list extends AppCompatActivity {
    LinearLayout layout1,layout2,layout3,layoyut4;
    CardView card1,card2,card3,card4;
    ImageView down1,down2,down3,down4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        memoryallocate();
        setevent();
    }

    private void setevent() {
    down1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(layout1.getVisibility()== View.GONE){
                TransitionManager.beginDelayedTransition(card1, new AutoTransition());
                layout1.setVisibility(View.VISIBLE);
                down1.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            else{
                TransitionManager.beginDelayedTransition(card1, new AutoTransition());
                layout1.setVisibility(View.GONE);
                down1.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }
    });
    down2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(layout2.getVisibility()== View.GONE){
                TransitionManager.beginDelayedTransition(card2, new AutoTransition());
                layout2.setVisibility(View.VISIBLE);
                down2.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            else{
                TransitionManager.beginDelayedTransition(card2, new AutoTransition());
                layout2.setVisibility(View.GONE);
                down2.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }
    });
    down3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(layout3.getVisibility()== View.GONE){
                TransitionManager.beginDelayedTransition(card3, new AutoTransition());
                layout3.setVisibility(View.VISIBLE);
                down3.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            else{
                TransitionManager.beginDelayedTransition(card3, new AutoTransition());
                layout3.setVisibility(View.GONE);
                down3.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }
    });
    down4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(layoyut4.getVisibility()== View.GONE){
                TransitionManager.beginDelayedTransition(card4, new AutoTransition());
                layoyut4.setVisibility(View.VISIBLE);
                down4.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
            }
            else{
                TransitionManager.beginDelayedTransition(card4, new AutoTransition());
                layoyut4.setVisibility(View.GONE);
                down4.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
            }
        }
    });
    }

    private void memoryallocate() {
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layou2);
        layout3=findViewById(R.id.layout3);
        layoyut4=findViewById(R.id.layout4);
        card1=findViewById(R.id.card1);
        card2=findViewById(R.id.card2);
        card3=findViewById(R.id.card3);
        card4=findViewById(R.id.card4);
        down1=findViewById(R.id.down1);
        down2=findViewById(R.id.down2);
        down3=findViewById(R.id.down3);
        down4=findViewById(R.id.down4);
    }
}
