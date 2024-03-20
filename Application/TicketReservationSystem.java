package org.example.Application;

import java.util.*;

public class TicketReservationSystem {
    public static void main(String[] args){
        ReservationSystem reservationSystem = new ReservationSystem(5);
        Scanner scanner = new Scanner(System.in);

        int choice;

        do{
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Print Passenger Details");
            System.out.println("4.Exit");
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter Passenger Name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Passenger Age : ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter boarding station: ");
                    String boardingStation = scanner.nextLine();
                    System.out.print("Enter destination station: ");
                    String destinationStation = scanner.nextLine();
                    boolean booked = reservationSystem.bookTicket(new Passenger(name,age,boardingStation,destinationStation,-1));
                    if (booked){
                        System.out.println("Ticket Booked Successfully");
                    }
                    else {
                        System.out.println("Sorry, all seats are reserved. Added to waiting list.");
                    }
                    break;
                case 2:
                    System.out.println("Enter Ticket Id : ");
                    int ticketId = scanner.nextInt();
                    reservationSystem.cancelTicket(ticketId);
                    break;
                case 3:
                    reservationSystem.printPassengerDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again.");
            }
        }
        while (choice != 4);
    }
}

class ReservationSystem {
    List<Passenger> passengers = new ArrayList<>();
    List<Passenger> waitingList = new ArrayList<>();
    int totalSeats;
    int reservedSeats;
    int nextTicketId;
    Map<Integer,Passenger>ticketIdVsPassenger = new HashMap<>();

    public ReservationSystem(int totalSeats){
        this.totalSeats = totalSeats;
        this.reservedSeats = 0;
        this.nextTicketId = 1;
        this.passengers = new ArrayList<>();
        this.waitingList = new ArrayList<>();
    }

    public boolean bookTicket(Passenger passenger){
        if(totalSeats > reservedSeats){
            passenger.setTicketId(nextTicketId);
            passengers.add(passenger);
            reservedSeats++;
            ticketIdVsPassenger.put(nextTicketId,passenger);
            nextTicketId++;
            return true;
        }
        else {
            waitingList.add(passenger);
            return false;
        }
    }
    public void cancelTicket(int ticketId){
        if (ticketIdVsPassenger.containsKey(ticketId)){
            Passenger passenger = ticketIdVsPassenger.get(ticketId);
            if (passenger != null && passengers.remove(passenger)){
                reservedSeats--;
                ticketIdVsPassenger.remove(ticketId);
                if (!waitingList.isEmpty()){
                    Passenger firstWaitingListpassenger = waitingList.get(0);
                    firstWaitingListpassenger.setTicketId(nextTicketId);
                    passengers.add(firstWaitingListpassenger);
                    reservedSeats++;
                    ticketIdVsPassenger.put(nextTicketId,firstWaitingListpassenger);
                    nextTicketId++;
                    System.out.println("Ticket Confirmed for Passenger in the waiting list : "+firstWaitingListpassenger.getName());
                }
                System.out.println("Ticket cancelled Successfully!!");

            }
            else {
                System.out.println("Passenger Can't be null");
            }
        }
        else {
            System.out.println("Please enter a valid Ticket Id");
        }
    }
    public void printPassengerDetails(){
        System.out.println("************ Passenger Details *************");
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        System.out.println("*********** Done ***************");
    }
}

class Passenger{
    private String name;
    private int age;
    private String stationBoarding;
    private String stationDestination;

    public Passenger( String name , int age, String stationBoarding, String stationDestination, int ticketId){
        this.name = name;
        this.age = age;
        this.stationBoarding = stationBoarding;
        this.stationDestination = stationDestination;
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getStationBoarding() {
        return stationBoarding;
    }

    public String getStationDestination() {
        return stationDestination;
    }

    public int getTicketId() {
        return ticketId;
    }

    private int ticketId;

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stationBoarding='" + stationBoarding + '\'' +
                ", stationDestination='" + stationDestination + '\'' +
                ", ticketId=" + ticketId +
                '}';
    }
}

