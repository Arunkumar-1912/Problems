package org.example.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxiBookingApplication {

    public static void main(String[] args) {
        TaxiBookingActionClass taxiBookingActionClass = new TaxiBookingActionClass(4);
        System.out.println("Taxi Booking Application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Customer ID : ");
        int customerId = scanner.nextInt();
        System.out.println("Enter a Pickup point : ");
        char pickupPoint = scanner.next().charAt(0);
        System.out.println("Enter a Drop point : ");
        char dropPoint = scanner.next().charAt(0);
        System.out.println("Pickup time : ");
        int pickupTime = scanner.nextInt();

        JourneyDetail journeyDetail = new JourneyDetail(customerId,pickupPoint,dropPoint,pickupTime);
        taxiBookingActionClass.bookTaxi(journeyDetail);
    }


}
class TaxiBookingActionClass{
    List<Taxi> taxis = new ArrayList<>();
    int taxiCount = 4;

    TaxiBookingActionClass(int taxiCount){
        for (int i = 1; i <= taxiCount; i++) {
            Taxi taxi = new Taxi(i,true,0,'A');
        }
    }

    TaxiBookingActionClass(){
        for (int i = 1; i <= taxiCount; i++) {
            Taxi taxi = new Taxi(i,true,0,'A');
        }
    }


    public void bookTaxi(JourneyDetail journeyDetail){
       Taxi taxi = findTaxi(journeyDetail);
       if (taxi == null){
           System.out.println("No Taxis are available - Booking canceled");
       }
       else {
           System.out.println("Taxi can be allotted");
           taxi.setJourneyDetailList(journeyDetail);
           taxi.setTotalEarnings(calculateEarnings(journeyDetail.pickupPoint,journeyDetail.dropPoint));
           taxi.setFree(false);
           System.out.println("Taxi-"+taxi.getId()+" is allotted");
       }

    }
    private long calculateEarnings(char pickupPoint , char dropPoint){
        long km = 15* Math.abs(pickupPoint-dropPoint);
        return (km-5)*10+100;
    }

    private Taxi findTaxi(JourneyDetail journeyDetail){

        List<Taxi>availableTaxisAtSamePoint = getAvailableTaxisAtSamePoint(journeyDetail);

        if(availableTaxisAtSamePoint.size() == 1){
            return availableTaxisAtSamePoint.get(0);
        }
        else if (availableTaxisAtSamePoint.size() > 1){
            Taxi lowEarnedTaxi = null;
            long earnings = Integer.MAX_VALUE;
            for (Taxi taxi : availableTaxisAtSamePoint){
                if (taxi.totalEarnings < earnings){
                    earnings = taxi.totalEarnings;
                    lowEarnedTaxi = taxi;
                }
            }
            return lowEarnedTaxi;
        }
        else {
            List<Taxi>availableTaxisAtAnyPoint = new ArrayList<>();
            for (Taxi taxi : taxis){
                if (taxi.isFree){
                    availableTaxisAtAnyPoint.add(taxi);
                }
            }
            Taxi finalTaxi = null;
            long minKM = Integer.MAX_VALUE;
            for (Taxi taxi : availableTaxisAtAnyPoint){
                long distance = 15 * Math.abs(journeyDetail.pickupPoint-taxi.nearestLocation);
                if (distance<minKM){
                    minKM = distance;
                    finalTaxi = taxi;
                }
            }
            return finalTaxi;
        }
    }

    public  List<Taxi> getAvailableTaxisAtSamePoint(JourneyDetail journeyDetail){
        List<Taxi> temp = new ArrayList<>();
        for (Taxi taxi : taxis){
            if (taxi.isFree && taxi.nearestLocation == journeyDetail.pickupPoint){
                temp.add(taxi);
            }
        }
        return temp;
    }
}

class Taxi{
    int id ;
    boolean isFree;
    long totalEarnings;
    char nearestLocation;
    List<JourneyDetail> journeyDetailList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return isFree;
    }

    public List<JourneyDetail> getJourneyDetailList() {
        return journeyDetailList;
    }

    public void setJourneyDetailList(JourneyDetail journeyDetailList) {
        this.journeyDetailList.add(journeyDetailList);
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public long getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(long totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public char getNearestLocation() {
        return nearestLocation;
    }

    public void setNearestLocation(char nearestLocation) {
        this.nearestLocation = nearestLocation;
    }

    Taxi(int id , boolean isFree , long totalEarnings , char nearestLocation){
        this.id = id;
        this.isFree = isFree;
        this.totalEarnings = totalEarnings;
        this.nearestLocation = nearestLocation;
    }
}

class JourneyDetail{
    int customerId ;
    char pickupPoint;
    char dropPoint;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public char getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(char pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(char dropPoint) {
        this.dropPoint = dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    int pickupTime;

    JourneyDetail(int customerId ,char pickupPoint,char dropPoint, int pickupTime){
        this.customerId  = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
    }
}
