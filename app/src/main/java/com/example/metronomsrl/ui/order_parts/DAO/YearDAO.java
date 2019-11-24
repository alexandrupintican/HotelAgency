package com.example.metronomsrl.ui.order_parts.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.metronomsrl.ui.order_parts.Entities.Brand;
import com.example.metronomsrl.ui.order_parts.Entities.Model;
import com.example.metronomsrl.ui.order_parts.Entities.Year;

import java.util.List;

@Dao
public interface YearDAO {
    @Insert
    void insert(Year year);

    @Update
    void update(Year year);

    @Delete
    void delete(Year year);

    @Query("SELECT year FROM year_table")
    List<String> getAllYears();

    @Query("SELECT year FROM year_table WHERE model_id = :modelId")
    List<String> getYearForModel(int modelId);

    @Query("SELECT * FROM year_table WHERE year = :year")
    List<Year> getYearObject(String year);
}
