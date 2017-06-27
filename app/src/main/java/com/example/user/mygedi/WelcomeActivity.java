package com.example.user.mygedi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton mainButtonAW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mainButtonAW = (ImageButton)findViewById(R.id.mainButtonAW);
        mainButtonAW.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mainButtonAW:
                Intent intent = new Intent(this, ActivityWithButton.class);
                startActivity(intent);
        }
    }
}
