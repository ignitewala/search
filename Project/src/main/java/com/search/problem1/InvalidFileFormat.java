package com.search.problem1;

public class InvalidFileFormat extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidFileFormat(String reason){
		super(reason);
	}

	public InvalidFileFormat(Throwable t, String reason){
		super(reason, t);
	}
}
