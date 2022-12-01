package com.fegseg.servicelmpl;

import com.fegseg.bean.FlightBean;
import com.fegseg.dao.FlightDao;
import com.fegseg.service.FlightService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /*@Override
    public boolean update() {

        List<FlightBean> flights = this.getAll();
        Random random = new Random();
        for (FlightBean flight:flights) {
            int flight_no = flight.getFlight_no();
            int s = random.nextInt(8999) + 1000;
            switch (flight.getAirline_company()) {
                case "四川航空":
                    flightDao.update(flight_no, "3U"+String.valueOf(s));
                    break;
                case "深圳航空":
                    flightDao.update(flight_no, "ZH"+String.valueOf(s));
                    break;
                case "青岛航空":
                    flightDao.update(flight_no, "QW"+String.valueOf(s));
                    break;
                case "福州航空":
                    flightDao.update(flight_no, "FU"+String.valueOf(s));
                    break;
                case "昆明航空":
                    flightDao.update(flight_no, "KY"+String.valueOf(s));
                    break;
                case "中国国际航空":
                    flightDao.update(flight_no, "CA"+String.valueOf(s));
                    break;
                case "南方航空":
                    flightDao.update(flight_no, "CZ"+String.valueOf(s));
                    break;
                case "东方航空":
                    flightDao.update(flight_no, "MU"+String.valueOf(s));
                    break;
                case "海南航空":
                    flightDao.update(flight_no, "HU"+String.valueOf(s));
                    break;
                case "山东航空":
                    flightDao.update(flight_no, "SC"+String.valueOf(s));
                    break;
                case "厦门航空":
                    flightDao.update(flight_no, "MF"+String.valueOf(s));
                    break;
                case "上海航空":
                    flightDao.update(flight_no, "FM"+String.valueOf(s));
                    break;
                case "幸福航空":
                    flightDao.update(flight_no, "JA"+String.valueOf(s));
                    break;
                case "吉祥航空":
                    flightDao.update(flight_no, "HO"+String.valueOf(s));
                    break;
                case "春秋航空":
                    flightDao.update(flight_no, "9C"+String.valueOf(s));
                    break;
                default:
                    break;
            }
        }
        return true;
    }*/

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
