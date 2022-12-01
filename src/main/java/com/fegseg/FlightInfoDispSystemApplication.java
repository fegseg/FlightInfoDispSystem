package com.fegseg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication()
public class FlightInfoDispSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightInfoDispSystemApplication.class, args);
    }

}
