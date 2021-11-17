package com.ximena.mfoodyapp.ui.proteinas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProteinasViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ProteinasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is proteinas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
