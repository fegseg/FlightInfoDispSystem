package com.fegseg.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class StringConverter implements Converter<Timestamp, String> {

    @Override
    public String convert(Timestamp datetime) {
        return datetime.toString();
    }
}
