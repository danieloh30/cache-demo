package org.acme.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.acme.model.WeatherForecast;
import org.acme.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService service;
    
    @GetMapping("/weather")
    public WeatherForecast getForecast(@RequestParam String city, @RequestParam(defaultValue = "0") String daysInFutureStr) {

        long startTime = System.currentTimeMillis();
        long daysInFutre = Long.parseLong(daysInFutureStr);

        List<String> dailyForecasts = Arrays.asList(
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFutre), city),
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFutre + 1L), city),
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFutre + 2L), city)
        );

        long endTime = System.currentTimeMillis();

        return new WeatherForecast(dailyForecasts, endTime - startTime);
    }
}