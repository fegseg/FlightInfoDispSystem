package com.fegseg;

import com.fegseg.bean.AdminBean;
import com.fegseg.bean.FlightBean;
import com.fegseg.service.AdminService;
import com.fegseg.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class FlightInfoDispSystemApplicationTests {

    @Autowired
    FlightService flightService;

    @Autowired
    AdminService adminService;


    @Test
    void contextLoads() {
        FlightBean flightBean = flightService.getById(1);
        System.out.println(flightBean.toString());

        AdminBean ad = adminService.checking("root", "123456");
        System.out.println(ad.toString());
    }

}
