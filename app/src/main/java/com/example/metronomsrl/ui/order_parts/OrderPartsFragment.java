package com.example.metronomsrl.ui.order_parts;

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
import android.widget.Toast;

import com.example.metronomsrl.R;
import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class OrderPartsFragment extends Fragment {

    private OrderPartsViewModel mViewModel;
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

    public static OrderPartsFragment newInstance() {
        return new OrderPartsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(OrderPartsViewModel.class);
        View root = inflater.inflate(R.layout.order_parts_fragment, container, false);
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
        final Spinner brand_spinner = root.findViewById(R.id.brand_spinner);
        final Spinner model_spinner = root.findViewById(R.id.model_spinner);
        final Spinner year_spinner = root.findViewById(R.id.year_spinner);
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_item, mViewModel.getBrands());
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand_spinner.setAdapter(brandAdapter);
        brand_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String brand = brand_spinner.getSelectedItem().toString();
                List<Brand> brandList = mViewModel.getBrandId(brand);
                ArrayAdapter<String> modelAdapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_spinner_item, mViewModel.getModels(brandList.get(0)));
                modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                model_spinner.setAdapter(modelAdapter);
                model_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String model = model_spinner.getSelectedItem().toString();
                        List<Model> modelList = mViewModel.getModelId(model);
                        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(getContext(),
                                android.R.layout.simple_spinner_item, mViewModel.getYears(modelList.get(0)));
                        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        year_spinner.setAdapter(yearAdapter);
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
        mViewModel = ViewModelProviders.of(this).get(OrderPartsViewModel.class);
        // TODO: Use the ViewModel
    }
}