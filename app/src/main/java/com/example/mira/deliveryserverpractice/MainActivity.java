package com.example.mira.deliveryserverpractice;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mira.deliveryserverpractice.datas.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {

    User mUser;

    private android.widget.TextView announcementTxt;
    private android.widget.LinearLayout firstNoticeLayout;
    private de.hdodenhof.circleimageview.CircleImageView profileImgView;
    private android.widget.TextView welcomeMsgTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        mUser = (User) getIntent().getSerializableExtra("로그인한사람");

        String welcomeMessage = String.format("%s님, 오늘도 힘내주세요!", mUser.getName());

        welcomeMsgTxt.setText(welcomeMessage);

        Glide.with(mContext).load(mUser.getProfile_image()).into(profileImgView);


    }

    @Override
    public void bindViews() {

        this.welcomeMsgTxt = (TextView) findViewById(R.id.welcomeMsgTxt);
        this.profileImgView = (CircleImageView) findViewById(R.id.profileImgView);
        this.firstNoticeLayout = (LinearLayout) findViewById(R.id.firstNoticeLayout);
        this.announcementTxt = (TextView) findViewById(R.id.announcementTxt);
    }
}
