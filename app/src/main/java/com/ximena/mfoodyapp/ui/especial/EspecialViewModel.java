package com.ximena.mfoodyapp.ui.especial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EspecialViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public EspecialViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");

    }

    public LiveData<String> getText() {
        return mText;
    }
}
