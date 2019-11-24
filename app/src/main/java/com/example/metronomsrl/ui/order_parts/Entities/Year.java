package com.example.metronomsrl.ui.order_parts.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "year_table",
        indices = {@Index("year"),@Index(value = {"id", "model_id"},unique = true)},

        foreignKeys = @ForeignKey(entity = Model.class,
        parentColumns = "id",
        childColumns = "model_id",
        onDelete = ForeignKey.CASCADE))
public class Year {

    @PrimaryKey
    public int id;
    public int model_id;
    public String year;

    public Year(int id, int model_id, String year) {
        this.id = id;
        this.model_id = model_id;
        this.year = year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public int getModelId() {
        return model_id;
    }

    public String getYear() {
        return year;
    }

    public void setModel(String year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return year;
    }
}
