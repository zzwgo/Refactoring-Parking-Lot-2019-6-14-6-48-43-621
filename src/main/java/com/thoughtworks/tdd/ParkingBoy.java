package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParkingBoy {
    public List<ParkingLot> parkingLots;
    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots=new ArrayList<>();
        parkingLots.add(parkingLot);
    }
    public ParkingBoy( List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }
    public Ticket parking(Car car) throws ParkingException {
        boolean isFUll=true;
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.hasBeenPark(car)){
                return null;
            }else if(!parkingLot.isFull()){
                isFUll=false;
                Ticket ticket=new Ticket();
                parkingLot.park(ticket,car);
                return ticket;
            }
        }
        if(isFUll){
            throw new ParkingException("Not enough position.");
        }
        return null;
    }

    public Car fetchCar(Ticket ticket) throws Exception {
        boolean isUnrecognized=true;
        if(ticket==null){
            throw new ParkingException("Please provide your parking ticket.");
        }
        for(ParkingLot parkingLot:parkingLots){
            Car car=parkingLot.fetch(ticket);
            if(car!=null){
                isUnrecognized=false;
                return car;
            }
        }
        if(isUnrecognized){
            throw new ParkingException("Unrecognized parking ticket.");
        }
        return null;
    }
}
