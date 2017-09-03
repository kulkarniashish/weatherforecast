package com.finleap.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.RestAdapter.Log;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public final class BaseService {

	private static final String WEATHER_API_BASE_ENDPOINT = "http://api.openweathermap.org/data/2.5/";
	private static final int WAIT_THRESHOLD = 5000;
	private static final int MAX_RETRY = 3;

	private final static Log log = new Log() {

		public void log(String message) {
			System.out.println(message);
		}
	};

	private BaseService() {
	}

	public static WeatherInteface getApi() {
		Gson gson = new GsonBuilder().create();

		OkHttpClient httpClient = new OkHttpClient();
		Interceptor interceptor = new Interceptor() {

			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				Response response = null;
				boolean responseOK = false;
				int tryCount = 0;

				while (!responseOK && tryCount < MAX_RETRY) {
					try {
						response = chain.proceed(request);
						responseOK = response.isSuccessful();
						
					} catch (Exception e) {
						log.log("Request is not successful - " + tryCount);
						try {
							Thread.sleep(WAIT_THRESHOLD);
							log.log("Retrying after - " + WAIT_THRESHOLD + " ms");
						} catch (InterruptedException e1) {

						}
					} finally {
						tryCount++;
					}
				}

				// otherwise just pass the original response on
				return response;
			}
		};
		httpClient.interceptors().add(interceptor);
		httpClient.setReadTimeout(300, TimeUnit.SECONDS);

		RestAdapter restAdapter = new RestAdapter.Builder()

		.setEndpoint(WEATHER_API_BASE_ENDPOINT)
				.setClient(new OkClient(httpClient))
				.setConverter(new GsonConverter(gson))
				.setLogLevel(LogLevel.FULL).setLog(log).build();

		return restAdapter.create(WeatherInteface.class);

	}
}
