package com.cxd.controller;

import com.cxd.pojo.Hotel;
import com.cxd.pojo.Order;
import com.cxd.pojo.Room;
import com.cxd.pojo.User;
import com.cxd.service.HotelService;
import com.cxd.service.OrderService;
import com.cxd.service.RoomService;
import com.cxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping("/ToOrder")
    public  String AddOrder(@RequestParam("RoomId") Integer RoomId,
                            Model model, HttpSession session){
        String userId =(String) session.getAttribute("userId");
        System.out.println("iiiiiii ammmmmm hhhhee errrrrrr");
        System.out.println("session userid"+userId);//可以通过session拿当前的userId
//        System.out.println("userid:"+userid);//model已经变了，所以是拿不出的
        User user = userService.queryUserById(Integer.valueOf(userId));
        Room room = roomService.queryRoomById(RoomId);
        Hotel hotel=hotelService.queryHotelById(room.getHotelId());
        model.addAttribute("room",room);
        model.addAttribute("user",user);
        model.addAttribute("hotel",hotel);
        return "addOrder";
    }

    public boolean judgeTime(String Time) throws ParseException {
        Date date=null;
        Date nowdate = new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");

        date=formatter.parse(Time);
        System.out.println(date);
        if (date.compareTo(nowdate)<=0) {
            return true;
        }
        return false;

    }


    @RequestMapping("/AddOrder")
    public String Confirm(@RequestParam("userId") Integer userId,
                          @RequestParam("arriveTime") String arriveTime,
                          @RequestParam("leaveTime") String leaveTime,
                          @RequestParam("roomId") Integer roomId,
                          @RequestParam("NumOfMan") Integer NumOfMan,
                          Model model) throws ParseException {
        User user = userService.queryUserById(userId);
        Room room = roomService.queryRoomById(roomId);
        Hotel hotel=hotelService.queryHotelById(room.getHotelId());
        model.addAttribute("room",room);
        model.addAttribute("user",user);
        model.addAttribute("hotel",hotel);
        if (NumOfMan >room.getNumOfMan()){
            model.addAttribute("msg","人数太多，订单取消");
            return "addOrder";
        }else if (room.getNumOfRoom()-1<=0){
            model.addAttribute("msg","房间数量不足");
            return "addOrder";

        }else if (judgeTime(arriveTime)&&judgeTime(leaveTime)){
            model.addAttribute("msg","日期设定不合理");
            return "addOrder";
        } else {

            Order order = new Order(user.getName(), user.getPhone(), arriveTime, leaveTime, NumOfMan,roomId, userId);
            if (orderService.addOrder(order)){
                room.setNumOfRoom(room.getNumOfRoom()-1);
                roomService.update(room);
            }
            return "success";
        }
    }
    @RequestMapping("/checkOrder")
    public String Orderparticular(@RequestParam("orderId")Integer orderId,Model model){
        Order order = orderService.queryOrderById(orderId);
        User user = userService.queryUserById(Integer.valueOf(order.getOrderId()));
        Room room = roomService.queryRoomById(order.getRoomId());
        Hotel hotel=hotelService.queryHotelById(room.getHotelId());
        model.addAttribute("room",room);
        model.addAttribute("user",user);
        model.addAttribute("hotel",hotel);
        model.addAttribute("order",order);
        return "orderPart";
    }


}
