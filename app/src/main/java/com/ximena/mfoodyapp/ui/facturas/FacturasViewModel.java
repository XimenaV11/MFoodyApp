package com.ximena.mfoodyapp.ui.facturas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FacturasViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public FacturasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
