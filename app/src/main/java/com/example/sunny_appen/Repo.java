package com.example.sunny_appen;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class Repo {

    //Center for data
    private static Repo instance;
    private MutableLiveData<ArrayList<Player>> players;
    private MutableLiveData<ArrayList<Point>> points;

    private Repo(){
        players = new MutableLiveData<>();
        points = new MutableLiveData<>();

        Player d = new Player();
        d.setNavn("Bente");

        ArrayList<Player> p = new ArrayList<>();
        p.add(d);

        players.postValue(p);
    }

    public static synchronized Repo getInstance(){
        if(instance == null){
            instance = new Repo();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Player>> getPlayers() {
        return players;
    }


}
