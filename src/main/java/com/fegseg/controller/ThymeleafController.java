package com.fegseg.controller;

import com.fegseg.bean.FlightBean;
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

    @RequestMapping("/home")
    public String homePage(){
        return "index";
    }

    @RequestMapping("/flightInfo")
    public String flightInfoPage(Model model){
        List<FlightBean> flightBeans = flightService.getSome(0, 20);//flightService.searchTime(today+" 00:00:00", today+" 23:59:59");
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
    public String insert(){
        return "insert";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(int id, Model model){
        FlightBean f = flightService.getById(id);
        model.addAttribute("f", f);
        return "modify";
    }



}
