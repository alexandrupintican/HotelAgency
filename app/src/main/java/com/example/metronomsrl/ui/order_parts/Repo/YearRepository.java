package com.example.metronomsrl.ui.order_parts.Repo;

import android.app.Application;
import android.os.AsyncTask;

import com.example.metronomsrl.ui.order_parts.CarDatabase;
import com.example.metronomsrl.ui.order_parts.DAO.ModelDAO;
import com.example.metronomsrl.ui.order_parts.DAO.YearDAO;
import com.example.metronomsrl.ui.order_parts.Entities.Model;
import com.example.metronomsrl.ui.order_parts.Entities.Year;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class YearRepository {
    private YearDAO yearDao;
    private static YearRepository instance;
    private List<String> allYears;

    public YearRepository(Application application){
        CarDatabase database = CarDatabase.getInstance(application);
        yearDao = database.yearDao();
        allYears = Collections.emptyList();
        try{
            allYears = new YearRepository.GetAllYearsAsync(yearDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized YearRepository getInstance(Application application){
        if(instance == null)
            instance = new YearRepository(application);
        return instance;
    }

    public List<String> getAllYears(){
        return allYears;
    }

    public List<Year> getYearIds(String year) {
        List<Year> ids = Collections.emptyList();
        try{
            ids = new GetYearIdAsync(yearDao).execute(year).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }

    private static class GetYearIdAsync extends AsyncTask<String, Void, List<Year>> {
        private YearDAO yearDao;

        private GetYearIdAsync(YearDAO yearDao) { this.yearDao = yearDao; }

        @Override
        protected List<Year> doInBackground(String... strings) {
            return yearDao.getYearObject(strings[0]);
        }
    }

    private static class GetAllYearsAsync extends AsyncTask<Void, Void, List<String>> {
        private YearDAO yearDao;

        private GetAllYearsAsync(YearDAO yearDao) { this.yearDao = yearDao; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return yearDao.getAllYears();
        }
    }

    public void insert(Year year) {
        new InsertYearAsync(yearDao).execute(year);
    }

    public void update(Year year) {
        new UpdateYearAsync(yearDao).execute(year);
    }

    public void delete(Year year) {
        new DeleteYearAsync(yearDao).execute(year);
    }

    public List<String> getYearsForModel(Model model){
        List<String> years = Collections.emptyList();
        try{
            years = new YearRepository.GetYearForModelsAsync(yearDao).execute(model).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return years;
    }

    private static class InsertYearAsync extends AsyncTask<Year,Void,Void> {

        private YearDAO yearDao;

        private InsertYearAsync(YearDAO yearDao) {
            this.yearDao = yearDao;
        }

        @Override
        protected Void doInBackground(Year... years) {
            yearDao.insert(years[0]);
            return null;
        }
    }
    private static class UpdateYearAsync extends AsyncTask<Year,Void,Void> {

        private YearDAO yearDao;

        private UpdateYearAsync(YearDAO yearDao) {
            this.yearDao = yearDao;
        }

        @Override
        protected Void doInBackground(Year... years) {
            yearDao.update(years[0]);
            return null;
        }
    }
    private static class DeleteYearAsync extends AsyncTask<Year,Void,Void> {

        private YearDAO yearDao;

        private DeleteYearAsync(YearDAO yearDao) {
            this.yearDao = yearDao;
        }

        @Override
        protected Void doInBackground(Year... years) {
            yearDao.delete(years[0]);
            return null;
        }
    }
    private static class GetYearForModelsAsync extends AsyncTask<Model,Void,List<String>> {

        private YearDAO yearDao;

        private GetYearForModelsAsync(YearDAO yearDao) {
            this.yearDao = yearDao;
        }


        @Override
        protected List<String> doInBackground(Model... models) {
            return yearDao.getYearForModel(models[0].getId());
        }
    }


}