package com.example.myapplication.Adapters;

import android.graphics.drawable.Drawable;

public class Server {
    public String Title;
    public String Ping;
    public String CurrentOnline;
    public String MaxOnline;
    public Drawable ServerPoster;

    public String MapName;
    public String ServerSideVersion;
    public boolean IsNeedUpdate;

    public Server(String title, String ping, String currentOnline, String maxOnline, Drawable serverPoster, String mapName, String serverSideVersion, boolean isNeedUpdate) {
        Title = title;
        Ping = ping;
        CurrentOnline = currentOnline;
        MaxOnline = maxOnline;
        ServerPoster = serverPoster;
        MapName = mapName;
        ServerSideVersion = serverSideVersion;
        IsNeedUpdate = isNeedUpdate;
    }

    public Server(String title, String ping, String currentOnline, String maxOnline, Drawable serverPoster) {
        Title = title;
        Ping = ping;
        CurrentOnline = currentOnline;
        MaxOnline = maxOnline;
        ServerPoster = serverPoster;
    }
}
