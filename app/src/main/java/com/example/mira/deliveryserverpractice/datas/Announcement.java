package com.example.mira.deliveryserverpractice.datas;

import java.io.Serializable;
import java.util.Calendar;

public class Announcement implements Serializable {

    private int id;
    private Calendar created_at = Calendar.getInstance();
    private String title;
    private String content;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
