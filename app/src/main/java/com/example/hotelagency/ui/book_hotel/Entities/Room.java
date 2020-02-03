package com.example.hotelagency.ui.book_hotel.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "room_table",
        indices = {@Index("year"),@Index(value = {"id", "hotel_id"},unique = true)},

        foreignKeys = @ForeignKey(entity = Hotel.class,
        parentColumns = "id",
        childColumns = "hotel_id",
        onDelete = ForeignKey.CASCADE))
public class Room {

    @PrimaryKey
    public int id;
    public int hotelId;
    public String room;

    public Room(int id, int hotelId, String room) {
        this.id = id;
        this.hotelId = hotelId;
        this.room = room;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return id;
    }

    public void setRoomId() { this.id = id; }

    public String getYear() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @NonNull
    @Override
    public String toString() {
        // A value you want to be displayed in the spinner item.
        return room;
    }
}
