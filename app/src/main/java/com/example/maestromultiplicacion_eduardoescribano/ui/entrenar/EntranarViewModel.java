package com.example.maestromultiplicacion_eduardoescribano.ui.entrenar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EntranarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EntranarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragmento para entrenar");
    }

    public LiveData<String> getText() {
        return mText;
    }
}