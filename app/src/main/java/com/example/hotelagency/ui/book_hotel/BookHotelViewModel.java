package com.example.hotelagency.ui.book_hotel;


import android.app.Application;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hotelagency.R;
import com.example.hotelagency.ui.book_hotel.Entities.Country;
import com.example.hotelagency.ui.book_hotel.Entities.Hotel;
import com.example.hotelagency.ui.book_hotel.Entities.Room;
import com.example.hotelagency.ui.book_hotel.Repo.CountryRepository;
import com.example.hotelagency.ui.book_hotel.Repo.HotelRepository;
import com.example.hotelagency.ui.book_hotel.Repo.RoomRepository;

import java.util.List;


public class BookHotelViewModel extends AndroidViewModel {
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
    private CountryRepository countryRepository;
    private HotelRepository hotelRepository;
    private RoomRepository roomRepository;
    private List<String> countries;
    private List<String> hotels;
    private List<String> rooms;



    public BookHotelViewModel(@NonNull Application application) {
        super(application);
        countryRepository = new CountryRepository(application);
        hotelRepository = new HotelRepository(application);
        roomRepository = new RoomRepository(application);
        countries = countryRepository.getAllCountries();
        hotels = hotelRepository.getAllHotels();
        rooms = roomRepository.getAllRooms();
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
    public List<String> getCountries() {
        return countryRepository.getAllCountries();
    }

    public List<String> getHotels(Country country) {
        return hotelRepository.getHotelsForCountry(country);
    }

    public List<Country> getCountryId(String country) {
        return countryRepository.getCountryIds(country);
    }

    public List<Room> getRoomId(String room) {
        return roomRepository.getRoomIds(room);
    }

    public List<Hotel> getHotelId(String hotel) {
        return hotelRepository.getHotelIds(hotel);
    }

    public List<String> getRooms(Hotel hotel){
        return roomRepository.getRoomsForHotel(hotel);
    }

    //TODO
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
