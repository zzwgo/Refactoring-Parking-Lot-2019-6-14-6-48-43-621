package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class SmartPakingBoy extends ParkingBoy {

    public SmartPakingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartPakingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) throws ParkingException {
        int index=0;
        int chooseLot=0;

        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.hasBeenPark(car)){
                return null;
            }
            if(!parkingLots.get(chooseLot).isFull() && !parkingLot.isFull()){
                    chooseLot=parkingLots.get(chooseLot).getParkingMap().size()<=parkingLot.getParkingMap().size()?chooseLot:index;
            }
            if(parkingLots.get(chooseLot).isFull()&&chooseLot<parkingLots.size()){
                chooseLot++;
            }
            index++;
        }
        if(parkingLots.get(chooseLot).isFull()){
            throw new ParkingException("Not enough position.");
        }else{
            Ticket ticket=new Ticket();
            parkingLots.get(chooseLot).park(ticket,car);
            return ticket;
        }
    }
}
