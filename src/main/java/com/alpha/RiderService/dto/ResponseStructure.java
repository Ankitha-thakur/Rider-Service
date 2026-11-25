package com.alpha.RiderService.dto;

public class ResponseStructure<T> {

	private int statuscode;
	private String Message;
	private T data;
	public ResponseStructure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseStructure(int statuscode, String message, T data) {
		super();
		this.statuscode = statuscode;
		Message = message;
		this.data = data;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
