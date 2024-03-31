package org.example.Application.BusTicketReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class BusTicketReservation {

    /** Enhancements for this reservation application **/

    /** 1. Add more data - Booking number , driver name , to , from,duration
        2.Cancellation
        3.Adding new bus info menu
        4.Display available seat be selecting date
        5.Error Handling
        6.Create passenger class and add more data
        7.sending confirmation mail
        8.Adding seat information
        9.using DB installed of Arraylist
     **/

    public static void main(String[] args){

        ArrayList<Bus> list = new ArrayList<>();
        list.add(new Bus(1,true,3));
        list.add(new Bus(2,false,3));
        list.add(new Bus(3,true,5));

        ArrayList<Booking> bookings = new ArrayList<>();

        int userInput = 1;
        Scanner scanner = new Scanner(System.in);

        // show bus details
        for (Bus bus : list){
            bus.displayBusDetails();
        }

        while (userInput == 1){
            System.out.println("Enter 1 to book ticket and 2 to exit");
            userInput = scanner.nextInt();

            if (userInput == 1){
                String passengerName ;
                int busNo;
                Date date;
                System.out.println("Enter Passenger Name: ");
                passengerName = scanner.next();
                System.out.println("Enter Bus No:");
                busNo = scanner.nextInt();
                System.out.println("Enter Date in format of dd-MM-yyyy");
                String inputString = scanner.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

                try {
                    date = dateFormat.parse(inputString);
                    Booking booking = new Booking(passengerName,busNo,date);
                    if (booking.isAvailable(list,bookings)){
                        bookings.add(booking);
                        System.out.println("Ticket Confirmed");
                    }
                    else {
                        System.out.println("All seats are filled !!!");
                    }

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
