package com.spring.test;

public class TestBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init() {
		System.out.println("INIT");
	}

	public void destroy() {
		System.out.println("DESTROYING");
	}
}
