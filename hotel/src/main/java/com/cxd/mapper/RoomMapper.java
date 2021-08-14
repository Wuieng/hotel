package com.cxd.mapper;




import com.cxd.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface RoomMapper {
    List<Room> queryRoomList(int HotelId);

//    因为ID是主键，所以说不用再加入HotelId
    Room queryRoomById(int Id);

    void updateRoomNum(Room room);
}
