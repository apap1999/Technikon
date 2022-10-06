package com.bootcampEuroDyn.technikon.domain;

public enum PropertyType {
	DETACHED_HOUSE("detached house"),
	MAISONETTE("maisonette"),
	APARTMENT_BUILDING("apartment building")	;
	private final String message;

	private PropertyType(String message) {
		this.message = message;
	}
	@Override
    public String toString() {

        return message;

    }
}

