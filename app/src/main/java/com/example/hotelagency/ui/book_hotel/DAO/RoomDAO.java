package com.example.hotelagency.ui.book_hotel.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hotelagency.ui.book_hotel.Entities.Room;

import java.util.List;

@Dao
public interface RoomDAO {
    @Insert
    void insert(Room room);

    @Update
    void update(Room room);

    @Delete
    void delete(Room room);

    @Query("SELECT room FROM Room")
    List<String> getAllRooms();

    @Query("SELECT room FROM Room WHERE room_id = :roomId")
    List<String> getRoomsForHotel(int roomId);

    @Query("SELECT * FROM Room WHERE room = :room")
    List<Room> getRoomObject(String room);
}
