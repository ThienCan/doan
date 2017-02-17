package com.minhthien.tmt.flash;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private Button btnSignup;
    private TextView textViewBacktoLogin;
    private TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        set_font_logo();
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textViewBacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void init(){
        btnSignup = (Button) findViewById(R.id.buttonSignup);
        textViewBacktoLogin = (TextView) findViewById(R.id.textViewBackLogin);
        logo = (TextView) findViewById(R.id.logo);
    }
    public void set_font_logo(){
        Typeface fontkaushanscript = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.ttf");
        logo.setTypeface(fontkaushanscript);
    }
}
