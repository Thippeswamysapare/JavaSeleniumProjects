package com.blessing.rest;

public class PayLoads {

	public static String createBooking()
	{
		return "{\r\n"
				+ "    \"firstname\": \"Jim\",\r\n"
				+ "    \"lastname\": \"Brownee\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}";
		
	}
	
	public static String UpdateBooking()
	{
		return "{\r\n"
				+ "    \"firstname\": \"JamesPater\",\r\n"
				+ "    \"lastname\": \"Brown\",\r\n"
				+ "    \"totalprice\": 111,\r\n"
				+ "    \"depositpaid\": true,\r\n"
				+ "    \"bookingdates\": {\r\n"
				+ "        \"checkin\": \"2018-01-01\",\r\n"
				+ "        \"checkout\": \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\": \"Breakfast\"\r\n"
				+ "}";
		
	}

	public static String PayLoadForGetToken()
	{
		return "{\r\n"
				+ "    \"username\": \"admin\",\r\n"
				+ "    \"password\": \"password123\"\r\n"
				+ "}";
		
	}
}
