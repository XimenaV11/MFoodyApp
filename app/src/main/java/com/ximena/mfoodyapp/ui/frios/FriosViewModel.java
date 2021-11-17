package com.ximena.mfoodyapp.ui.frios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FriosViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FriosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is frios fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
