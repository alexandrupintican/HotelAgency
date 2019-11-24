package com.example.metronomsrl.ui.order_parts.Repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.room.Dao;

import com.example.metronomsrl.ui.order_parts.CarDatabase;
import com.example.metronomsrl.ui.order_parts.DAO.BrandDAO;
import com.example.metronomsrl.ui.order_parts.Entities.Brand;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BrandRepository {
    private BrandDAO brandDao;
    private static BrandRepository instance;
    private List<String> allBrands;

    public BrandRepository(Application application){
        CarDatabase database = CarDatabase.getInstance(application);
        brandDao = database.brandDao();
        allBrands = Collections.emptyList();
        try{
            allBrands = new GetAllBrandsAsync(brandDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized BrandRepository getInstance(Application application){
        if(instance == null)
            instance = new BrandRepository(application);
        return instance;
    }

    public List<String> getAllBrands(){
        return allBrands;
    }

    public List<Brand> getBrandIds(String brand) {
        List<Brand> ids = Collections.emptyList();
        try{
            ids = new GetBrandIdAsync(brandDao).execute(brand).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }

    private static class GetBrandIdAsync extends AsyncTask<String, Void, List<Brand>> {
        private BrandDAO brandDao;

        private GetBrandIdAsync(BrandDAO brandDao) { this.brandDao = brandDao; }

        @Override
        protected List<Brand> doInBackground(String... strings) {
            return brandDao.getBrandObject(strings[0]);
        }
    }

    private static class GetAllBrandsAsync extends AsyncTask<Void, Void, List<String>> {
        private BrandDAO brandDao;

        private GetAllBrandsAsync(BrandDAO brandDao) { this.brandDao = brandDao; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return brandDao.getAllBrands();
        }
    }

    public void insert(Brand brand) {
        new InsertBrandAsync(brandDao).execute(brand);
    }

    private static class InsertBrandAsync extends AsyncTask<Brand,Void,Void> {

        private BrandDAO brandDao;

        private InsertBrandAsync(BrandDAO brandDao) {
            this.brandDao = brandDao;
        }

        @Override
        protected Void doInBackground(Brand... brands) {
            brandDao.insert(brands[0]);
            return null;
        }
    }


}
