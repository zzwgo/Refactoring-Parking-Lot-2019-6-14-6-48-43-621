package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoyTest {
    private SmartPakingBoy smartPakingBoy;
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
        smartPakingBoy = new SmartPakingBoy(lots);
    }
    @Test
    public void should_park_car_in_more_empty_positions_lot() throws Exception {
        Car firstCar=new Car();
        Ticket ticketFirst=smartPakingBoy.parking(firstCar);
        Car SecondeCar=new Car();
        Ticket ticketLast=smartPakingBoy.parking(SecondeCar);

        Assertions.assertNull(parkingLot1.getParkingMap().get(ticketLast));
    }
}
