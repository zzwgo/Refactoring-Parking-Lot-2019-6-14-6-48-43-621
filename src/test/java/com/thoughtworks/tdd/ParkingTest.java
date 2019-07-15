package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingTest {
    @Test
    public void parking_the_car_and_should_fetch_the_car_when_give_a_ticket() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car=new Car();
        Ticket ticket=parkingBoy.parking(car);
        Car fetchCar=parkingBoy.fetchCar(ticket);
        assertThat(car, is(fetchCar));
    }

    @Test
    public void parking_mutiple_cars_and_should_fetch_the_car_correct_when_give_a_ticket() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Car car2=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        Ticket ticket2=parkingBoy.parking(car2);
        Car fetchCar1=parkingBoy.fetchCar(ticket1);
        Car fetchCar2=parkingBoy.fetchCar(ticket2);
        assertThat(car1, is(fetchCar1));
        assertThat(car2, is(fetchCar2));
    }

    @Test
    public void parking_cars_and_should_not_fetch_the_car_when_give_a_worng_ticket() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Car car2=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        // not give a ticket
        Throwable exception1 = assertThrows(ParkingException.class,()->{
            Car fetchCar1=parkingBoy.fetchCar(null);
        });
        assertEquals("Please provide your parking ticket.",exception1.getMessage());
        // not give a wrong ticket
        Throwable exception2 = assertThrows(ParkingException.class,()->{
            Car fetchCar2=parkingBoy.fetchCar(new Ticket());
        });
        assertEquals("Unrecognized parking ticket.",exception2.getMessage());
    }

    @Test
    public void should_not_fetch_the_car_when_give_a_ticket_had_been_used() throws Exception {

        Throwable exception2 = assertThrows(ParkingException.class,()->{
            ParkingLot parkingLot=new ParkingLot();
            ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
            Car car1=new Car();
            Ticket ticket1=parkingBoy.parking(car1);
            Car fetchCar1=parkingBoy.fetchCar(ticket1);
            Car fetchCar2=parkingBoy.fetchCar(ticket1);
        });
        assertEquals("Unrecognized parking ticket.",exception2.getMessage());
    }

    @Test
    public void should_not_parking_the_car_when_parkingLot_is_fulled() throws ParkingException {
        Throwable exception2 = assertThrows(ParkingException.class,()->{
            ParkingLot parkingLot=new ParkingLot();
            ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
            for(int i=0;i<20;i++){
                Car car=new Car();
                Ticket ticket1=parkingBoy.parking(car);
            }
            Car car_11=new Car();
            Ticket ticket11=parkingBoy.parking(car_11);
        });
        Assertions.assertEquals("Not enough position.", exception2.getMessage());
    }
    @Test
    public void should_not_parking_the_car_when_parking_a_parked_car() throws ParkingException {
        ParkingLot parkingLot=new ParkingLot();
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        Car car1=new Car();
        Ticket ticket1=parkingBoy.parking(car1);
        Ticket ticket2=parkingBoy.parking(car1);
        Assertions.assertEquals(null, ticket2);
    }
}
