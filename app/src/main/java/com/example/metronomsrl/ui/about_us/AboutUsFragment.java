package com.example.metronomsrl.ui.about_us;

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

import com.example.metronomsrl.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutUsFragment extends Fragment implements OnMapReadyCallback {

    private AboutUsViewModel mViewModel;
    private MapView mapShopView;
    private GoogleMap googleShopMap;
    private MapView mapServiceView;
    private GoogleMap googleServiceMap;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(AboutUsViewModel.class);
        View root = inflater.inflate(R.layout.about_us_fragment, container, false);
        final TextView aboutUsTextView = root.findViewById(R.id.about_us_text);
        final TextView whereToTextView = root.findViewById(R.id.where_to);
        final TextView shopInfoTextView = root.findViewById(R.id.shop_info);
        final TextView serviceInfoTextView = root.findViewById(R.id.service_info);
        mViewModel.getAboutUsText(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                aboutUsTextView.setText(s);
            }
        });
        mViewModel.getWhereToText(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                whereToTextView.setText(s);
            }
        });
        mViewModel.getShopInfoText(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                shopInfoTextView.setText(s);
            }
        });
        mViewModel.getServiceInfoText(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                serviceInfoTextView.setText(s);
            }
        });
        mapShopView = root.findViewById(R.id.shopMapView);
        mapShopView.onCreate(savedInstanceState);
        mapShopView.onResume();
        mapShopView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment

        mapServiceView = root.findViewById(R.id.serviceMapView);
        mapServiceView.onCreate(savedInstanceState);
        mapServiceView.onResume();
        mapServiceView.getMapAsync(this);//when you already implement OnMapReadyCallback in your fragment
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutUsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleShopMap = map;
        googleServiceMap = map;

        LatLng shop = new LatLng(46.5325303, 24.5592060);
        LatLng service = new LatLng(46.5202894, 24.5138830);
        googleShopMap.addMarker(new MarkerOptions().position(shop).title("Marker for shop"));
        googleServiceMap.addMarker(new MarkerOptions().position(service).title("Marker for service"));
        float zoomLevel = 17.0f;
        googleShopMap.moveCamera(CameraUpdateFactory.newLatLngZoom(shop, zoomLevel));
        googleServiceMap.moveCamera(CameraUpdateFactory.newLatLngZoom(service, zoomLevel));
    }
}
