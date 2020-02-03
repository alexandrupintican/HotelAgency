package com.example.hotelagency.ui.book_hotel.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.hotelagency.ui.book_hotel.Entities.Hotel;

import java.util.List;

@Dao
public interface HotelDAO {

    @Insert
    void insert(Hotel hotel);

    @Update
    void update(Hotel hotel);

    @Delete
    void delete(Hotel hotel);

    @Query("SELECT hotel FROM Hotel")
    List<String> getAllHotels();

    @Query("SELECT hotel FROM Hotel WHERE hotel_id = :hotelId")
    List<String> getHotelsForCountry(int hotelId);

    @Query("SELECT * FROM Hotel WHERE hotel = :hotel")
    List<Hotel> getHotelObject(String hotel);

}
