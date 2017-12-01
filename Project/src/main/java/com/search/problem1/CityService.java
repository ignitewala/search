package com.search.problem1;

public interface CityService {

	public boolean isConnected(String sourceCity, String destinationCity);
	public void connectTwoCities(String sourceCity, String destinationCity);
}
