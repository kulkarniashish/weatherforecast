package com.finleap.dto;

/**
 * DTO object to be returned by Forecast API
 * 
 * @author Ashish
 *
 */
public class WeatherData {

	@Override
	public String toString() {
		return "WeatherData [avgDailyTemp=" + avgDailyTemp
				+ ", avgNightlyTemp=" + avgNightlyTemp + ", avgPressure="
				+ avgPressure + "]";
	}

	private Double avgDailyTemp;
	private Double avgNightlyTemp;
	private Double avgPressure;

	public Double getAvgDailyTemp() {
		return avgDailyTemp;
	}

	public void setAvgDailyTemp(Double avgDailyTemp) {
		this.avgDailyTemp = avgDailyTemp;
	}

	public Double getAvgNightlyTemp() {
		return avgNightlyTemp;
	}

	public void setAvgNightlyTemp(Double avgNightlyTemp) {
		this.avgNightlyTemp = avgNightlyTemp;
	}

	public Double getAvgPressure() {
		return avgPressure;
	}

	public void setAvgPressure(Double avgPressure) {
		this.avgPressure = avgPressure;
	}

}
