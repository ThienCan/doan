package com.minhthien.tmt.flash;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button buttonLogin;
    private TextView logo;
    private EditText edt_email;
    private EditText edt_password;
    private TextView textView_gotosignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //initialize
        logo = (TextView) findViewById(R.id.logo);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        edt_email = (EditText) findViewById(R.id.editTextEmail);
        edt_password = (EditText) findViewById(R.id.editTextPassword);
        textView_gotosignup= (TextView) findViewById(R.id.textViewGoToSignUp);

        //set up TextLogo font
        Typeface fontkaushanscript = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.ttf");
        logo.setTypeface(fontkaushanscript);



        Intent itent = getIntent();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validation()){
                    Toast.makeText(Login.this, "Login Fail", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    finish();
            }
        });
        textView_gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    public boolean validation(){
        boolean valid = true;
        String email = edt_email.getText().toString();
        String password = edt_password.getText().toString();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edt_email.setError("Please enter a valid email !");
            valid = false;
        } else edt_email.setError(null);
        if (password.isEmpty()|| password.length()<4){
            edt_password.setError("password must more than 4 characters");
            valid = false;
        } else edt_password.setError(null);

        return valid;
    }

}
