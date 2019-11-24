package com.example.metronomsrl.ui.order_parts;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.metronomsrl.ui.order_parts.DAO.BrandDAO;
import com.example.metronomsrl.ui.order_parts.DAO.ModelDAO;
import com.example.metronomsrl.ui.order_parts.DAO.YearDAO;
import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;
import com.example.metronomsrl.ui.order_parts.Entities.Year;

@Database(entities = {Brand.class, Model.class, Year.class}, version = 4)
public abstract class CarDatabase extends RoomDatabase {

    private static CarDatabase instance;
    public abstract BrandDAO brandDao();
    public abstract ModelDAO modelDao();
    public abstract YearDAO yearDao();

    public static synchronized CarDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CarDatabase.class, "car_database")
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

        private BrandDAO brandDao;
        private ModelDAO modelDao;
        private YearDAO yearDao;

        public PopulateDbAsyncTask(CarDatabase db) {
            brandDao = db.brandDao();
            modelDao = db.modelDao();
            yearDao = db.yearDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            brandDao.insert(new Brand(1, "Ariel"));
            modelDao.insert(new Model(1,1, "Atom"));
            yearDao.insert(new Year(1, 1, "2000"));
            yearDao.insert(new Year(2, 1, "2001"));
            yearDao.insert(new Year(3, 1, "2002"));
            yearDao.insert(new Year(4, 1, "2003"));
            yearDao.insert(new Year(5, 1, "2004"));
            yearDao.insert(new Year(6, 1, "2005"));

            brandDao.insert(new Brand(2, "Dacia"));
            modelDao.insert(new Model(2,2, "Logan 1.4 MCV"));
            yearDao.insert(new Year(7, 2, "2008"));
            modelDao.insert(new Model(3,2, "Logan 1.4 MPI"));
            yearDao.insert(new Year(8, 3, "2006"));
            yearDao.insert(new Year(9, 3, "2007"));
            yearDao.insert(new Year(10, 3, "2008"));
            modelDao.insert(new Model(4,2, "Logan 1.5 dCi"));
            yearDao.insert(new Year(11, 4, "2006"));
            yearDao.insert(new Year(12, 4, "2008"));
            yearDao.insert(new Year(13, 4, "2009"));
            modelDao.insert(new Model(5,2, "Logan 1.5 dCi MCV"));
            modelDao.insert(new Model(6,2, "Logan 1.6"));
            modelDao.insert(new Model(7,2, "Logan 1.6 MCV"));
            modelDao.insert(new Model(8,2, "Logan MCV 1.4"));
            modelDao.insert(new Model(9,2, "Logan MCV 1.5 dCi"));
            modelDao.insert(new Model(10,2, "Logan MCV 1.6"));
            modelDao.insert(new Model(11,2, "Logan MCV 1.6 MPI LPG"));
            modelDao.insert(new Model(12,2, "Sandero 1.4"));
            modelDao.insert(new Model(13,2, "Sandero 1.6 MPI "));
            modelDao.insert(new Model(14,2, "Supernova"));



            return null;
        }
    }
}

