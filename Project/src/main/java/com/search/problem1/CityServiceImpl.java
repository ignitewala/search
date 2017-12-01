package com.search.problem1;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CityServiceImpl implements CityService {

	private Map<String, LinkedHashSet<String>> cityConnectionMap = new LinkedHashMap<>();

	@Override
	public boolean isConnected(String sourceCity, String destinationCity) {
		Objects.nonNull(sourceCity);
		Objects.nonNull(destinationCity);

		LinkedList<String> visitedCities = new LinkedList<>();
		visitedCities.add(sourceCity);
		
		Set<Boolean> found = new HashSet<>();
		search(visitedCities, sourceCity, destinationCity, found);

		return found.contains(true);
	}

	@Override
	public void connectTwoCities(String sourceCity, String destinationCity) {
		connect(sourceCity, destinationCity);
		connect(destinationCity, sourceCity);

	}

	private void connect(String sourceCity, String destinationCity) {
		LinkedHashSet<String> connectedCities = cityConnectionMap.get(sourceCity);
		if (connectedCities == null) {
			connectedCities = new LinkedHashSet<>();
			cityConnectionMap.put(sourceCity, connectedCities);
		}

		connectedCities.add(destinationCity);
	}

	public LinkedList<String> adjacentNodes(String city) {
		LinkedHashSet<String> adjacent = cityConnectionMap.get(city);
		if (adjacent == null) {
			return new LinkedList<>();
		}
		return new LinkedList<String>(adjacent);
	}

	private void search(LinkedList<String> visitedCities, String source, String destinationCity, Set<Boolean> found) {
		LinkedList<String> adjacentCities = adjacentNodes(visitedCities.getLast());

		for (String city : adjacentCities) {
			if (visitedCities.contains(city)) {
				continue;
			}
			if (city.equals(destinationCity)) {
				visitedCities.add(city);
				printConnection(visitedCities, source, destinationCity);
				visitedCities.removeLast();
				found.add(true);
				break;
			}
		}

		for (String city : adjacentCities) {
			if (visitedCities.contains(city) || city.equals(destinationCity)) {
				continue;
			}
			visitedCities.addLast(city);
			search(visitedCities, source, destinationCity, found);
			visitedCities.removeLast();
		}

	}

	private void printConnection(LinkedList<String> visited, String src, String dest) {

		System.out.println("Connected path between " + src + " and " + dest);

		for (String node : visited) {
			System.out.print(node);
			System.out.print(" -> ");
		}
		System.out.println();
	}
}
