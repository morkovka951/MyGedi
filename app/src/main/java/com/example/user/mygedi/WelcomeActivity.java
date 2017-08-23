package com.example.user.mygedi;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    RelativeLayout add;
    RelativeLayout taskToday;
    RelativeLayout myCalendar;
    TextView textView8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView8 = (TextView) findViewById(R.id.textView8);
        add = (RelativeLayout) findViewById(R.id.add);
        taskToday = (RelativeLayout) findViewById(R.id.taskToday);
        myCalendar = (RelativeLayout) findViewById(R.id.myCalendar);


        add.setVisibility(View.INVISIBLE);
        taskToday.setVisibility(View.INVISIBLE);
        myCalendar.setVisibility(View.INVISIBLE);

        ((ImageButton) findViewById(R.id.mainButtonAW)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //textView8.setVisibility(View.INVISIBLE);
                applyBlurMaskFilter(textView8, BlurMaskFilter.Blur.NORMAL);

                add.setVisibility(View.VISIBLE);
                taskToday.setVisibility(View.VISIBLE);
                myCalendar.setVisibility(View.VISIBLE);

                ((ImageButton) findViewById(R.id.butAdd)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, ActivityAdd.class);
                        startActivity(intent);
                    }
                });

                ((ImageButton) findViewById(R.id.butToday)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, ActivityAdd.class);
                        startActivity(intent);
                    }
                });

                ((ImageButton) findViewById(R.id.butCalendar)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WelcomeActivity.this, ActivityMyCalendar.class);
                        startActivity(intent);
                    }
                });

                //Intent intent = new Intent(WelcomeActivity.this, ActivityMyCalendar.class);
                //startActivity(intent);
                //finish();
            }
        });
    }

    //blur textView8
    private void applyBlurMaskFilter(TextView textView8, BlurMaskFilter.Blur style) {
        float radius = textView8.getTextSize() / 3;
        BlurMaskFilter filter = new BlurMaskFilter(radius, style);
        textView8.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        textView8.getPaint().setMaskFilter(filter);
    }


    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}
