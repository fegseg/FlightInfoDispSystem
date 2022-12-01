package com.fegseg.service;

import com.fegseg.bean.FlightBean;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface FlightService {

    public boolean insert(FlightBean flightBean);
    public boolean update(FlightBean flightBean);

    public boolean delete(Integer id);

    public  List<FlightBean> getSome(Integer from, Integer to);
    public List<FlightBean> getAll();

    public List<FlightBean> searchTime(String from, String to);
    public List<FlightBean> searchKeyWord(String keyWord, String fromDateTime, String toDateTime);

    FlightBean getById(Integer id);

    FlightBean getLastOne();
}
