package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    private SuperSmartParkingBoy superSmartParkingBoy;
    private List<ParkingLot> lots;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    @BeforeEach
    private void init() {
        lots = new ArrayList<>();
        parkingLot1 = new ParkingLot();
        parkingLot2 = new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        superSmartParkingBoy = new SuperSmartParkingBoy(lots);
    }
    @Test
    public void should_park_car_in_bigger_positions_rate_lot() throws Exception {
        for(int i=0;i<6;i++){
            Car car=new Car();
            Ticket ticket=superSmartParkingBoy.parking(car);
        }
        Car firstCar=new Car();
        Ticket ticketFirst=superSmartParkingBoy.parking(firstCar);
        Car SecondeCar=new Car();
        Ticket ticketLast=superSmartParkingBoy.parking(SecondeCar);

        Assertions.assertNull(parkingLot2.getParkingMap().get(ticketLast));
    }
}
