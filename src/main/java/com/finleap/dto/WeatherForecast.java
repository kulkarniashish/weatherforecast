package com.finleap.dto;

import java.util.List;

public class WeatherForecast {

	private List<DailyWeatherForecast> list;
	private Long cnt;

	public List<DailyWeatherForecast> getList() {
		return list;
	}
	public void setList(List<DailyWeatherForecast> list) {
		this.list = list;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
}
