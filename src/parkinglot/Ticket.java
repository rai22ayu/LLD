package parkinglot;

import java.sql.Timestamp;

public class Ticket {
    private Timestamp entryTime;
    private Vehicle vehicle;//might not need this
    private ParkingSpot parkingSpot;

    public Ticket() {
        this.entryTime = new Timestamp(System.currentTimeMillis());
    }
    public Ticket(Timestamp entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
