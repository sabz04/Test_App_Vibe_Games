package com.example.myapplication;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.Server;
import com.example.myapplication.Adapters.ServersAdapter;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.databinding.FragmentServersBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ServersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServersFragment newInstance(String param1, String param2) {
        ServersFragment fragment = new ServersFragment();
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

    FragmentServersBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentServersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        ArrayList<Server> servers = getinitdata();

        binding.serversRecyclerView.setAdapter(new ServersAdapter(servers, getContext()));
        binding.serversRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private ArrayList<Server> getinitdata() {
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server("Матрешка RP| Server 01", "20", "200", "1000", ContextCompat.getDrawable(getContext(), R.drawable.logo_small), "Матрешка #1", "2.0", false));
        servers.add(new Server("Матрешка RP| Server 02", "50", "500", "1000", ContextCompat.getDrawable(getContext(), R.drawable.logo_small), "Матрешка #2", "1.0", true));
        servers.add(new Server("Матрешка RP| Server 03", "60", "900", "1000", ContextCompat.getDrawable(getContext(), R.drawable.logo_small), "Матрешка #3", "3.0", false));
        return servers;
    }
}