package com.example.metronomsrl.ui.order_parts.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.metronomsrl.ui.order_parts.Entities.Brand;

import java.util.List;

@Dao
public interface BrandDAO {

    @Insert
    void insert(Brand brand);

    @Update
    void update(Brand brand);

    @Delete
    void delete(Brand brand);

    @Query("SELECT brand FROM brand_table")
    List<String> getAllBrands();

    @Query("SELECT * FROM brand_table WHERE brand = :brand")
    List<Brand> getBrandObject(String brand);

}
