package com.hotelreservationsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		System.out.println("Enter Start Date in ddMMMYYYY");
		String start=sc.next();
		System.out.println("Enter end date in ddMMMYYYY");
		String end=sc.next();
		LocalDate startDate = LocalDate.parse(start, dateFormat);
		LocalDate endDate = LocalDate.parse(end, dateFormat);
		final DayOfWeek startW = startDate.getDayOfWeek();
	    final DayOfWeek endW = endDate.getDayOfWeek();
	    long days = ChronoUnit.DAYS.between(startDate, endDate);
	    long daysWithoutWeekends = days - 2 * ((days + startW.getValue())/7);
	    //adjust for starting and ending on a Sunday:
	    long weekdays= daysWithoutWeekends + (startW == DayOfWeek.SUNDAY ? 1 : 0) + (endW == DayOfWeek.SUNDAY ? 1 : 0);
		long weekend= days-daysWithoutWeekends;
		int minCost = (int) (hotelList.get(0).weekdayRate*weekdays + hotelList.get(0).weekendRate*weekend);
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
