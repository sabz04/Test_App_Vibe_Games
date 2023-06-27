package com.example.myapplication;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.News;
import com.example.myapplication.Adapters.NewsAdapter;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        ArrayList<News> newsArrayList = getInitialData();

        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsArrayList);

        binding.newsRecyclerView.setAdapter(newsAdapter);

        binding.newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    private ArrayList<News> getInitialData() {

        ArrayList<News> news = new ArrayList<>();
        news.add(new News("ГОТОВ К ОТКРЫТИЮ 19 СЕРВЕРА? \uD83D\uDCA5", "Уже в это воскресенье (25.06.2023) в 16:00 по МСК состоится открытие нового сервера на МАТРЁШКЕ — не упусти возможность начать игру с чистого листа!",
                ContextCompat.getDrawable(getContext(), R.drawable.test_news_poster_1), Calendar.getInstance().getTime()));
        news.add(new News("ДРУЗЬЯ! НАС 6ОО ООО 🎉", "600k — скорее вводи промокод и забирай Rolls-Royce и МАТРЕШКА+\n" +
                "\n" +
                "У нас на МАТРЁШКЕ уже огромная семья, дальше — больше! Вместе развиваемся и идем к новым вершинам \uD83D\uDC9C",
                ContextCompat.getDrawable(getContext(), R.drawable.test_news_poster_2), Calendar.getInstance().getTime()));
        news.add(new News("Хочешь выделиться среди тысячи игроков? \uD83D\uDE0E", "Стань самым хайповым на МАТРЕШКЕ — присылай свой крутой скриншот из игры!\n" +
                "\n" +
                "Мы внимательно отсмотрим каждый снимок, и лучшие из них попадут на стену сообщества. Рискнешь? \uD83D\uDD25",
                ContextCompat.getDrawable(getContext(), R.drawable.test_news_poster_3), Calendar.getInstance().getTime()));
        return news;
    }
}