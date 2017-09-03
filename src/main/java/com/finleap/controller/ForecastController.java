package com.finleap.controller;

import static spark.Spark.get;
import spark.Request;
import spark.Response;
import spark.Route;

import com.finleap.dto.WeatherData;
import com.finleap.service.WeatherForecastService;
import com.finleap.util.JsonUtil;

public class ForecastController {

	/**
	 * Controller having routes Forecast Endpoint
	 * 
	 * @param weatherForecastService
	 */
	public ForecastController(final WeatherForecastService weatherForecastService) {
		
		get("/getData", new Route() {
			public Object handle(Request request, Response response) {
				
				String cityName = request.queryParams("city");
				WeatherData cityWeatherData = weatherForecastService.getDataByCity(cityName);
				return JsonUtil.toJson(cityWeatherData);
			}
		});
	} 

}
