package com.example.metronomsrl.ui.home;

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

import com.example.metronomsrl.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private CarouselView carouselView;
    private int[] images = {R.drawable.photo27, R.drawable.photo28, R.drawable.photo29, R.drawable.photo30, R.drawable.photo31};

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.home_fragment, container, false);
        carouselView = root.findViewById(R.id.carouselView);
        carouselView.setPageCount(mViewModel.getCarouselLength());
        carouselView.setImageListener(imageListener);
        final TextView headerTextView = root.findViewById(R.id.header_text);
        final TextView descriptionTextView = root.findViewById(R.id.description_text);
        final TextView servicesTextView = root.findViewById(R.id.services_text);
        mViewModel.getHeader(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                headerTextView.setText(s);
            }
        });
        mViewModel.getDescription(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                descriptionTextView.setText(s);
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

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[position]);
        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }
}