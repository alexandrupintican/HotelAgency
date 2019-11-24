package com.example.metronomsrl.ui.order_parts.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "brand_table",
        indices = {@Index("brand"),@Index(value = {"id", "brand"},unique = true)})
public class Brand {

    @PrimaryKey
    public int id;
    public String brand;

    public Brand(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return brand;
    }
}
