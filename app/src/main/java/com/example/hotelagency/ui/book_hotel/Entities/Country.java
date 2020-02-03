package com.example.hotelagency.ui.book_hotel.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "country_table",
        indices = {@Index("country"),@Index(value = {"id", "country"},unique = true)})
public class Country {

    @PrimaryKey
    public int id;
    public String country;

    public Country(int id, String country) {
        this.id = id;
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return country;
    }
}
