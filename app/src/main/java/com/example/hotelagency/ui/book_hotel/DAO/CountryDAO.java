package com.example.hotelagency.ui.book_hotel.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hotelagency.ui.book_hotel.Entities.Country;

import java.util.List;

@Dao
public interface CountryDAO {

    @Insert
    void insert(Country country);

    @Update
    void update(Country country);

    @Delete
    void delete(Country country);

    @Query("SELECT country FROM Country")
    List<String> getAllCountries();

    @Query("SELECT * FROM Country WHERE country = :country")
    List<Country> getCountryObject(String country);

}
