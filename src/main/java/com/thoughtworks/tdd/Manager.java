package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy{
    private List<ParkingBoy> parkingBoys;

    public Manager(ParkingLot parkingLot) {
        super(parkingLot);
        this.parkingBoys=new ArrayList<>();
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void setParkingBoys(List<ParkingBoy> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public void manage(ParkingBoy parkingBoy) throws ParkingException {
        if(parkingBoy==null){
            throw new ParkingException("parking boy is null");
        }
        this.parkingBoys.add(parkingBoy);
    }

    public Ticket managePark(ParkingBoy parkingBoy,Car car) throws ParkingException {
       return  parkingBoy.parking(car);
    }

    public Car manageParkFetch(ParkingBoy parkingBoy,Ticket ticket) throws Exception {
       return  parkingBoy.fetchCar(ticket);
    }
}
