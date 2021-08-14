package com.cxd.controller;


import com.cxd.mapper.AdministratorMapper;
import com.cxd.mapper.UserMapper;

import com.cxd.pojo.Administrator;
import com.cxd.pojo.User;

import com.cxd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

//不会被视图解析器解析，直接返回字符串
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private com.cxd.mapper.AdministratorMapper AdministratorMapper;

    //这里是直接controller加service层了，可以把上面这行写在dao里，然后  mapper就是dao
    @RequestMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = userMapper.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }

        List<Administrator> administrators = AdministratorMapper.queryAdministratorList();
        for (Administrator administrator : administrators){
            System.out.println(administrator);
            Administrator administrator1 = AdministratorMapper.queryAdministratorById(administrator.getId());
            System.out.println(administrator1);
        }

        return userList;
    }
    //这里要求只注销登录的user,admin重新登录在线
    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model){
        Administrator admin =(Administrator) session.getAttribute("admin");
        session.invalidate();
        System.out.println("注销成功");

        List<User> users = userService.queryUserList();
        model.addAttribute("logout","所有user已经注销");
        model.addAttribute("users",users);
        //实际上是应该重定向，再次登录admin的
        return "adminMain";
    }
/*
    @GetMapping("/emp/{id}")
    public String test(@PathVariable("id")Integer id, Model model, HttpSession session, RedirectAttributes attr){
        System.out.println(id);
        Administrator admin =(Administrator) session.getAttribute("admin");
        System.out.println(admin);
        model.addAttribute("admid",admin.getId());
        attr.addAttribute("Id",admin.getId()+"");
        attr.addAttribute("Password",admin.getPassword());
        attr.addAttribute("type","adm");
        //使用Attribute重定向过来了，但是url中有数据

        return "redirect:/login";
    }*/

//上下两种方法都可以，但是下面这种不会在url中显示密码
/*
    @GetMapping("/emp/{id}")
    public String test(@PathVariable("id")Integer id, Model model, HttpSession session){
        System.out.println(id);
        Administrator admin =(Administrator) session.getAttribute("admin");
        System.out.println(admin);
        List<User> users = userService.queryUserList();
//管理员登录成功，可以操作user，修改user的密码，所以也要看到user的list
        model.addAttribute("admid",admin.getId());
        model.addAttribute("users",users);
        return "adminMain";

    }*/

    @RequestMapping("/changePass")
    public String changePassword(@RequestParam("Id") Integer Id,
                                 @RequestParam("cpassword") String cpassword,
                                 Model model){
        User user = userService.queryUserById(Id);

        if (cpassword.isEmpty()||cpassword.length()<4){
            model.addAttribute("msg","密码为空或太短（小于4位）");
        }else {
            user.setPassword(cpassword);
            userService.UpdateUser(user);
        }
        List<User> users = userService.queryUserList();
        model.addAttribute("users",users);
        return "adminMain";
    }

    @RequestMapping("/Tochange")
    public String changeUser(@RequestParam("Id") Integer Id,Model model){
        User user = userService.queryUserById(Id);
        model.addAttribute("user",user);
        return "userChange";
    }


    @RequestMapping("/changeUser")
    public String changeUser(@RequestParam("Id") Integer Id,
                                 @RequestParam("Name") String Name,
                                 @RequestParam("Phone") String Phone,
                             Model model){
        User user = userService.queryUserById(Id);

        if (Phone.length()==11){
            user.setName(Name);
            user.setPhone(Phone);
            userService.UpdateUser(user);
            return "login";
        }
        model.addAttribute("msg","修改失败");
        model.addAttribute("user",user);
        return "userChange";
        //backuser
    }
}
