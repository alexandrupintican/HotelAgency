package com.example.hotelagency.ui.book_hotel.Repo;

import android.app.Application;
import android.os.AsyncTask;

import com.example.hotelagency.ui.book_hotel.DAO.RoomDAO;
import com.example.hotelagency.ui.book_hotel.Entities.Hotel;
import com.example.hotelagency.ui.book_hotel.Entities.Room;
import com.example.hotelagency.ui.book_hotel.HotelDatabase;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RoomRepository {
    private RoomDAO roomDao;
    private static RoomRepository instance;
    private List<String> allRooms;

    public RoomRepository(Application application){
        HotelDatabase database = HotelDatabase.getInstance(application);
        roomDao = database.roomDao();
        allRooms = Collections.emptyList();
        try{
            allRooms = new RoomRepository.GetAllRoomsAsync(roomDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized RoomRepository getInstance(Application application){
        if(instance == null)
            instance = new RoomRepository(application);
        return instance;
    }

    public List<String> getAllRooms(){
        return allRooms;
    }

    public List<Room> getRoomIds(String room) {
        List<Room> ids = Collections.emptyList();
        try{
            ids = new GetRoomIdAsync(roomDao).execute(room).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ids;
    }

    private static class GetRoomIdAsync extends AsyncTask<String, Void, List<Room>> {
        private RoomDAO roomDao;

        private GetRoomIdAsync(RoomDAO roomDao) { this.roomDao = roomDao; }

        @Override
        protected List<Room> doInBackground(String... strings) {
            return roomDao.getRoomObject(strings[0]);
        }
    }

    private static class GetAllRoomsAsync extends AsyncTask<Void, Void, List<String>> {
        private RoomDAO roomDao;

        private GetAllRoomsAsync(RoomDAO roomDao) { this.roomDao = roomDao; }

        @Override
        protected List<String> doInBackground(Void... voids) {
            return roomDao.getAllRooms();
        }
    }

    public void insert(Room room) {
        new InsertRoomAsync(roomDao).execute(room);
    }

    public void update(Room room) {
        new UpdateRoomAsync(roomDao).execute(room);
    }

    public void delete(Room room) {
        new DeleteRoomAsync(roomDao).execute(room);
    }

    public List<String> getRoomsForHotel(Hotel hotel){
        List<String> rooms = Collections.emptyList();
        try{
            rooms = new RoomRepository.GetRoomsForHotelAsync(roomDao).execute(hotel).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    private static class InsertRoomAsync extends AsyncTask<Room,Void,Void> {

        private RoomDAO roomDao;

        private InsertRoomAsync(RoomDAO roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Room... rooms) {
            roomDao.insert(rooms[0]);
            return null;
        }
    }
    private static class UpdateRoomAsync extends AsyncTask<Room,Void,Void> {

        private RoomDAO roomDao;

        private UpdateRoomAsync(RoomDAO roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Room... rooms) {
            roomDao.update(rooms[0]);
            return null;
        }
    }
    private static class DeleteRoomAsync extends AsyncTask<Room,Void,Void> {

        private RoomDAO roomDao;

        private DeleteRoomAsync(RoomDAO roomDao) {
            this.roomDao = roomDao;
        }

        @Override
        protected Void doInBackground(Room... rooms) {
            roomDao.delete(rooms[0]);
            return null;
        }
    }
    private static class GetRoomsForHotelAsync extends AsyncTask<Hotel,Void,List<String>> {

        private RoomDAO roomDao;

        private GetRoomsForHotelAsync(RoomDAO roomDao) {
            this.roomDao = roomDao;
        }


        @Override
        protected List<String> doInBackground(Hotel... hotels) {
            return roomDao.getRoomsForHotel(hotels[0].getId());
        }
    }


}