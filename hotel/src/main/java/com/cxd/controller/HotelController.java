package com.cxd.controller;

import com.cxd.pojo.Room;
import com.cxd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@Controller
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    private RoomService roomService;

//查询了所有的room，接下来要赋值
    @RequestMapping("/queryRoomList")
    public String queryRoomList(@RequestParam("HotelId")  Integer HotelId,
                                    Model model){
        System.out.println(HotelId);
        List<Room> rooms = roomService.queryRoomList(HotelId);
        for (Room r : rooms){
            System.out.println(r.getRoomId());
            System.out.println(r);
        }
        Integer userid = (Integer) model.getAttribute("userid");
        System.out.println("userid:"+userid);
        model.addAttribute("rooms",rooms);
        return "roomList";
//
    }
}
