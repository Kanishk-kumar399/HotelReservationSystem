package com.hotelreservationsystem;

public class Hotel 
{
	public String hotelName;
	public int weekdayRate;
	public int weekendRate;
	public long totalCost;
	public int hotelRating;
	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalRate) {
		this.totalCost = totalRate;
	}

	public Hotel(String hotelName, int weekdayRate, int weekendRate,int hotelRating) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.hotelRating=hotelRating;
	}

	public int getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(int hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	@Override
	public String toString() {
		return "Hotel Name: " + hotelName + ", Weekday Rate: $" + weekdayRate+ ", Weekend Rate: $" + weekendRate+"\n";
	}
}