package org.example.Application.BusTicketReservation;
import java.util.ArrayList;
import java.util.Date;

public class Booking {
    private String passengerName;
    private int busNo;
    private Date date;

    Booking(String passengerName , int busNo , Date date){
        this.passengerName = passengerName;
        this.busNo = busNo;
        this.date = date;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAvailable(ArrayList<Bus> list, ArrayList<Booking> bookings) {
        int capacity = 0;
        for (Bus bus : list){
            if (bus.getBusNo() == getBusNo()){
                capacity = bus.getCapacity();
            }
        }
        int booked = 0;
        for (Booking booking: bookings){
            if (booking.getBusNo() == getBusNo() && booking.date.equals(getDate())){
                booked++;
            }
        }

        return capacity>booked;
    }
}
