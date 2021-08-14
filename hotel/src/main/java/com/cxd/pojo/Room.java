package com.cxd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer RoomId;
    private Integer HotelId;
    private String Type;
    private Integer Price;
    private Integer NumOfMan;
    private Integer NumOfRoom;

}
