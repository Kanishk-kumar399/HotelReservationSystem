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
	public static void getCheapestBestRatedHotel(int choice)
	{
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
			e.printStackTrace();
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
		 int maxRating=0;
		 String hotelWithHighestratingandCheapest="";
		 int c=0;
		 for(int i = 0; i < hotelList.size(); i++) 
		 {
			 if(hotelList.get(i).getTotalCost()==minimumCost)
			 {
				 cheapestHotelNameList.add(hotelList.get(i));
				 if(hotelList.get(i).hotelRating>=maxRating)
				 {
					 maxRating=hotelList.get(i).hotelRating;
					 hotelWithHighestratingandCheapest=hotelList.get(i).getHotelName();
				 }
			 }
		 }
		 System.out.println("Cheapest Hotel is: "+hotelWithHighestratingandCheapest+" with rating "+maxRating+" with total price $"+minimumCost);
	}
	public static void main( String[] args )
    {
		HotelReservation hotelReservation=new HotelReservation();
        System.out.println( "Welcome to Hotel Reservation System");
        hotelReservation.addHotel("Lakewood", 110, 90,80,80,3);
        hotelReservation.addHotel("Bridgewood",160,60,110,50,4);
        hotelReservation.addHotel("Ridgewood",220,150,100,40,5);
        while(true)
		{
			System.out.println("Do You Want to add More hotel(Y/N)");
			char choice = sc.next().charAt(0);
			if (choice != 'Y')
				break;
			System.out.println("Add a hotel:");
			System.out.println("Enter Hotel Name:");
			String hotelName = sc.next();
			System.out.println("Enter weekday rate for regular customer");
			int weekdayRate = sc.nextInt();
			System.out.println("Enter weekend rate for regular customer");
			int weekendRate = sc.nextInt();
			System.out.println("Enter weekday rate for reward customer");
			int weekdayRateReward = sc.nextInt();
			System.out.println("Enter weekend rate for reward customer");
			int weekendRateReward = sc.nextInt();
			System.out.println("Enter the rating");
			int rating = sc.nextInt();
			Hotel hotel = new Hotel(hotelName, weekdayRate, weekendRate, weekdayRateReward, weekendRateReward, rating);
			hotelList.add(hotel);
		}
       
        System.out.println("Enter the type of customer you are :1 for regular customer:2 for reward customer");
        int choice=sc.nextInt();
        System.out.println("Enter dates for finding best rated cheapest hotels");
        getCheapestBestRatedHotel(choice);
        System.out.println(hotelList);
    }
}
