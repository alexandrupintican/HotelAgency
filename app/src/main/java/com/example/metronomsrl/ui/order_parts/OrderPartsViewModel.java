package com.example.metronomsrl.ui.order_parts;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class OrderPartsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public OrderPartsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is order parts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
