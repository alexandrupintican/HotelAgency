package com.example.hotelagency.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class GalleryViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    private MutableLiveData<PhotoId> mListItem;

    public GalleryViewModel() {
        mListItem = new MutableLiveData<>();
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<PhotoId> getListItem() { return mListItem; }

}
