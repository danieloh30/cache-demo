package org.acme.springcache.model;

import java.util.List;

public class WeatherForecast {

    private List<String> dailyForecasts;
    private long executionTimeinMs;

	public List<String> getDailyForecasts() {
		return this.dailyForecasts;
	}

	public void setDailyForecasts(List<String> dailyForecasts) {
		this.dailyForecasts = dailyForecasts;
	}

	public long getExecutionTimeinMs() {
		return this.executionTimeinMs;
	}

	public void setExecutionTimeinMs(long executionTimeinMs) {
		this.executionTimeinMs = executionTimeinMs;
	}


    public WeatherForecast(List<String> dailyForecasts, long executionTimeinMs) {
        this.dailyForecasts = dailyForecasts;
        this.executionTimeinMs = executionTimeinMs;
    }
    
}