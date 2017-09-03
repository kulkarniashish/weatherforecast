package com.finleap.application;

import com.finleap.controller.ForecastController;
import com.finleap.service.WeatherForecastService;

public class Application {

	/**
	 * Main application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ForecastController(new WeatherForecastService());
	}

}
