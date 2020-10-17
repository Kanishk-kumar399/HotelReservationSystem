package com.hotelreservationsystem;

public class Hotel 
{
	private String hotelName;
	private int regularCustomerRate;
	
	public Hotel(String hotelName,int regularCustomerRate) {
		this.hotelName = hotelName;
		this.regularCustomerRate = regularCustomerRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustRate() {
		return regularCustomerRate;
	}

	public void setRegularCustRate(int regularCustomerRate) {
		this.regularCustomerRate = regularCustomerRate;
	}
}