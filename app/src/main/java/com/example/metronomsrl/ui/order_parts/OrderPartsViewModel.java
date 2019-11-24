package com.example.metronomsrl.ui.order_parts;


import android.app.Application;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.metronomsrl.R;
import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;
import com.example.metronomsrl.ui.order_parts.Entities.Year;
import com.example.metronomsrl.ui.order_parts.Repo.BrandRepository;
import com.example.metronomsrl.ui.order_parts.Repo.ModelRepository;
import com.example.metronomsrl.ui.order_parts.Repo.YearRepository;

import java.util.List;


public class OrderPartsViewModel extends AndroidViewModel {
    private MutableLiveData<String> mSelectModel;
    private MutableLiveData<String> mCarBody;
    private MutableLiveData<String> mIdentificationNumber;
    private MutableLiveData<String> mCilinders;
    private MutableLiveData<String> mMaxPower;
    private MutableLiveData<String> mFuelType;
    private MutableLiveData<String> mProductDescription;
    private MutableLiveData<String> mName;
    private MutableLiveData<String> mPhoneNumber;
    private MutableLiveData<String> mEmail;
    private MutableLiveData<String> mDeliveryAddress;
    private BrandRepository brandRepo;
    private ModelRepository modelRepo;
    private YearRepository yearRepo;
    private List<String> brands;
    private List<String> models;
    private List<String> years;



    public OrderPartsViewModel(@NonNull Application application) {
        super(application);
        brandRepo = new BrandRepository(application);
        modelRepo = new ModelRepository(application);
        yearRepo = new YearRepository(application);
        brands = brandRepo.getAllBrands();
        models = modelRepo.getAllModels();
        years = yearRepo.getAllYears();
        mSelectModel = new MutableLiveData<>();
        mCarBody = new MutableLiveData<>();
        mIdentificationNumber = new MutableLiveData<>();
        mCilinders = new MutableLiveData<>();
        mMaxPower = new MutableLiveData<>();
        mFuelType = new MutableLiveData<>();
        mProductDescription = new MutableLiveData<>();
        mName = new MutableLiveData<>();
        mPhoneNumber = new MutableLiveData<>();
        mEmail = new MutableLiveData<>();
        mDeliveryAddress = new MutableLiveData<>();
    }
    public List<String> getBrands() {
        return brandRepo.getAllBrands();
    }

    public List<String> getModels(Brand brand) {
        return modelRepo.getModelsForBrand(brand);
    }

    public List<Brand> getBrandId(String brand) {
        return brandRepo.getBrandIds(brand);
    }

    public List<Year> getYearId(String year) {
        return yearRepo.getYearIds(year);
    }

    public List<Model> getModelId(String model) {
        return modelRepo.getModelIds(model);
    }

    public List<String> getYears(Model model){
        return yearRepo.getYearsForModel(model);
    }

    public LiveData<String> getSelectModel(ViewGroup container) {
        mSelectModel.setValue(container.getResources().getString(R.string.select_model));
        return mSelectModel;
    }
    public LiveData<String> getCarBody(EditText editText) {
        mCarBody.setValue(editText.getText().toString());
        return mCarBody;
    }

    public LiveData<String> getIdentificationNumber(EditText editText) {
        mIdentificationNumber.setValue(editText.getText().toString());
        return mIdentificationNumber;
    }

    public LiveData<String> getCilinders(EditText editText) {
        mCilinders.setValue(editText.getText().toString());
        return mCilinders;
    }

    public LiveData<String> getMaxPower(EditText editText) {
        mMaxPower.setValue(editText.getText().toString());
        return mMaxPower;
    }

    public LiveData<String> getFuelType(EditText editText) {
        mFuelType.setValue(editText.getText().toString());
        return mFuelType;
    }

    public LiveData<String> getProductDescription(EditText editText) {
        mProductDescription.setValue(editText.getText().toString());
        return mProductDescription;
    }

    public LiveData<String> getNameField(EditText editText) {
        mName.setValue(editText.getText().toString());
        return mName;
    }

    public LiveData<String> getPhoneNumber(EditText editText) {
        mPhoneNumber.setValue(editText.getText().toString());
        return mPhoneNumber;
    }

    public LiveData<String> getEmail(EditText editText) {
        mEmail.setValue(editText.getText().toString());
        return mEmail;
    }

    public LiveData<String> getDeliveryAddress(EditText editText) {
        mDeliveryAddress.setValue(editText.getText().toString());
        return mDeliveryAddress;
    }
}
