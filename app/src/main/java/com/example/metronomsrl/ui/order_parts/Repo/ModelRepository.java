package com.example.metronomsrl.ui.order_parts.Repo;

import android.app.Application;
import android.os.AsyncTask;

import com.example.metronomsrl.ui.order_parts.CarDatabase;
import com.example.metronomsrl.ui.order_parts.DAO.BrandDAO;
import com.example.metronomsrl.ui.order_parts.DAO.ModelDAO;
import com.example.metronomsrl.ui.order_parts.DAO.YearDAO;
import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;
import com.example.metronomsrl.ui.order_parts.Entities.Year;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelRepository {
    private ModelDAO modelDao;
    private static ModelRepository instance;
    private List<String> allModels;

    public ModelRepository(Application application){
        CarDatabase database = CarDatabase.getInstance(application);
        modelDao = database.modelDao();
        allModels = Collections.emptyList();
        try{
            allModels = new GetAllModelsAsync(modelDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ModelRepository getInstance(Application application){
        if(instance == null)
            instance = new ModelRepository(application);
        return instance;
    }

    public List<String> getAllModels(){
        return allModels;
    }

    private static class GetAllModelsAsync extends AsyncTask<Void, Void, List<String>> {
        private ModelDAO modelDao;

        private GetAllModelsAsync(ModelDAO modelDAO) { this.modelDao = modelDAO; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return modelDao.getAllModels();
        }
    }

    public void insert(Model model) {
        new InsertModelAsync(modelDao).execute(model);
    }

    public void update(Model model) {
        new UpdateModelAsync(modelDao).execute(model);
    }

    public void delete(Model model) {
        new DeleteModelAsync(modelDao).execute(model);
    }

    public List<Model> getModelIds(String model) {
        List<Model> ids = Collections.emptyList();
        try{
            ids = new GetModelIdAsync(modelDao).execute(model).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }
    private static class GetModelIdAsync extends AsyncTask<String, Void, List<Model>> {
        private ModelDAO modelDao;

        private GetModelIdAsync(ModelDAO modelDao) { this.modelDao = modelDao; }

        @Override
        protected List<Model> doInBackground(String... strings) {
            return modelDao.getModelObject(strings[0]);
        }
    }

    public List<String> getModelsForBrand(Brand brand){
        List<String> models = Collections.emptyList();
        try{
            models = new GetModelsForBrandAsync(modelDao).execute(brand).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return models;
    }

    private static class InsertModelAsync extends AsyncTask<Model,Void,Void> {

        private ModelDAO modelDao;

        private InsertModelAsync(ModelDAO modelDao) {
            this.modelDao = modelDao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            modelDao.insert(models[0]);
            return null;
        }
    }
    private static class UpdateModelAsync extends AsyncTask<Model,Void,Void> {

        private ModelDAO modelDao;

        private UpdateModelAsync(ModelDAO modelDao) {
            this.modelDao = modelDao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            modelDao.update(models[0]);
            return null;
        }
    }
    private static class DeleteModelAsync extends AsyncTask<Model,Void,Void> {

        private ModelDAO modelDao;

        private DeleteModelAsync(ModelDAO modelDao) {
            this.modelDao = modelDao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            modelDao.delete(models[0]);
            return null;
        }
    }

    private static class GetModelsForBrandAsync extends AsyncTask<Brand,Void,List<String>> {

        private ModelDAO modelDao;

        private GetModelsForBrandAsync(ModelDAO modelDao) {
            this.modelDao = modelDao;
        }

        @Override
        protected List<String> doInBackground(Brand... brands) {
            return modelDao.getModelsForBrand(brands[0].getId());
        }
    }


}
