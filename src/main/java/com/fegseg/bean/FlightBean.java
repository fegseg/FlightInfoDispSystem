package com.fegseg.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightBean {
    private int flight_no;
    private String flight_number;

    @Override
    public String toString() {
        return "FlightBean{" +
                "flight_no=" + flight_no +
                ", flight_number='" + flight_number + '\'' +
                ", airline_company='" + airline_company + '\'' +
                ", from_city='" + from_city + '\'' +
                ", to_city='" + to_city + '\'' +
                ", stopover='" + stopover + '\'' +
                ", plan_takeoff_time=" + plan_takeoff_time +
                ", plan_arrival_time=" + plan_arrival_time +
                ", actual_takeoff_time=" + actual_takeoff_time +
                ", actual_arrival_time=" + actual_arrival_time +
                ", terminal='" + terminal + '\'' +
                ", gate='" + gate + '\'' +
                ", check_in_counter='" + check_in_counter + '\'' +
                ", flight_statu='" + flight_statu + '\'' +
                '}';
    }

    private String airline_company;
    private String from_city;
    private String to_city;
    private String stopover;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Timestamp plan_takeoff_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp plan_arrival_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp actual_takeoff_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp actual_arrival_time;
    private String terminal;
    private String gate;
    private String check_in_counter;
    private String flight_statu;


    private String checkTime;

    public String calCheckTime(){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        String from = sdf.format(new Date(plan_takeoff_time.getTime() - 1000 * 60 * 120));      // 时间戳转换成时间
        String to = sdf.format(new Date(plan_takeoff_time.getTime() - 1000 * 60 * 40));
        return from + "-" + to;
    }

    public void setFlight_statu(String flight_statu) {
        this.flight_statu = flight_statu;
    }

    public void setCheckTime() {
        checkTime = calCheckTime();
    }

    public String getCheckTime(){
        return checkTime;
    }

    public int getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(int flight_no) {
        this.flight_no = flight_no;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getAirline_company() {
        return airline_company;
    }

    public void setAirline_company(String airline_company) {
        this.airline_company = airline_company;
    }

    public String getFrom_city() {
        return from_city;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    public String getTo_city() {
        return to_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    public String getStopover() {
        return stopover;
    }

    public void setStopover(String stopover) {
        this.stopover = stopover;
    }

    public Timestamp getPlan_takeoff_time() {
        return plan_takeoff_time;
    }

    public void setPlan_takeoff_time(Timestamp plan_takeoff_time) {
        this.plan_takeoff_time = plan_takeoff_time;
    }

    public Timestamp getPlan_arrival_time() {
        return plan_arrival_time;
    }

    public void setPlan_arrival_time(Timestamp plan_arrival_time) {
        this.plan_arrival_time = plan_arrival_time;
    }

    public Timestamp getActual_takeoff_time() {
        return actual_takeoff_time;
    }

    public void setActual_takeoff_time(Timestamp actual_takeoff_time) {
        this.actual_takeoff_time = actual_takeoff_time;
    }

    public Timestamp getActual_arrival_time() {
        return actual_arrival_time;
    }

    public void setActual_arrival_time(Timestamp actual_arrival_time) {
        this.actual_arrival_time = actual_arrival_time;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getCheck_in_counter() {
        return check_in_counter;
    }

    public void setCheck_in_counter(String check_in_counter) {
        this.check_in_counter = check_in_counter;
    }

    public String getFlight_statu() {
        return flight_statu;
    }

    public void setFlight_statu() {
        if (actual_arrival_time != null)
            if((actual_arrival_time.getTime() - plan_arrival_time.getTime()) > 1000*60*15)
                flight_statu = "航班延误";
            else
                flight_statu = "预计正常起飞";
        else
            if (actual_takeoff_time != null)
                if((actual_takeoff_time.getTime() - plan_takeoff_time.getTime()) > 1000*60*25)
                    flight_statu = "延迟起飞";
                else
                    flight_statu = "正常起飞";
            else
                if (isBoarding())
                    flight_statu = "正在登机";
    }


    public boolean isBoarding(){
        long plan_time = plan_takeoff_time.getTime();
        long now_time = new Date().getTime();
        return plan_time >= now_time && (plan_time-now_time)<=1000*60*30;
    }
}
