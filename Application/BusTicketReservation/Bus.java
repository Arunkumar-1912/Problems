package org.example.Application.BusTicketReservation;

public class Bus {

    private int busNo ;
    private boolean ac;
    private int capacity;

    Bus(int no , boolean isAc , int cap){
        busNo = no;
        ac = isAc;
        capacity = cap;
    }

    public int getBusNo() {
        return busNo;
    }

//    public void setBusNo(int busNo) {
//        this.busNo = busNo;
//    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean isAc){
        this.ac =isAc;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int cap){
        this.capacity = cap;
    }

    public void displayBusDetails(){
        System.out.println("Bus No : "+busNo+ "  Ac : "+ ac + "  Capacity : "+ capacity);
    }
}
