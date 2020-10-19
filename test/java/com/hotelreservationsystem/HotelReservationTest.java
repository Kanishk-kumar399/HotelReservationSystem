package com.hotelreservationsystem;

import org.junit.Test;
import junit.framework.Assert;
public class HotelReservationTest 
{
    @Test
	public void WhenHotelsAdded_ShouldReturnCount()
    {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 80, 80, 3);
		int count=hotelReservation.countNoOfHotels();
		Assert.assertEquals(1, count);
    }
    @Test
    public void WhenRegularCustomerSearchIsDoneByProvding2Dtaes_ShouldShow_CorrectOutput()
    {
    	HotelReservation hotelReservation = new HotelReservation();
    	hotelReservation.addHotel("Lakewood", 110, 90,80,80,3);
        hotelReservation.addHotel("Bridgewood",150,50,110,50,4);
        hotelReservation.addHotel("Ridgewood",220,150,100,40,5);
        
    }
}
