package com.cxd.controller;

import com.cxd.pojo.Administrator;
import com.cxd.pojo.Hotel;
import com.cxd.pojo.Order;
import com.cxd.pojo.User;
import com.cxd.service.AdministratorService;
import com.cxd.service.HotelService;
import com.cxd.service.OrderService;
import com.cxd.service.UserService;
import com.cxd.service.serviceimpl.AdministratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loginController {

    //servie要加自动注入的注解不然是null.
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private UserService userService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/login")
    //    @ResponseBody不会走视图解析
    public String test(
            @RequestParam("Id") String Id,
            @RequestParam("Password") String password,
            @RequestParam("type") String type,
            Model model, HttpSession session){
//login会根据前端的checkbox数据来决定使用哪种登录

        if (!Id.isEmpty()&&!password.isEmpty()){
            if (type.equals("adm")){
                if (administratorService.Login(new Administrator(Integer.valueOf(Id),password))) {
                    List<User> users = userService.queryUserList();
                    session.setAttribute("admin",new Administrator(Integer.valueOf(Id),password));
                    model.addAttribute("admid",Integer.valueOf(Id));
//管理员登录成功，可以操作user，修改user的密码，所以也要看到user的list
                    model.addAttribute("users",users);
                    return "adminMain";
                }
            }else {
                if (userService.Login(new User(Integer.valueOf(Id),password))) {
                    List<Hotel> hotels = hotelService.queryHotelList();
                    List<Order> orders = orderService.queryOrderListByUserId(Integer.valueOf(Id));

                    session.setAttribute("userId",Id);
                    model.addAttribute("userid",Integer.valueOf(Id));
                    model.addAttribute("emps",hotels);
                    model.addAttribute("orders",orders);

                    return "userMain";
                }
            }
        }
        model.addAttribute("msg","用户名或者密码错误");
        return "login";
    }

    @RequestMapping("/userlogout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("/backuser")
    public String backUser(HttpSession session,Model model){
        String Id = (String)session.getAttribute("userId");
        List<Order> orders = orderService.queryOrderListByUserId(Integer.valueOf(Id));
        List<Hotel> hotels = hotelService.queryHotelList();
        model.addAttribute("userid",Integer.valueOf(Id));
        model.addAttribute("emps",hotels);
        model.addAttribute("orders",orders);

        return "userMain";
    }
}
