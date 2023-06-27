package com.example.myapplication.Adapters;

import android.graphics.drawable.Drawable;

import java.util.Date;

public class News {
    public String TitleName;
    public String Description;
    public Drawable Poster;

    public Date NewDate;

    public News(String titleName, String description, Drawable poster, Date newDate) {
        TitleName = titleName;
        Description = description;
        Poster = poster;
        NewDate = newDate;
    }
}
