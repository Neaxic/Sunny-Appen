package com.example.sunny_appen.ui.leaderboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class LeaderBoardViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private final MutableLiveData<RecyclerView> mRecyclerView;

    public LeaderBoardViewModel() {
        mText = new MutableLiveData<>();
        mRecyclerView = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<RecyclerView> getmRecyclerView(){
        return mRecyclerView;
    }
}