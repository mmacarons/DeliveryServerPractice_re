package com.example.mira.deliveryserverpractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mira.deliveryserverpractice.datas.User;
import com.example.mira.deliveryserverpractice.utils.ConnectServer;

import org.json.JSONException;
import org.json.JSONObject;

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

                ConnectServer.postRequestLogin(mContext,
                        userIdEdt.getText().toString(),
                        passwordEdt.getText().toString(),
                        new ConnectServer.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                Log.d("로그인서버응답", json.toString());


                                try {
                                    int code = json.getInt("code");

                                    if (code == 200) {
                                        JSONObject data = json.getJSONObject("data");
                                        JSONObject user = data.getJSONObject("user");

                                        User loginUser = User.getUserFromJson(user);

                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        intent.putExtra("로그인한사람", loginUser);
                                        startActivity(intent);

                                    }
                                    else {

                                        final String message = json.getString("message");

                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                                            }
                                        });


                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
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
