package com.hotelreservationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class HotelReservation
{
	static Scanner sc=new Scanner(System.in);
	private static List<Hotel> hotelList=new ArrayList<Hotel>();
	public static void addHotel(String hotelName,int weekdayRate,int weekendRate,int weekdayRateReward,int weekendRateReward,int rating)
	{
		Hotel hotel=new Hotel(hotelName,weekdayRate,weekendRate,weekdayRateReward,weekendRateReward,rating);
		hotelList.add(hotel);
	}
	public static void getCheapestBestRatedHotel(String customerType) throws CustomerInvalidException
	{
		int choice=0;
		String Regular="REGULAR";
		String Reward="REWARD";
		if(Regular.equalsIgnoreCase(customerType))
			choice=1;
		else if(Reward.equalsIgnoreCase(customerType))
			choice=2;
		else throw new CustomerInvalidException("Please Enter a valid customer type");//throws Exception
		Date startDate=null;
		Date endDate=null;
		System.out.println("Enter Start Date in dd-MMM-YYYY");
		String start=sc.next();
		System.out.println("Enter end date in dd-MMM-YYYY");
		String end=sc.next();
		try {
			startDate = new SimpleDateFormat("dd-MMM-yyyy").parse(start);
			endDate = new SimpleDateFormat("dd-MMM-yyyy").parse(end); 
			}
		catch (ParseException e) 
		{
			System.out.println("Please enter a valid date");//catching exception
		} 
		long numberOfDays = 1+(endDate.getTime()- startDate.getTime())/1000/60/60/24;
		Calendar startCalendar=Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endcalendar=Calendar.getInstance();
		endcalendar.setTime(endDate);
		long numberOfWeekDays=0;
		while(startCalendar.getTimeInMillis()<=endcalendar.getTimeInMillis())
		{
		if((startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY )&&(startCalendar.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY ))
		{
			numberOfWeekDays++;
		}
		 startCalendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		long numberOfWeekends=numberOfDays-numberOfWeekDays;
		 long minimumCost=0;
		 if(choice==1)
		 {
			 for(Hotel hotel: hotelList) 
			 {
	        	long totalCost = numberOfWeekDays*hotel.getWeekdayRate()+numberOfWeekends*hotel.getWeekendRate();
	        	hotel.setTotalCost(totalCost);
	        	if(minimumCost==0)
	        		minimumCost=hotel.getTotalCost();
	        	 if(hotel.getTotalCost()<minimumCost)
					 minimumCost=hotel.getTotalCost();
			 }
		 }
		 else if(choice==2)
		 {

			 for(Hotel hotel: hotelList) 
			 {
	        	long totalCost = numberOfWeekDays*hotel.getWeekdayRateReward()+numberOfWeekends*hotel.getWeekendRateReward();
	        	hotel.setTotalCost(totalCost);
	        	if(minimumCost==0)
	        		minimumCost=hotel.getTotalCost();
	        	 if(hotel.getTotalCost()<minimumCost)
					 minimumCost=hotel.getTotalCost();
			 }
		 }
		 List<Hotel> cheapestHotelNameList=new ArrayList<Hotel>();
		 for(int i = 0; i < hotelList.size(); i++) 
		 {
			 if(hotelList.get(i).getTotalCost()==minimumCost)
				 cheapestHotelNameList.add(hotelList.get(i));
		 }
		 //using java streams
		 Hotel cheapestBestRatedHotel=cheapestHotelNameList.stream().max((hotelOne, hotelTwo) -> hotelOne.getHotelRating() - hotelTwo.getHotelRating()).orElse(null);
		 String cheapestHighestRatedHotel=cheapestBestRatedHotel.getHotelName();
		 System.out.println(cheapestHighestRatedHotel+", Rating: "+cheapestBestRatedHotel.getHotelRating()+" and Total Rates :$"+minimumCost);
	}
	public static void main( String[] args )
    {
		HotelReservation hotelReservation=new HotelReservation();
        System.out.println( "Welcome to Hotel Reservation System");
        hotelReservation.addHotel("Lakewood", 110, 90,80,80,3);
        hotelReservation.addHotel("Bridgewood",150,50,110,50,4);
        hotelReservation.addHotel("Ridgewood",220,150,100,40,5);
        System.out.println("Enter the type of customer you are :REGULAR or REWARDS customer");
        String customerType=sc.next();
        System.out.println("Enter dates for finding best rated cheapest hotels");
        try {
			getCheapestBestRatedHotel(customerType);
		} catch (CustomerInvalidException e) {
			e.printStackTrace();
		}
    }
	public int countNoOfHotels() {
		return hotelList.size();
	}
}
