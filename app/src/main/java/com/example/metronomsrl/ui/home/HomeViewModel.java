package com.example.metronomsrl.ui.home;

import android.view.ViewGroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.metronomsrl.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mHeader;
    private MutableLiveData<String> mDescription;
    private MutableLiveData<String> mServices;
    private MutableLiveData<Integer> mCarouselImage;
    private final int[] images = {R.drawable.photo27, R.drawable.photo28, R.drawable.photo29, R.drawable.photo30, R.drawable.photo31};

    public HomeViewModel() {
        mCarouselImage = new MutableLiveData<>();
        mCarouselImage.setValue(R.drawable.photo27);
        mHeader = new MutableLiveData<>();
        mDescription = new MutableLiveData<>();
        mServices = new MutableLiveData<>();
    }

    public LiveData<String> getHeader(ViewGroup container) {
        mHeader.setValue(container.getContext().getResources().getString(R.string.company_header));
        return mHeader;
    }

    public LiveData<String> getDescription(ViewGroup container) {
        mDescription.setValue(container.getContext().getResources().getString(R.string.company_description));
        return mDescription;
    }

    public LiveData<String> getServices(ViewGroup container) {
        mServices.setValue(container.getContext().getResources().getString(R.string.services_and_options));
        return mServices;
    }

    public LiveData<Integer> getImage() { return mCarouselImage; }

    public int getCarouselLength() {
        return images.length;
    }
}