package com.technocopy.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    RadioButton rb1, rb2;
    TextView tvColor;
    RadioGroup redioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btReturn = findViewById(R.id.btReturn);
        btReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        tvColor = findViewById(R.id.tvTheme);
        redioGroup = findViewById(R.id.radioGroup);

        redioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                    tvColor.setBackgroundColor(getResources().getColor(R.color.purple_700));
                    break;
                    case R.id.radioButton2:
                        tvColor.setBackgroundColor(getResources().getColor(R.color.Orange));
                        break;
                }
            }
        });


    }
}