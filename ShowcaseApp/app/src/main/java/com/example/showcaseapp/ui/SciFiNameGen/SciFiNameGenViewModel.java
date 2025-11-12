package com.example.showcaseapp.ui.SciFiNameGen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SciFiNameGenViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SciFiNameGenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}