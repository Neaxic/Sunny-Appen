package com.example.sunny_appen.ui.Player;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlayerViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PlayerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("VELKOMMEN TIL HELVEDE");
    }

    public LiveData<String> getText() {
        return mText;
    }
}