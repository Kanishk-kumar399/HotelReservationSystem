package com.hotelreservationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class HotelReservation 
{
	static Scanner sc=new Scanner(System.in);
	private static List<Hotel> hotelList=new ArrayList<>();
	public static void addHotel()
	{
		while(true)
		{
		System.out.println("Add a hotel:");
        System.out.println("Enter Hotel Name:");
        String hotelName=sc.next();
        System.out.println("Enter weekday rate");
        int weekdayRate=sc.nextInt();
        System.out.println("Enter weekend rate");
        int weekendRate=sc.nextInt();
		Hotel hotel=new Hotel(hotelName,weekdayRate,weekendRate);
		hotelList.add(hotel);
		System.out.println("Do You Want to add More hotel(Y/N)");
		char choice=sc.next().charAt(0);
		if(choice!='Y')
			break;
		}
	}
	public static void getCheapestHotel()
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
		 for(Hotel hotel: hotelList) 
		 {
	        	long totalCost = numberOfWeekDays*hotel.getWeekdayRate()+numberOfWeekends*hotel.getWeekendRate();
	        	hotel.setTotalCost(totalCost);
	        	if(minimumCost==0)
	        		minimumCost=hotel.getTotalCost();
	        	 if(hotel.getTotalCost()<minimumCost)
					 minimumCost=hotel.getTotalCost();
	     }
		 List<String> cheapestHotelNameList=new ArrayList<>();
		 for(int i = 0; i < hotelList.size(); i++) 
		 {
			 if(hotelList.get(i).getTotalCost()==minimumCost)
			cheapestHotelNameList.add(hotelList.get(i).getHotelName());
		 }
		 System.out.println("Cheapest Hotels are: "+cheapestHotelNameList+" with tota price $"+minimumCost);
	}
	public static void main( String[] args )
    {
        System.out.println( "Welcome to Hotel Reservation System");
        addHotel();
        System.out.println("Enter dates for finding cheapest hotel");
        getCheapestHotel();
        System.out.println(hotelList);
    }
}
