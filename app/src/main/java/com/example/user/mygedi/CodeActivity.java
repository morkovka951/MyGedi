package com.example.user.mygedi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class CodeActivity extends AppCompatActivity implements View.OnClickListener {

    MaskedEditText code_input;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        code_input = (MaskedEditText) findViewById(R.id.code_input);
        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:

                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);

        }
    }
}
