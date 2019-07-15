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

    private int chooseLot(){
        int loopIndex=0;
        int chooseLotIndex=0;
        for(ParkingLot parkingLot:parkingLots){
            if(!parkingLots.get(chooseLotIndex).isFull() && !parkingLot.isFull()){
                chooseLotIndex=parkingLots.get(chooseLotIndex).getParkingMap().size()<=parkingLot.getParkingMap().size()?chooseLotIndex:loopIndex;
            }
            if(parkingLots.get(chooseLotIndex).isFull()&&chooseLotIndex<parkingLots.size()){
                chooseLotIndex++;
            }
            loopIndex++;
        }
        return chooseLotIndex;
    }
    @Override
    public Ticket parking(Car car) throws ParkingException {
        for(ParkingLot parkingLot:parkingLots){
            if(parkingLot.hasBeenPark(car)){
                return null;
            }
        }
        if(parkingLots.get(chooseLot()).isFull()){
            throw new ParkingException("Not enough position.");
        }else{
            Ticket ticket=new Ticket();
            parkingLots.get(chooseLot()).park(ticket,car);
            return ticket;
        }
    }
}
