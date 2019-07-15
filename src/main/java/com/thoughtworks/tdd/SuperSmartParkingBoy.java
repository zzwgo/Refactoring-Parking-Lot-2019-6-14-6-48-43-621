package com.thoughtworks.tdd;

import java.util.List;

import static com.thoughtworks.tdd.ParkingLot.getCapacity;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    private int chooseLot(){
        int loopIndex=0;
        int chooseLotIndex=0;
        for(ParkingLot parkingLot:parkingLots){
            if(!parkingLots.get(chooseLotIndex).isFull() && !parkingLot.isFull()){
                chooseLotIndex=(10-parkingLots.get(chooseLotIndex).getParkingMap().size())/getCapacity()>=(10-parkingLot.getParkingMap().size())/getCapacity() ?chooseLotIndex:chooseLotIndex;
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
