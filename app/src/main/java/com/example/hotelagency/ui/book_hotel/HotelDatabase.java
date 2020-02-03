package com.example.hotelagency.ui.book_hotel;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hotelagency.ui.book_hotel.DAO.CountryDAO;
import com.example.hotelagency.ui.book_hotel.DAO.HotelDAO;
import com.example.hotelagency.ui.book_hotel.DAO.RoomDAO;
import com.example.hotelagency.ui.book_hotel.Entities.Country;
import com.example.hotelagency.ui.book_hotel.Entities.Hotel;
import com.example.hotelagency.ui.book_hotel.Entities.Room;

@Database(entities = {Country.class, Hotel.class, Room.class}, version = 4)
public abstract class HotelDatabase extends RoomDatabase {

    private static HotelDatabase instance;
    public abstract CountryDAO countryDao();
    public abstract HotelDAO hotelDao();
    public abstract RoomDAO roomDao();

    public static synchronized HotelDatabase getInstance(Context context){
        if(instance == null) {
            instance = androidx.room.Room.databaseBuilder(context.getApplicationContext(),
                    HotelDatabase.class, "hotel_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private CountryDAO countryDao;
        private HotelDAO hotelDao;
        private RoomDAO roomDao;

        public PopulateDbAsyncTask(HotelDatabase db) {
            countryDao = db.countryDao();
            hotelDao = db.hotelDao();
            roomDao = db.roomDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            countryDao.insert(new Country(1, "Ariel"));
            hotelDao.insert(new Hotel(1,1, "Atom"));
            roomDao.insert(new Room(1, 1, "2000"));
            roomDao.insert(new Room(2, 1, "2001"));
            roomDao.insert(new Room(3, 1, "2002"));
            roomDao.insert(new Room(4, 1, "2003"));
            roomDao.insert(new Room(5, 1, "2004"));
            roomDao.insert(new Room(6, 1, "2005"));

            countryDao.insert(new Country(2, "Dacia"));
            hotelDao.insert(new Hotel(2,2, "Logan 1.4 MCV"));
            roomDao.insert(new Room(7, 2, "2008"));
            hotelDao.insert(new Hotel(3,2, "Logan 1.4 MPI"));
            roomDao.insert(new Room(8, 3, "2006"));
            roomDao.insert(new Room(9, 3, "2007"));
            roomDao.insert(new Room(10, 3, "2008"));
            hotelDao.insert(new Hotel(4,2, "Logan 1.5 dCi"));
            roomDao.insert(new Room(11, 4, "2006"));
            roomDao.insert(new Room(12, 4, "2008"));
            roomDao.insert(new Room(13, 4, "2009"));
            hotelDao.insert(new Hotel(5,2, "Logan 1.5 dCi MCV"));
            hotelDao.insert(new Hotel(6,2, "Logan 1.6"));
            hotelDao.insert(new Hotel(7,2, "Logan 1.6 MCV"));
            hotelDao.insert(new Hotel(8,2, "Logan MCV 1.4"));
            hotelDao.insert(new Hotel(9,2, "Logan MCV 1.5 dCi"));
            hotelDao.insert(new Hotel(10,2, "Logan MCV 1.6"));
            hotelDao.insert(new Hotel(11,2, "Logan MCV 1.6 MPI LPG"));
            hotelDao.insert(new Hotel(12,2, "Sandero 1.4"));
            hotelDao.insert(new Hotel(13,2, "Sandero 1.6 MPI "));
            hotelDao.insert(new Hotel(14,2, "Supernova"));



            return null;
        }
    }
}

