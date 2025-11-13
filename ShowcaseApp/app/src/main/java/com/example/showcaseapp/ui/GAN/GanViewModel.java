package com.example.showcaseapp.ui.GAN;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GanViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public GanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is GAN fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}