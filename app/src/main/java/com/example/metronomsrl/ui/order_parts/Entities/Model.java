package com.example.metronomsrl.ui.order_parts.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "model_table",
        indices = {@Index("model"),@Index(value = {"id", "brand_id"}, unique = true)},

        foreignKeys = @ForeignKey(entity = Brand.class,
        parentColumns = "id",
        childColumns = "brand_id",
        onDelete = ForeignKey.CASCADE))
public class Model {

    @PrimaryKey
    public int id;
    public int brand_id;
    public String model;

    public Model(int id, int brand_id, String model) {
        this.id = id;
        this.brand_id = brand_id;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getBrandId() {
        return brand_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return model;
    }
}
