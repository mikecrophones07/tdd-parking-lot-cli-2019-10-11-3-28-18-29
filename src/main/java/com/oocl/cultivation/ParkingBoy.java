package com.oocl.cultivation;

import java.util.Objects;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String message;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if(parkingLot.getAvailableParkingPosition() != 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingLot.park(car, parkingTicket);
            return parkingTicket;
        }
        message = "Not enough position.";
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        if(Objects.nonNull(ticket)) {
            Car car = parkingLot.fetch(ticket);
            if (Objects.nonNull(car)) {
                return car;
            }
            message = "Please provide your parking ticket.";
            return null;
        }
        message = "Unrecognized parking ticket.";
        return null;
    }

    public String getMessage() {
        return this.message;
    }
}
