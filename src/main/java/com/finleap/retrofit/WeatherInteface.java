package com.finleap.retrofit;

import com.finleap.dto.WeatherForecast;

import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherInteface {
	
	@GET("/forecast/daily")
	WeatherForecast get(@Query("APPID") String appId,
			@Query("q") String cityName, @Query("cnt") Integer noOfDays);
}
