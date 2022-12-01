package com.fegseg.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DateConverter implements Converter<String, Timestamp> {

    @Override
    public Timestamp convert(String info) {
        Timestamp timestamp = null;
        if(info.length()>16)
            timestamp = Timestamp.valueOf(info.replace("T", " "));
        else
            timestamp = Timestamp.valueOf(info.replace("T", " ")+":00");
        return timestamp;
    }
}
