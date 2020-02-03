package com.example.hotelagency.ui.book_hotel.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "hotel_table",
        indices = {@Index("hotel"),@Index(value = {"id", "country_id"}, unique = true)},

        foreignKeys = @ForeignKey(entity = Country.class,
        parentColumns = "id",
        childColumns = "country_id",
        onDelete = ForeignKey.CASCADE))
public class Hotel {

    @PrimaryKey
    public int id;
    public int countryId;
    public String hotel;

    public Hotel(int id, int countryId, String hotel) {
        this.id = id;
        this.countryId = countryId;
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setHotelId(int id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return hotel;
    }
}
