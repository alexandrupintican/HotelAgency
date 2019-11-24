package com.example.metronomsrl.ui.about_us;

import android.view.ViewGroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.metronomsrl.R;


public class AboutUsViewModel extends ViewModel {
    private MutableLiveData<String> mAboutUsText;
    private MutableLiveData<String> mWhereTo;
    private MutableLiveData<String> mShopInfo;
    private MutableLiveData<String> mServiceInfo;

    public AboutUsViewModel() {
        mAboutUsText = new MutableLiveData<>();
        mWhereTo = new MutableLiveData<>();
        mShopInfo = new MutableLiveData<>();
        mServiceInfo = new MutableLiveData<>();
    }

    public LiveData<String> getAboutUsText(ViewGroup container) {
        mAboutUsText.setValue(container.getContext().getResources().getString(R.string.about_us));
        return mAboutUsText;
    }
    public LiveData<String> getWhereToText(ViewGroup container) {
        mWhereTo.setValue(container.getContext().getResources().getString(R.string.where_to));
        return mWhereTo;
    }
    public LiveData<String> getShopInfoText(ViewGroup container) {
        mShopInfo.setValue(container.getContext().getResources().getString(R.string.shop_info));
        return mShopInfo;
    }
    public LiveData<String> getServiceInfoText(ViewGroup container) {
        mServiceInfo.setValue(container.getContext().getResources().getString(R.string.service_info));
        return mServiceInfo;
    }
}
