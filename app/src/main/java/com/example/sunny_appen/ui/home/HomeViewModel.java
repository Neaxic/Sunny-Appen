package com.example.sunny_appen.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("VELKOMMEN TIL HELVEDE");
    }

    public LiveData<String> getText() {
        return mText;
    }
}