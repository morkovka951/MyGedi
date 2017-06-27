package com.example.user.mygedi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hbb20.CountryCodePicker;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CountryCodePicker ccp;
    MaskedEditText phone_input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ccp = (CountryCodePicker) findViewById(R.id.ccp);
        phone_input = (MaskedEditText)findViewById(R.id.phone_input);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                phone_input.setMask(ccp.getSelectedCountryCodeWithPlus() + " ### #### ###");
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(this, CodeActivity.class);
                startActivity(intent);
        }
    }
}
