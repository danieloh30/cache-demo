package org.acme.springcache.service;

import java.time.LocalDate;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class WeatherForecastService {
    
    @Cacheable("weather-cache")
    public String getDailiyForecast(LocalDate date, String city) {

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return date.getDayOfWeek() + " will be " + getDailyResult(date.getDayOfMonth() % 4) + " in " + city;

    }
    
    public String getDailyResult(int dayOfMonth) {

        switch(dayOfMonth) {
            case 0:
                return "sunny";
            case 1:
                return "cloudy";
            case 2:
                return "rainly";
            case 3:
                return "chilly";
            default:
                throw new IllegalArgumentException();
        }
    }
}