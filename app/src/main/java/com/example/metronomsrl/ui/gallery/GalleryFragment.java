package com.example.metronomsrl.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metronomsrl.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel mViewModel;
    private RecyclerView mGalleryList;
    private RecyclerView.Adapter mGalleryAdapter;

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.gallery_fragment, container, false);
        mGalleryList = root.findViewById(R.id.recycler_view);
        mGalleryList.hasFixedSize();
        mGalleryList.setLayoutManager(new LinearLayoutManager(root.getContext()));

        ArrayList<PhotoId> images = new ArrayList<>();
        images.add(new PhotoId(R.drawable.photo1, R.drawable.photo2));
        images.add(new PhotoId(R.drawable.photo3, R.drawable.photo4));
        images.add(new PhotoId(R.drawable.photo5, R.drawable.photo6));
        images.add(new PhotoId(R.drawable.photo7, R.drawable.photo8));
        images.add(new PhotoId(R.drawable.photo9, R.drawable.photo10));
        images.add(new PhotoId(R.drawable.photo11, R.drawable.photo12));
        images.add(new PhotoId(R.drawable.photo13, R.drawable.photo14));
        images.add(new PhotoId(R.drawable.photo15, R.drawable.photo16));
        images.add(new PhotoId(R.drawable.photo17, R.drawable.photo18));
        images.add(new PhotoId(R.drawable.photo19, R.drawable.photo20));
        images.add(new PhotoId(R.drawable.photo21, R.drawable.photo22));
        images.add(new PhotoId(R.drawable.photo23, R.drawable.photo24));
        images.add(new PhotoId(R.drawable.photo25, R.drawable.photo26));
        images.add(new PhotoId(R.drawable.photo32, R.drawable.photo33));
        images.add(new PhotoId(R.drawable.photo34, R.drawable.photo35));
        images.add(new PhotoId(R.drawable.photo36, R.drawable.photo37));
        images.add(new PhotoId(R.drawable.photo38, R.drawable.photo39));


        mGalleryAdapter = new GalleryAdapter(images);
        mGalleryList.setAdapter(mGalleryAdapter);
        /*final TextView textView = root.findViewById(R.id.gallery_text);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        // TODO: Use the ViewModel
    }

}
