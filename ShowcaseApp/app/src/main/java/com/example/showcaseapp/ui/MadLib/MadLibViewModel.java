package com.example.showcaseapp.ui.MadLib;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MadLibViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MadLibViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is MadLib fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}