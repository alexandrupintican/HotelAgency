package com.example.metronomsrl.ui.gallery;

public class PhotoId {
    private int leftPhotoId;
    private int rightPhotoId;

    PhotoId(int leftPhoto, int rightPhoto) {
        this.leftPhotoId = leftPhoto;
        this.rightPhotoId = rightPhoto;
    }

    public int getLeftPhotoId() {
        return this.leftPhotoId;
    }

    public int getRightPhotoId() {
        return this.rightPhotoId;
    }
}
