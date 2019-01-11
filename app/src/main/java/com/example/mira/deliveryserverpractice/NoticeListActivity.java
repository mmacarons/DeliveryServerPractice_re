package com.example.mira.deliveryserverpractice;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mira.deliveryserverpractice.datas.Announcement;

import java.util.ArrayList;
import java.util.List;

public class NoticeListActivity extends BaseActivity {

    List<Announcement> announcementList = new ArrayList<Announcement>();



    private android.widget.ListView noticeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.noticeListView = (ListView) findViewById(R.id.noticeListView);
    }
}
