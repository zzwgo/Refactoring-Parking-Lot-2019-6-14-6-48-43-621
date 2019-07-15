package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {
    private ParkingLot parkingLot;
    private Manager manager;
    private ParkingBoy parkingBoy;
    private SmartPakingBoy smartPakingBoy;
    private SuperSmartParkingBoy superSmartParkingBoy;
    private Car car;
    @BeforeEach
    public void init(){
        parkingLot = new ParkingLot();
        manager = new Manager(parkingLot);
        parkingBoy = new ParkingBoy(parkingLot);
        smartPakingBoy = new SmartPakingBoy(parkingLot);
        superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        car = new Car();
    }
    @Test
    public void manager_can_manager_pakingboy_parking() throws Exception {
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Ticket ticket=manager.managePark(parkingBoy,car);
        Car fetchCar=manager.manageParkFetch(parkingBoy,ticket);

        assertThat(car, is(fetchCar));
    }
    @Test
    public void manager_can_info_when_give_a_ticket_had_been_used() throws Exception {
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Throwable exception2 = assertThrows(ParkingException.class,()->{
            Ticket ticket=manager.managePark(parkingBoy,car);
            Car fetchCar=manager.manageParkFetch(parkingBoy,ticket);
            Car fetchCar1=manager.manageParkFetch(parkingBoy,ticket);
        });

        assertEquals("Unrecognized parking ticket.",exception2.getMessage());
    }
    @Test
    public void manager_can__parking() throws Exception {
        manager.manage(parkingBoy);
        manager.manage(smartPakingBoy);
        manager.manage(superSmartParkingBoy);
        Ticket ticket=manager.parking(car);
        Car fetchCar=manager.fetchCar(ticket);

        assertThat(car, is(fetchCar));
    }
}
