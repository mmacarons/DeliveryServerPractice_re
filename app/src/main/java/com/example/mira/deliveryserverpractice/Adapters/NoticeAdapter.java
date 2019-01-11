package com.example.mira.deliveryserverpractice.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mira.deliveryserverpractice.R;
import com.example.mira.deliveryserverpractice.datas.Announcement;


import java.util.List;

public class NoticeAdapter extends ArrayAdapter<Announcement> {

    Context mContext;
    List<Announcement> mList;
    LayoutInflater inf;


    public NoticeAdapter (Context context, List<Announcement> list) {
        super(context, R.layout.notice_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.notice_list_item, null);
        }

        TextView titleTxt = row.findViewById(R.id.titleTxt);
        TextView contentTxt = row.findViewById(R.id.contentTxt);

        return row;
    }
}
