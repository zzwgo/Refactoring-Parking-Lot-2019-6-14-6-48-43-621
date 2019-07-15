package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MutipleParkingLotsTest {
    @Test
    public void mutiple_parkingt_lots_can_park_20_cars() throws Exception {
        List<ParkingLot> lots=new ArrayList<>();
        ParkingLot parkingLot1=new ParkingLot();
        ParkingLot parkingLot2=new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        ParkingBoy parkingBoy=new ParkingBoy(lots);
        for(int i=0;i<20;i++){
            Car car=new Car();
            Ticket ticket1=parkingBoy.parking(car);
        }
        Throwable exception = assertThrows(ParkingException.class,()->{
            Car car11=new Car();
            Ticket ticket=parkingBoy.parking(car11);
        });

        assertEquals("Not enough position.",exception.getMessage());
    }
    @Test
    public void mutiple_parkingt_lots_can_fetch_correct_car() throws Exception {
        List<ParkingLot> lots=new ArrayList<>();
        ParkingLot parkingLot1=new ParkingLot();
        ParkingLot parkingLot2=new ParkingLot();
        lots.add(parkingLot1);
        lots.add(parkingLot2);
        ParkingBoy parkingBoy=new ParkingBoy(lots);
        for(int i=0;i<19;i++){
            Car car=new Car();
            Ticket ticket=parkingBoy.parking(car);
        }
        Car car11=new Car();
        Ticket ticket=parkingBoy.parking(car11);
        Car fetchCar11=parkingBoy.fetchCar(ticket);
        assertEquals(car11,fetchCar11);
    }
}
