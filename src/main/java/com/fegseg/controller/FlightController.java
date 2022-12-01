package com.fegseg.controller;

import com.fegseg.bean.FlightBean;
import com.fegseg.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Resource
    private FlightService flightService;

    @GetMapping("/{id}")
    public FlightBean getById(@PathVariable Integer id){
        FlightBean f = flightService.getById(id);
        f.setFlight_statu();
        return f;
    }

    @GetMapping("/{from}/{to}")
    public List<FlightBean> getSome(@PathVariable Integer from, @PathVariable Integer to){
        List<FlightBean> list = flightService.getSome(from, to);
        for (FlightBean f : list) {
            f.setFlight_statu();
        }
        return list;
    }

    @PostMapping ("/search/keyword")
    public List<FlightBean> searchKeyWord(@RequestBody Map<String, String> map){
        String keyWord = map.get("keyWord");
        String fromDateTime;
        String toDateTime;
        if (map.get("time").equals("All Time")){
            fromDateTime = map.get("date") + " 00:00:00";
            toDateTime = map.get("date") + " 23:59:59";
        } else {
            String[] times = map.get("time").split("~");
            fromDateTime = map.get("date") + " " + times[0] + ":00";
            toDateTime = map.get("date") + " " + times[1] + ":59";
        }
        List<FlightBean> list;
        if (keyWord.equals("none")) {
            list = flightService.searchTime(fromDateTime, toDateTime);
        }
        else {
            list = flightService.searchKeyWord(keyWord, fromDateTime, toDateTime);
        }
        for (FlightBean f : list) {
            f.setFlight_statu();
        }
        return list;
    }

    @GetMapping
    public List<FlightBean> getAll(){
        List<FlightBean> all = flightService.getAll();
        for (FlightBean f : all) {
            f.setFlight_statu();
        }
        return all;
    }
}
