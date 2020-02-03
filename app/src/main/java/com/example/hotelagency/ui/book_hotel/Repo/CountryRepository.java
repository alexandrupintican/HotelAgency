package com.example.hotelagency.ui.book_hotel.Repo;

import android.app.Application;
import android.os.AsyncTask;

import com.example.hotelagency.ui.book_hotel.DAO.CountryDAO;
import com.example.hotelagency.ui.book_hotel.Entities.Country;
import com.example.hotelagency.ui.book_hotel.HotelDatabase;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CountryRepository {
    private CountryDAO countryDao;
    private static CountryRepository instance;
    private List<String> allCountries;

    public CountryRepository(Application application){
        HotelDatabase database = HotelDatabase.getInstance(application);
        countryDao = database.countryDao();
        allCountries = Collections.emptyList();
        try{
            allCountries = new GetAllCountriesAsync(countryDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized CountryRepository getInstance(Application application){
        if(instance == null)
            instance = new CountryRepository(application);
        return instance;
    }

    public List<String> getAllCountries(){
        return allCountries;
    }

    public List<Country> getCountryIds(String brand) {
        List<Country> ids = Collections.emptyList();
        try{
            ids = new GetCountryIdAsync(countryDao).execute(brand).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }

    private static class GetCountryIdAsync extends AsyncTask<String, Void, List<Country>> {
        private CountryDAO countryDao;

        private GetCountryIdAsync(CountryDAO countryDao) { this.countryDao = countryDao; }

        @Override
        protected List<Country> doInBackground(String... strings) {
            return countryDao.getCountryObject(strings[0]);
        }
    }

    private static class GetAllCountriesAsync extends AsyncTask<Void, Void, List<String>> {
        private CountryDAO countryDao;

        private GetAllCountriesAsync(CountryDAO countryDao) { this.countryDao = countryDao; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return countryDao.getAllCountries();
        }
    }

    public void insert(Country country) {
        new InsertCountryAsync(countryDao).execute(country);
    }

    private static class InsertCountryAsync extends AsyncTask<Country,Void,Void> {

        private CountryDAO countryDao;

        private InsertCountryAsync(CountryDAO countryDao) {
            this.countryDao = countryDao;
        }

        @Override
        protected Void doInBackground(Country... countries) {
            countryDao.insert(countries[0]);
            return null;
        }
    }


}
