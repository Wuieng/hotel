package com.cxd.service.serviceimpl;

import com.cxd.mapper.RoomMapper;
import com.cxd.pojo.Room;
import com.cxd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

//    用于查询一个hotel所有的room
    @Override
    public List<Room> queryRoomList(int HotelId) {
        return roomMapper.queryRoomList(HotelId);
    }

//    用于鼠标点击查询每个room的详细情况
    @Override
    public Room queryRoomById(int Id) {
        return roomMapper.queryRoomById(Id);
    }

    @Override
    public void update(Room room) {
        roomMapper.updateRoomNum(room);
    }
}
