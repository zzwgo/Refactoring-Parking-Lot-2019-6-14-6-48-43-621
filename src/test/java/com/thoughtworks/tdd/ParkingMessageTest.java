package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingMessageTest {

    @Test
    public void should_return_message_when_give_had_been_used_ticket() throws Exception {
        Throwable exception = assertThrows(ParkingException.class,()->{
            ParkingLot parkingLot=new ParkingLot();
            ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
            Car car1=new Car();
            Ticket ticket1=parkingBoy.parking(car1);
            Car fetchCar1=parkingBoy.fetchCar(ticket1);
            Car fetchCar2=parkingBoy.fetchCar(ticket1);
        });
        assertEquals("Unrecognized parking ticket.",exception.getMessage());
    }

    @Test
    public void should_return_message_when_give_null_ticket() throws Exception {
        Throwable exception = assertThrows(ParkingException.class,()->{
            ParkingLot parkingLot=new ParkingLot();
            ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
            Car fetchCar=parkingBoy.fetchCar(null);
        });
        assertEquals("Please provide your parking ticket.",exception.getMessage());
    }
    @Test
    public void should_return_message_when_parkingLot_is_fulled() throws ParkingException {
        Throwable exception2 = assertThrows(ParkingException.class,()->{
            ParkingLot parkingLot=new ParkingLot();
            ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
            for(int i=0;i<10;i++){
                Car car=new Car();
                Ticket ticket1=parkingBoy.parking(car);
            }
            Car car_11=new Car();
            Ticket ticket11=parkingBoy.parking(car_11);
        });
        Assertions.assertEquals("Not enough position.", exception2.getMessage());
    }
}
