package com.ximena.mfoodyapp.ui.sopas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SopasViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SopasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is especial fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
