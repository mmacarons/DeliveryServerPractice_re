package com.example.mira.deliveryserverpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

    private android.widget.EditText userIdEdt;
    private android.widget.EditText passwordEdt;
    private android.widget.Button signUpBtn;
    private android.widget.Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SignUpActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.userIdEdt = (EditText) findViewById(R.id.userIdEdt);

    }
}
