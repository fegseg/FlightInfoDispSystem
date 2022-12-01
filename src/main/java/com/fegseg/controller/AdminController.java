package com.fegseg.controller;

import com.fegseg.bean.AdminBean;
import com.fegseg.bean.FlightBean;
import com.fegseg.service.AdminService;
import com.fegseg.service.FlightService;
import org.springframework.asm.Attribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class AdminController {

    @Resource
    AdminService adminService;

    @Resource
    FlightService flightService;

    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public String login(String username, String password, Model model){
        AdminBean admin = adminService.checking(username, password);
        if (admin == null)  return "LoginFailed";
        model.addAttribute("admin", admin);
        return "success";

    }

    @RequestMapping("/admin")
    public String login(Model model){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = date.format(formatter);
        List<FlightBean> flightBeans = flightService.searchTime(today+" 00:00:00", today+" 23:59:59");

        if(flightBeans != null){
            model.addAttribute("f_list", flightBeans);
        }
        return "AdminPage";

    }

    @RequestMapping(value = "/admin/insert", method = RequestMethod.POST)
    public String insertFlightInfo(FlightBean flightBean){
        System.out.println(flightBean.toString());
        boolean flag = flightService.insert(flightBean);
        if(flag) {
            System.out.println("200 ok");
            System.out.println(flightService.getLastOne().toString());
        }
        else
            System.out.println(flightService.getLastOne().toString());
        return "forward:/admin";
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String updateFlightInfo(FlightBean flightBean){
        boolean flag = flightService.update(flightBean);
        if (flag){
            System.out.println("200 ok");
        } else {
            System.out.println("500 false");
        }
        System.out.println(flightBean.toString());
        return "forward:/admin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteFlightInfo(Integer id){
        boolean flag = flightService.delete(id);
        if (flag){
            System.out.println("id=" + id + " 200 ok");
        } else {
            System.out.println("id=" + id + " 500 false");
        }
        return "forward:/admin";
    }


}
