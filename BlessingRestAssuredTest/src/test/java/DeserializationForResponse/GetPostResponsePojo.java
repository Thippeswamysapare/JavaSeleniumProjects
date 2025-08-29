package DeserializationForResponse;

import SerializationData.BookingDatePOJO;

public class GetPostResponsePojo {
	private String firstname;
	private String lastname;
	private String totalprice;
	private boolean depositpaid;
	private String additionalneeds;
	private BookingDatePOJO bookingdates;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	public BookingDatePOJO getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(BookingDatePOJO bookingdates) {
		this.bookingdates = bookingdates;
	}

}
