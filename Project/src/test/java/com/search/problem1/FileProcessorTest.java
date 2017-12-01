package com.search.problem1;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.search.problem1.CityServiceImpl;
import com.search.problem1.FileProcessor;
import com.search.problem1.InvalidFileFormat;

public class FileProcessorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	@Test
	public void when_invalid_file_raises_error() {
		FileProcessor fileProcessor = new FileProcessor(new CityServiceImpl());
		thrown.expect(InvalidFileFormat.class);
		fileProcessor.process("invalid.txt", "Hartford", "Boston");
	}
	
	
	@Test
	public void when_two_cities_connected() {
		FileProcessor fileProcessor = new FileProcessor(new CityServiceImpl());
		assertTrue(fileProcessor.process("cities.txt", "Hartford", "Boston"));
	}

	@Test
	public void when_two_cities_not_connected() {
		FileProcessor fileProcessor = new FileProcessor(new CityServiceImpl());
		assertFalse(fileProcessor.process("cities.txt", "Hartford", "St Boston"));
	}
	
	
}
