package org.acme;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class WeatherForecastService {
    
    @CacheResult(cacheName = "weather-cache")
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