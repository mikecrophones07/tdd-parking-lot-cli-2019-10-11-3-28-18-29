package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if(parkingLot.getAvailableParkingPosition() != 0) {
            ParkingTicket parkingTicket = new ParkingTicket();
            parkingLot.park(car, parkingTicket);
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.fetch(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
