package com.example.hotelagency.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelagency.R;

import java.util.ArrayList;

class GalleryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private ArrayList<PhotoId> mGallery;

    GalleryAdapter(ArrayList<PhotoId> gallery){
        mGallery = gallery;

    }


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.gallery_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mLeftPhoto.setImageResource(mGallery.get(position).getLeftPhotoId());
        holder.mRightPhoto.setImageResource(mGallery.get(position).getRightPhotoId());

    }

    @Override
    public int getItemCount() {
        return mGallery.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mLeftPhoto;
        ImageView mRightPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            mLeftPhoto = itemView.findViewById(R.id.image_item_left);
            mRightPhoto = itemView.findViewById(R.id.image_item_right);
        }
    }
}
