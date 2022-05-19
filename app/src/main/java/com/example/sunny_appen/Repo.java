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
        d.setNavn("Andreas");

        Player d2 = new Player();
        d2.setNavn("Kasper");

        Player d4 = new Player();
        d4.setNavn("Kristian");

        Player d5 = new Player();
        d5.setNavn("Bo");

        Player d6 = new Player();
        d6.setNavn("Marcus");

        Player d7 = new Player();
        d7.setNavn("Chen");

        Player d8 = new Player();
        d8.setNavn("Jones");

        ArrayList<Player> p = new ArrayList<>();
        p.add(d);
        p.add(d2);
        p.add(d4);
        p.add(d5);
        p.add(d6);
        p.add(d7);
        p.add(d8);

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
