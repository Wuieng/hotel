package com.cxd.service;

import com.cxd.pojo.Room;

import java.util.List;

public interface RoomService {

    public List<Room> queryRoomList(int HotelId);

    Room queryRoomById(int Id);

    public void update(Room room);

}
