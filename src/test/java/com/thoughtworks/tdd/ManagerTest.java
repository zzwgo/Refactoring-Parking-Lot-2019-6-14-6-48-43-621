package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    @Test
    public void manager_can_manager_pakingboy_parking() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        Manager manager=new Manager(parkingLot);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        SmartPakingBoy smartPakingBoy=new SmartPakingBoy(parkingLot);
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(parkingLot);
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Car car=new Car();
        Ticket ticket=manager.managePark(parkingBoy,car);
        Car fetchCar=manager.manageParkFetch(parkingBoy,ticket);
        assertThat(car, is(fetchCar));
    }
    @Test
    public void manager_can_info_when_give_a_ticket_had_been_used() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        Manager manager=new Manager(parkingLot);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        SmartPakingBoy smartPakingBoy=new SmartPakingBoy(parkingLot);
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(parkingLot);
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Car car=new Car();
        Throwable exception2 = assertThrows(ParkingException.class,()->{
            Ticket ticket=manager.managePark(parkingBoy,car);
            Car fetchCar=manager.manageParkFetch(parkingBoy,ticket);
            Car fetchCar1=manager.manageParkFetch(parkingBoy,ticket);
        });
        assertEquals("Unrecognized parking ticket.",exception2.getMessage());
    }
    @Test
    public void manager_can__parking() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        Manager manager=new Manager(parkingLot);
        ParkingBoy parkingBoy=new ParkingBoy(parkingLot);
        SmartPakingBoy smartPakingBoy=new SmartPakingBoy(parkingLot);
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy(parkingLot);
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Car car=new Car();
        Ticket ticket=manager.parking(car);
        Car fetchCar=manager.fetchCar(ticket);
        assertThat(car, is(fetchCar));
    }
}
