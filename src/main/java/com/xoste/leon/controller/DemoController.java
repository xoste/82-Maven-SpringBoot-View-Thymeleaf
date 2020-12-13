package com.xoste.leon.controller;

import com.xoste.leon.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author Leon
 */
@Controller
public class DemoController {
    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("msg", "Thymeleaf的第一个案例");
        model.addAttribute("date", new Date());
        return "/index";
    }

    @RequestMapping("/show2")
    public String show2(Model model) {
        model.addAttribute("gender", "男");
        model.addAttribute("id", 2);
        return "/index2";
    }

    @RequestMapping("/show3")
    public String show3(Model model) {
        List<Users> listUsers = new ArrayList<>();
        listUsers.add(new Users(0, "张三", "1455234"));
        listUsers.add(new Users(1, "萨达发生", "带返回的方法是"));
        listUsers.add(new Users(2, "十多个", "答复高度"));
        listUsers.add(new Users(3, "广泛", "个圣诞挂饰的"));
        model.addAttribute("listUsers", listUsers);
        return "/index3";
    }

    @RequestMapping("/show4")
    public String show4(Model model) {
        Map<String, Object> mapUsers = new HashMap<>(1);
        mapUsers.put("map1", new Users(0, "张三", "1455234"));
        mapUsers.put("map2",new Users(1, "萨达发生", "带返回的方法是"));
        mapUsers.put("map3",new Users(2, "十多个", "答复高度"));
        mapUsers.put("map4",new Users(3, "广泛", "个圣诞挂饰的"));
        model.addAttribute("mapUsers", mapUsers);
        return "/index4";
    }

    @RequestMapping("/show5")
    public String show5(HttpServletRequest req,Model model) {
        req.setAttribute("req", "HttpServletRequest");
        req.getSession().setAttribute("session", "HttpSession");
        req.getSession().getServletContext().setAttribute("app", "Application");
        return "/index5";
    }
}
