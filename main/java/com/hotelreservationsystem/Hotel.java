package com.hotelreservationsystem;

public class Hotel 
{
	public String hotelName;
	public int weekdayRate;
	public int weekendRate;
	public long totalCost;
	public int hotelRating;
	public int weekdayRateReward;
	public int weekendRateReward;
	public int getWeekdayRateReward() {
		return weekdayRateReward;
	}

	public void setWeekdayRateReward(int weekdayRateReward) {
		this.weekdayRateReward = weekdayRateReward;
	}

	public int getWeekendRateReward() {
		return weekendRateReward;
	}

	public void setWeekendRateReward(int weekendRateReward) {
		this.weekendRateReward = weekendRateReward;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalRate) {
		this.totalCost = totalRate;
	}

	public Hotel(String hotelName, int weekdayRate, int weekendRate,int weekdayRateReward,int weekendRateReward,int hotelRating) {
		super();
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
		this.hotelRating=hotelRating;
		this.weekdayRateReward=weekdayRateReward;
		this.weekendRateReward=weekendRateReward;
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
		return "Hotel Name: " + hotelName + ", Weekday Rate for regular: $" + weekdayRate+ ", Weekend Rate for regular: $" + weekendRate+"\n"+", Weekday Rate for reward: $" + weekdayRateReward+ ", Weekend Rate for reward: $" + weekendRateReward+"\n";
	}
}