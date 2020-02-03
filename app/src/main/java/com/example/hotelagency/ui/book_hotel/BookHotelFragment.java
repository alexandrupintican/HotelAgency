package com.example.hotelagency.ui.book_hotel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hotelagency.R;
import com.example.hotelagency.ui.book_hotel.Entities.Country;
import com.example.hotelagency.ui.book_hotel.Entities.Hotel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BookHotelFragment extends Fragment {

    private BookHotelViewModel mViewModel;
    private Button mButton;
    private String mCar_body;
    private String mIdentification_number;
    private String mCilinders;
    private String mMax_power;
    private String mFuel_type;
    private String mProduct_description;
    private String mName;
    private String mPhone_number;
    private String mE_mail;
    private String mDelivery_address;

    public static BookHotelFragment newInstance() {
        return new BookHotelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(BookHotelViewModel.class);
        View root = inflater.inflate(R.layout.book_hotel_fragment, container, false);
        final EditText car_body = root.findViewById(R.id.car_body_edit);
        final EditText identification_number = root.findViewById(R.id.identification_number_edit);
        final EditText cilinders = root.findViewById(R.id.cilinders_edit);
        final EditText max_power = root.findViewById(R.id.max_power_edit);
        final EditText fuel_type = root.findViewById(R.id.fuel_type_edit);
        final EditText product_description = root.findViewById(R.id.product_description_edit);
        final EditText name = root.findViewById(R.id.name_edit);
        final EditText phone_number = root.findViewById(R.id.phone_number_edit);
        final EditText e_mail = root.findViewById(R.id.e_mail_edit);
        final EditText delivery_address = root.findViewById(R.id.delivery_edit);
        final Spinner country_spinner = root.findViewById(R.id.brand_spinner);
        final Spinner hotel_spinner = root.findViewById(R.id.model_spinner);
        final Spinner room_spinner = root.findViewById(R.id.year_spinner);
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_item, mViewModel.getCountries());
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country_spinner.setAdapter(brandAdapter);
        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = country_spinner.getSelectedItem().toString();
                List<Country> countryList = mViewModel.getCountryId(country);
                ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_spinner_item, mViewModel.getHotels(countryList.get(0)));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                hotel_spinner.setAdapter(modelAdapter);
                hotel_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String model = hotel_spinner.getSelectedItem().toString();
                        List<Hotel> hotelList = mViewModel.getHotelId(model);
                        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(getContext(),
                                android.R.layout.simple_spinner_item, mViewModel.getRooms(hotelList.get(0)));
                        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        room_spinner.setAdapter(yearAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mButton = root.findViewById(R.id.send_data);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mViewModel.getCarBody(car_body).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mCar_body = s;
                    }
                });
                mViewModel.getIdentificationNumber(identification_number).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mIdentification_number = s;
                    }
                });
                mViewModel.getIdentificationNumber(cilinders).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mCilinders = s;
                    }
                });
                mViewModel.getIdentificationNumber(max_power).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mMax_power = s;
                    }
                });
                mViewModel.getIdentificationNumber(fuel_type).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mFuel_type = s;
                    }
                });
                mViewModel.getIdentificationNumber(product_description).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mProduct_description = s;
                    }
                });
                mViewModel.getIdentificationNumber(name).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mName = s;
                    }
                });
                mViewModel.getIdentificationNumber(phone_number).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mPhone_number = s;
                    }
                });
                mViewModel.getIdentificationNumber(e_mail).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mE_mail = s;
                    }
                });
                mViewModel.getIdentificationNumber(delivery_address).observe(getActivity(), new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        mDelivery_address = s;
                    }
                });
                JSONObject formOutput = new JSONObject();
                try {
                    formOutput.put("make", "TODO");
                    formOutput.put("model", "TODO");
                    formOutput.put("year", "TODO");
                    formOutput.put("car_body", mCar_body);
                    formOutput.put("identification_number", mIdentification_number);
                    formOutput.put("cilinders", mCilinders);
                    formOutput.put("max_power", mMax_power);
                    formOutput.put("fuel_type", mFuel_type);
                    formOutput.put("product_description", mProduct_description);
                    formOutput.put("name", mName);
                    formOutput.put("phone_number", mPhone_number);
                    formOutput.put("e_mail", mE_mail);
                    formOutput.put("delivery_address", mDelivery_address);
                    JSONObject formObj = new JSONObject();
                    formObj.put("form_output", formOutput);
                    String jsonStr = formObj.toString();
                    System.out.println(jsonStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        final TextView textView = root.findViewById(R.id.select_model);
        mViewModel.getSelectModel(container).observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BookHotelViewModel.class);
        // TODO: Use the ViewModel
    }
}