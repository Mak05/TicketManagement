package com.mak.exception;

@SuppressWarnings("serial")
public class RecordNotFoundException extends Exception {

	public RecordNotFoundException() {
		super("No Products found to List");
	}

	public RecordNotFoundException(int id) {
		super("ID not found");
	}

}