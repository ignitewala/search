package com.search.problem1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.search.problem1.CityService;
import com.search.problem1.CityServiceImpl;

public class CityServiceTest {
	CityService cityService = new CityServiceImpl();
	
	@Test
	public void when_citities_connected_thru_links() {
		cityService.connectTwoCities("A", "B");
		cityService.connectTwoCities("B", "D");
		cityService.connectTwoCities("F", "D");
		
		assertTrue(cityService.isConnected("A", "F"));
	}
	
	@Test
	public void when_two_cities_connected() {
		cityService.connectTwoCities("A", "D");
		cityService.connectTwoCities("B", "D");
		
		assertTrue(cityService.isConnected("B", "A"));
		assertTrue(cityService.isConnected("A", "B"));
	}
	
	@Test
	public void when_two_cities_not_connected() {
		cityService.connectTwoCities("A", "D");
		cityService.connectTwoCities("C", "G");
		
		assertFalse(cityService.isConnected("A", "C"));
		assertFalse(cityService.isConnected("D", "G"));
	}
}
