package com.fegseg.controller;

import com.fegseg.bean.AdminBean;
import com.fegseg.bean.FlightBean;
import com.fegseg.service.AdminService;
import com.fegseg.service.FlightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ThymeleafController {

    @Resource
    private FlightService flightService;
    @Resource
    private AdminService adminService;

    @RequestMapping("/home")
    public String homePage(){
        return "index";
    }

    @RequestMapping("/flightInfo")
    public String flightInfoPage(Model model){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String today = date.format(formatter);
        List<FlightBean> flightBeans = flightService.searchTime(today+" 00:00:00", today+" 23:59:59");
        if(flightBeans != null){
            model.addAttribute("f_list", flightBeans);
        }
        return "FlightPage";
    }

    @RequestMapping("/login")
    public String login(){
        return "LoginPage";
    }

    @RequestMapping("/insert")
    public String insert(int admin_id, Model model){
        AdminBean admin = adminService.getById(admin_id);
        model.addAttribute("admin", admin);
        return "insert";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(int flight_id, int admin_id, Model model){
        FlightBean f = flightService.getById(flight_id);
        AdminBean admin = adminService.getById(admin_id);
        model.addAttribute("f", f);
        model.addAttribute("admin", admin);
        return "modify";
    }



}
