package com.example.myapplication.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import kotlin.text.Regex;

public class ServersAdapter  extends RecyclerView.Adapter<ServersAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    public final ArrayList<Server> servers;

    public final Context context;

    public ServersAdapter(ArrayList<Server> servers, Context context) {
        this.servers = servers;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.servers_list_item, parent, false);
        return new ServersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServersAdapter.ViewHolder holder, int position) {
        Server currentServer = servers.get(position);
        holder.serverPoster.setImageDrawable(currentServer.ServerPoster);
        holder.serverTitle.setText(currentServer.Title);
        holder.serverOnline.setText(String.format("%s/%s", currentServer.CurrentOnline, currentServer.MaxOnline));
        holder.serverPing.setText(currentServer.Ping + " мс");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog;

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View dialogView = inflater.inflate(R.layout.server_info_dialog, null);

                TextView serverTitleTextView = dialogView.findViewById(R.id.serverTitleTextView);
                TextView serverMapTextView = dialogView.findViewById(R.id.serverMapTextView);
                TextView serverVersionTextView = dialogView.findViewById(R.id.serverVersionTextView);
                TextView serverIsUpdatedClientTextView = dialogView.findViewById(R.id.serverIsUpdatedClientTextView);
                TextView playersCountTextView = dialogView.findViewById(R.id.playersCountTextView);
                TextView pingTextView = dialogView.findViewById(R.id.pingTextView);
                Button playButton = dialogView.findViewById(R.id.playButton);
                playButton.setText("Введите ник корректно");
                playButton.setEnabled(false);
                playButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "КРЯ!", Toast.LENGTH_LONG).show();
                    }
                });
                EditText nickNameEditText = dialogView.findViewById(R.id.nickNameEditText);
                ImageView serverImagePosterImageView = dialogView.findViewById(R.id.serverImagePosterImageView);

                serverTitleTextView.setText(currentServer.Title);
                serverMapTextView.setText(currentServer.MapName);
                serverVersionTextView.setText(currentServer.ServerSideVersion);
                pingTextView.setText(currentServer.Ping + " мс");
                serverImagePosterImageView.setImageDrawable(currentServer.ServerPoster);
                playersCountTextView.setText(currentServer.CurrentOnline + "/" + currentServer.MaxOnline);
                if(currentServer.IsNeedUpdate){
                    serverIsUpdatedClientTextView.setText(" не требуется");

                }
                else {
                    serverIsUpdatedClientTextView.setText(" требуется");
                }

                nickNameEditText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        String text = editable.toString();
                        if (text.length() > 0 && Pattern.matches("^[a-zA-Z0-9]{3,7}_[a-zA-Z0-9]{3,7}$", text)){
                            playButton.setEnabled(true);
                            playButton.setText("Играть!");
                        }
                        else {
                            playButton.setEnabled(false);
                            playButton.setText("Введите ник корректно");
                        }
                    }
                });

                builder.setView(dialogView);



                alertDialog = builder.create();
                alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                alertDialog.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return servers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView serverPoster;
        final TextView serverTitle, serverOnline, serverPing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            serverPoster = itemView.findViewById(R.id.serverPosterImageView);
            serverTitle = itemView.findViewById(R.id.serverTitleTextView);
            serverOnline = itemView.findViewById(R.id.playersCountTextView);
            serverPing = itemView.findViewById(R.id.pingTextView);
        }
    }
}
