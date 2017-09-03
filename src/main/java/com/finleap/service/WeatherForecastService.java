package com.finleap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finleap.dto.DailyWeatherForecast;
import com.finleap.dto.WeatherData;
import com.finleap.dto.WeatherForecast;
import com.finleap.retrofit.BaseService;
import com.finleap.retrofit.WeatherInteface;

public class WeatherForecastService {

	static final WeatherInteface restClient = BaseService.getApi();
	private static final String appId = "eb309575d0d2c1d9ebefb2f1c854535c";
	Logger logger = LoggerFactory.getLogger(WeatherForecastService.class);

	public WeatherData getDataByCity(String cityName) {

		WeatherForecast weatherForecast = restClient.get(appId, cityName, 1);

		WeatherData weatherData = new WeatherData();
		if (weatherForecast.getList() != null
				&& !weatherForecast.getList().isEmpty()) {
			DailyWeatherForecast dailyWeatherForecast = weatherForecast
					.getList().get(0);
			weatherData.setAvgPressure(dailyWeatherForecast.getPressure());
			if (dailyWeatherForecast.getTemp() != null) {
				weatherData.setAvgDailyTemp(dailyWeatherForecast.getTemp()
						.getDay());
				weatherData.setAvgNightlyTemp(dailyWeatherForecast.getTemp()
						.getNight());
			}
		}

		return weatherData;
	}

}
