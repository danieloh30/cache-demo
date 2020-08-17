package org.acme;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/weather")
public class WeatherForecastResource {

    @Inject
    WeatherForecastService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherForecast getForecast(@QueryParam String city, @QueryParam long daysInFuture) {

        long startTime = System.currentTimeMillis();

        List<String> dailyForecasts = Arrays.asList(
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFuture), city),
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFuture + 1L), city),
            service.getDailiyForecast(LocalDate.now().plusDays(daysInFuture + 2L), city)
        );

        long endTime = System.currentTimeMillis();

        return new WeatherForecast(dailyForecasts, endTime - startTime);
    }
}