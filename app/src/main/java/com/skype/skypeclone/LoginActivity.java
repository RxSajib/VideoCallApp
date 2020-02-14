package com.skype.skypeclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private CheckBox privatepolicycheackbox;
    private Button signupbutton;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.LoginEmialID);
        password = findViewById(R.id.LoginPasswordID);

        privatepolicycheackbox = findViewById(R.id.PrivatePolicyCheackbxID);
        signupbutton = findViewById(R.id.SignUpButtonID);

        signupbutton.setEnabled(false);
        privatepolicycheackbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(privatepolicycheackbox.isChecked()){
                    signupbutton.setEnabled(true);
                    signupbutton.setBackgroundResource(R.drawable.login_button_design);

                    startlogin();

                }
                else {
                    signupbutton.setEnabled(false);
                    signupbutton.setBackgroundResource(R.drawable.hide_button_design);
                }
            }
        });


    }

    private void startlogin(){
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emialtext = email.getText().toString();
                String passwordtxet = password.getText().toString();

                if(emialtext.isEmpty()){
                    email.setError("Email require");
                }
                else if(passwordtxet.isEmpty()){
                    password.setError("Password require");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }
}
