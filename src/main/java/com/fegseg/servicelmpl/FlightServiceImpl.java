package com.fegseg.servicelmpl;

import com.fegseg.bean.FlightBean;
import com.fegseg.dao.FlightDao;
import com.fegseg.service.FlightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightDao flightDao;

    @Override
    public boolean insert(FlightBean flightBean) {
        return flightDao.insert(flightBean) > 0;
    }

    @Override
    public boolean update(FlightBean flightBean) {
        return flightDao.update(flightBean) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return flightDao.delete(id) > 0;
    }

//    @Override
//    public boolean update() {
//
//        List<FlightBean> flights = this.getAll();
//        Random random = new Random();
//        for (FlightBean flight:flights) {
//            long time = new Date().getTime();
//            long l = random.nextInt(1000*60*60*24) + 1000*60*60*3;
//            int i = random.nextInt(2);
//
//            long suboff = random.nextInt(1000*60*30+1);
//            long suboff2 = random.nextInt(1000*60*20+1);
//            long subarr = random.nextInt(1000*60*60*4+1) + 1000*60*60*2;
//            long planTakeOff;
//            long actualTakeOff;
//            long planArrival;
//            long actualArrival;
//            if (i==1) {
//                planTakeOff = time - l;
//                actualTakeOff = planTakeOff + suboff;
//                planArrival = planTakeOff + subarr;
//                actualArrival = actualTakeOff + subarr +suboff2;
//            }
//            else {
//                planTakeOff = time + l;
//                actualTakeOff = planTakeOff - suboff;
//                planArrival = planTakeOff + subarr;
//                actualArrival = actualTakeOff + subarr - suboff2;
//            }
//            flight.setPlan_takeoff_time(new Timestamp(planTakeOff));
//            flight.setActual_takeoff_time(new Timestamp(actualTakeOff));
//            flight.setPlan_arrival_time(new Timestamp(planArrival));
//            flight.setActual_arrival_time(new Timestamp(actualArrival));
//            flightDao.update(flight);
//        }
//        return true;
//    }

    @Override
    public List<FlightBean> getSome(Integer from, Integer to) {
        List<FlightBean> list = flightDao.getSome(from, to);
        if (list!=null)
            for (FlightBean f:list) {
                f.setCheckTime();
            }
        return list;
    }

    @Override
    public List<FlightBean> getAll() {
        List<FlightBean> list = flightDao.getAll();
        if (list!=null)
            for (FlightBean f:list) {
                f.setCheckTime();
            }
        return list;
    }

    @Override
    public List<FlightBean> searchTime(String from, String to) {
        List<FlightBean> list = flightDao.searchTime(from, to);
        if (list!=null)
            for (FlightBean f:list) {
                f.setCheckTime();
            }
        return list;
    }

    @Override
    public List<FlightBean> searchKeyWord(String keyWord, String fromDateTime, String toDateTime) {
        List<FlightBean> list = flightDao.searchKeyWord(keyWord, fromDateTime, toDateTime);
        if (list!=null)
            for (FlightBean f:list) {
                f.setCheckTime();
            }
        return list;
    }

    @Override
    public FlightBean getById(Integer id) {
        FlightBean flightBean = flightDao.getById(id);
        flightBean.setCheckTime();
        return flightBean;
    }

    @Override
    public FlightBean getLastOne() {
        return flightDao.getLastOne();
    }
}
