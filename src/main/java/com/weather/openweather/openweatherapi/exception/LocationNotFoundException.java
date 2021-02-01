package com.weather.openweather.openweatherapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocationNotFoundException extends RuntimeException{

    private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public LocationNotFoundException() {
        logger.error("Unknown error occurred on : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER)));
    }

    public LocationNotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}
