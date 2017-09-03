package com.finleap.dto;

/**
 * "temp": { "day": 302.03, "min": 292.94, "max": 303.32, "night": 292.94,
 * "eve": 300.09, "morn": 297.63 },
 * 
 * @author Ashish
 * 
 */
public class Temperature {

	private Double day;
	private Double min;
	private Double max;
	private Double night;
	private Double eve;
	private Double morn;

	public Double getDay() {
		return day;
	}

	public void setDay(Double day) {
		this.day = day;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getNight() {
		return night;
	}

	public void setNight(Double night) {
		this.night = night;
	}

	public Double getEve() {
		return eve;
	}

	public void setEve(Double eve) {
		this.eve = eve;
	}

	public Double getMorn() {
		return morn;
	}

	public void setMorn(Double morn) {
		this.morn = morn;
	}

}
