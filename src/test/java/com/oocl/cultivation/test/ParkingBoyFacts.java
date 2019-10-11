package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_get_parking_ticket_when_parking_boy_park_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        ParkingTicket parkingTicket = parkingBoy.park(car);
        assertNotNull(parkingTicket);
    }

    @Test
    void should_get_car_when_parking_ticket_is_back_to_parking_boy() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);

        Car fetchCar = parkingBoy.fetch(parkingTicket);
        assertNotNull(fetchCar);
    }

    @Test
    void should_park_multiple_cars_by_the_parking_Boy() {
        Car car = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingTicket parkingTicket2 = parkingBoy.park(car2);

        Car fetchCar = parkingBoy.fetch(parkingTicket);
        Car fetchCar2 = parkingBoy.fetch(parkingTicket2);

        assertEquals(fetchCar, car);
        assertEquals(fetchCar2, car2);
    }

    @Test
    void should_fetch_right_car_using_corresponding_ticket() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);

        Car fetchCar = parkingBoy.fetch(parkingTicket);
        assertEquals(fetchCar, car);
    }

    @Test
    void should_fetch_null_car_when_wrong_ticket_is_presented() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingTicket wrongTicket = new ParkingTicket();


        Car fetchCar = parkingBoy.fetch(wrongTicket);
        assertNull(fetchCar);
    }
}
