package com.ximena.mfoodyapp.ui.principios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PrincipiosViewModel  extends ViewModel {
    private MutableLiveData<String> mText;

    public PrincipiosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is principios fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
