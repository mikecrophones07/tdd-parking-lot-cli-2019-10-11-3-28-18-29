package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingLot.park(car, parkingTicket);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.fetch(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
