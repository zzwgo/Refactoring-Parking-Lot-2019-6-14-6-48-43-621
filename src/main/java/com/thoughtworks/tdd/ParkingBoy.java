package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {
    List<ParkingLot> parkingLots;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot);
    }
    public ParkingBoy( List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }
    public Ticket parking(Car car) throws ParkingException {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.hasBeenPark(car)){
                return null;
            }else if(!parkingLot.isFull()){
                Ticket ticket=new Ticket();
                parkingLot.park(ticket,car);
                return ticket;
            }
        }
        throw new ParkingException("Not enough position.");
    }
    public Car fetchCar(Ticket ticket) throws Exception {
        if(ticket==null){
            throw new ParkingException("Please provide your parking ticket.");
        }
        for(ParkingLot parkingLot:parkingLots){
            Car car=parkingLot.fetch(ticket);
            if(car!=null){
                return car;
            }
        }
        throw new ParkingException("Unrecognized parking ticket.");
    }
}


