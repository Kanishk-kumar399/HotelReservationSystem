package com.hotelreservationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;
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
        System.out.println("Enter rate for regular customer:");
        int regularCustomerRate=sc.nextInt();
		Hotel hotel=new Hotel(hotelName,regularCustomerRate);
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
		System.out.println("Enter Start Date in ddMMMYYYY");
		String start=sc.next();
		System.out.println("Enter end date in ddMMMYYYY");
		String end=sc.next();
		try {
			startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
			endDate = new SimpleDateFormat("ddMMMyyyy").parse(end); 
			}
		catch (ParseException e) 
		{
			e.printStackTrace();
		} 
		long numberOfDays = (endDate.getTime()- startDate.getTime())/1000/60/60/24;
		int minCost = hotelList.get(0).getRegularCustomerRate();
		String cheapestHotelName = hotelList.get(0).getHotelName();
		for(int i = 1; i < hotelList.size(); i++) 
			if(hotelList.get(i).getRegularCustomerRate()< minCost) {
				minCost = hotelList.get(i).getRegularCustomerRate();
				cheapestHotelName = hotelList.get(i).getHotelName();
			}
		System.out.println(cheapestHotelName+" ,Total Cost: "+minCost*numberOfDays);
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
