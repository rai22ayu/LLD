package parkinglot;

import java.sql.Timestamp;

public class EntranceGate {
    private final int gateNumber;
    private final ParkingFactory parkingFactory;

    public EntranceGate(int gateNumber, ParkingFactory parkingFactory) {
        this.gateNumber = gateNumber;
        this.parkingFactory = parkingFactory;
    }
    public Ticket generateTicket(Vehicle vehicle){
        ParkingSpot parkingSpot = bookParkingSpot(vehicle);
        Ticket ticket = new Ticket(new Timestamp(System.currentTimeMillis()), vehicle, parkingSpot);
        return ticket;
    }

    private ParkingSpot bookParkingSpot(Vehicle vehicle){
        ParkingSpotManager parkingSpotManager = parkingFactory.getParkingSpotManager(vehicle);
        return parkingSpotManager.parkVehicle(vehicle, gateNumber);
    }
}
