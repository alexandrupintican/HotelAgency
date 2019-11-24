package com.example.metronomsrl.ui.order_parts.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;

import java.util.List;

@Dao
public interface ModelDAO {

    @Insert
    void insert(Model model);

    @Update
    void update(Model model);

    @Delete
    void delete(Model model);

    @Query("SELECT model FROM model_table")
    List<String> getAllModels();

    @Query("SELECT model FROM model_table WHERE brand_id = :brandId")
    List<String> getModelsForBrand(int brandId);

    @Query("SELECT * FROM model_table WHERE model = :model")
    List<Model> getModelObject(String model);

}
