package com.example.hotelagency.ui.book_hotel.Repo;

import android.app.Application;
import android.os.AsyncTask;

import com.example.hotelagency.ui.book_hotel.DAO.HotelDAO;
import com.example.hotelagency.ui.book_hotel.Entities.Country;
import com.example.hotelagency.ui.book_hotel.Entities.Hotel;
import com.example.hotelagency.ui.book_hotel.HotelDatabase;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class HotelRepository {
    private HotelDAO hotelDao;
    private static HotelRepository instance;
    private List<String> allHotels;

    public HotelRepository(Application application){
        HotelDatabase database = HotelDatabase.getInstance(application);
        hotelDao = database.hotelDao();
        allHotels = Collections.emptyList();
        try{
            allHotels = new GetAllHotelsAsync(hotelDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized HotelRepository getInstance(Application application){
        if(instance == null)
            instance = new HotelRepository(application);
        return instance;
    }

    public List<String> getAllHotels(){
        return allHotels;
    }

    private static class GetAllHotelsAsync extends AsyncTask<Void, Void, List<String>> {
        private HotelDAO hotelDao;

        private GetAllHotelsAsync(HotelDAO hotelDAO) { this.hotelDao = hotelDAO; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return hotelDao.getAllHotels();
        }
    }

    public void insert(Hotel hotel) {
        new InsertHotelAsync(hotelDao).execute(hotel);
    }

    public void update(Hotel hotel) {
        new UpdateHotelAsync(hotelDao).execute(hotel);
    }

    public void delete(Hotel hotel) {
        new DeleteHotelAsync(hotelDao).execute(hotel);
    }

    public List<Hotel> getHotelIds(String hotel) {
        List<Hotel> ids = Collections.emptyList();
        try{
            ids = new GetHotelIdAsync(hotelDao).execute(hotel).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }
    private static class GetHotelIdAsync extends AsyncTask<String, Void, List<Hotel>> {
        private HotelDAO hotelDao;

        private GetHotelIdAsync(HotelDAO hotelDao) { this.hotelDao = hotelDao; }

        @Override
        protected List<Hotel> doInBackground(String... strings) {
            return hotelDao.getHotelObject(strings[0]);
        }
    }

    public List<String> getHotelsForCountry(Country country){
        List<String> hotels = Collections.emptyList();
        try{
            hotels = new GetHotelsForCountryAsync(hotelDao).execute(country).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    private static class InsertHotelAsync extends AsyncTask<Hotel,Void,Void> {

        private HotelDAO hotelDao;

        private InsertHotelAsync(HotelDAO hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.insert(hotels[0]);
            return null;
        }
    }
    private static class UpdateHotelAsync extends AsyncTask<Hotel,Void,Void> {

        private HotelDAO hotelDao;

        private UpdateHotelAsync(HotelDAO hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.update(hotels[0]);
            return null;
        }
    }
    private static class DeleteHotelAsync extends AsyncTask<Hotel,Void,Void> {

        private HotelDAO hotelDao;

        private DeleteHotelAsync(HotelDAO hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected Void doInBackground(Hotel... hotels) {
            hotelDao.delete(hotels[0]);
            return null;
        }
    }

    private static class GetHotelsForCountryAsync extends AsyncTask<Country,Void,List<String>> {

        private HotelDAO hotelDao;

        private GetHotelsForCountryAsync(HotelDAO hotelDao) {
            this.hotelDao = hotelDao;
        }

        @Override
        protected List<String> doInBackground(Country... countries) {
            return hotelDao.getHotelsForCountry(countries[0].getId());
        }
    }


}
