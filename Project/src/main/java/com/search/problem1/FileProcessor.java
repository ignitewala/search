package com.search.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FileProcessor {
	private final CityService cityService;

	public FileProcessor(CityService cityService) {
		this.cityService = cityService;
	}

	public boolean process(String filePath, String city, String destCity) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(classloader.getResourceAsStream(filePath)))) {
			for (String line; (line = br.readLine()) != null;) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				if (tokenizer.countTokens() > 2) {
					throw new InvalidFileFormat("City name contains ','");
				}

				if (tokenizer.countTokens() < 2) {
					throw new InvalidFileFormat("Invalid line " + line);
				}

				String connectedFrom = tokenizer.nextToken().trim();
				String connectedTo = tokenizer.nextToken().trim();

				cityService.connectTwoCities(connectedFrom, connectedTo);
			}

			return cityService.isConnected(city, destCity);

		} catch (IOException e) {
			throw new InvalidFileFormat(e, "Error parsing the file: " + e.getMessage());
		}

	}
}
