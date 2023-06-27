package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final ArrayList<News> news;
    Locale russianLocale = new Locale("ru", "RU");

    public NewsAdapter(Context context, ArrayList<News> news) {
        this.news = news;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.news_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        News currentNews = news.get(position);
        holder.newsPosterImageView.setImageDrawable(currentNews.Poster);
        holder.titleTextView.setText(currentNews.TitleName);
        holder.descTextView.setText(currentNews.Description);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, russianLocale);
        holder.dateTextView.setText(dateFormat.format(currentNews.NewDate));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView newsPosterImageView;
        final TextView titleTextView, descTextView, dateTextView;
        ViewHolder(View view){
            super(view);
            newsPosterImageView = view.findViewById(R.id.newsPoster);
            titleTextView = view.findViewById(R.id.newsTitle);
            descTextView = view.findViewById(R.id.newsDescription);
            dateTextView = view.findViewById(R.id.dateTextView);
        }
    }
    public static class ItemFirstNameViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTextView;
        ItemFirstNameViewHolder(View view){
            super(view);
            titleTextView = view.findViewById(R.id.newsTitle);
        }
    }

}






