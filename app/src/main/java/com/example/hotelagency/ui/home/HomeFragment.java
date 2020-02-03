package com.example.hotelagency.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hotelagency.R;


public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private ImageView imageView;
    //private int[] images = {R.drawable.photo27, R.drawable.photo28, R.drawable.photo29, R.drawable.photo30, R.drawable.photo31};

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.home_fragment, container, false);
        imageView = root.findViewById(R.id.logo);
        imageView.setImageResource(R.drawable.agency);
        //final TextView headerTextView = root.findViewById(R.id.header_text);
        final TextView descriptionTitleTextView = root.findViewById(R.id.description_title);
        final TextView descriptionTextView = root.findViewById(R.id.description_text);
        final TextView servicesTitleTextView = root.findViewById(R.id.services_title);
        final TextView servicesTextView = root.findViewById(R.id.services_text);
       /* mViewModel.getHeader(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                headerTextView.setText(s);
            }
        });*/
       mViewModel.getDescriptionTitle(container).observe(this, new Observer<String>() {
           @Override
           public void onChanged(@Nullable String s) {
               descriptionTitleTextView.setText(s);
           }
       });
        mViewModel.getDescription(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                descriptionTextView.setText(s);
            }
        });
        mViewModel.getServiceTitle(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                servicesTitleTextView.setText(s);
            }
        });
        mViewModel.getServices(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                servicesTextView.setText(s);
            }
        });
        return root;
    }

  /*  private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[position]);
        }
    };*/


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }
}