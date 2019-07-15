package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_in_more_empty_positions_lot() throws Exception {
        List<ParkingLot> lots=new ArrayList<>();
        ParkingLot parkingLot1=new ParkingLot();
        ParkingLot parkingLot2=new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        SmartPakingBoy SmartParkingBoy=new SmartPakingBoy(lots);

        Car firstCar=new Car();
        Ticket ticketFirst=SmartParkingBoy.parking(firstCar);

        Car SecondeCar=new Car();
        Ticket ticketLast=SmartParkingBoy.parking(SecondeCar);

        Assertions.assertTrue(parkingLot1.getParkingMap().get(ticketLast)==null);
    }
}
