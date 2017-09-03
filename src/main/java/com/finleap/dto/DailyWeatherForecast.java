package com.finleap.dto;

/**
 * "dt": 1504418400, "temp": { "day": 302.03, "min": 292.94, "max": 303.32,
 * "night": 292.94, "eve": 300.09, "morn": 297.63 }, "pressure": 925.77,
 * "humidity": 89, "weather": [ { "id": 502, "main": "Rain", "description":
 * "heavy intensity rain", "icon": "10d" } ], "speed": 4.01, "deg": 322,
 * "clouds": 12, "rain": 18.62
 * 
 * @author Ashish
 * 
 */
public class DailyWeatherForecast {

	private Long dt;
	private Temperature temp;
	private Double pressure;

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public Temperature getTemp() {
		return temp;
	}

	public void setTemp(Temperature temp) {
		this.temp = temp;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

}
