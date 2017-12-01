package com.search.problem1;

public class Connected {

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println(
					"Please provide the file name, src and dest city name \r\n java Connected cities.txt Boston Hartford");
		}

		String filePath = args[0];
		String srcCity = args[1];
		String destCity = args[2];

		try {
			boolean isConnected = new FileProcessor(new CityServiceImpl()).process(filePath, srcCity, destCity);
			System.out.println(isConnected ? "Yes" : "No");
			
		} catch (InvalidFileFormat e) {
			System.out.println(e.getMessage());
		}
	}
}
