package parkinglot;

import java.util.List;

public abstract class ParkingSpotManager {
    private final List<ParkingSpot> parkingSpotList;
    private final ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList, ParkingStrategy parkingStrategy){
        this.parkingSpotList = parkingSpotList;
        this.parkingStrategy = parkingStrategy;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
    }
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
    }
    public ParkingSpot findParkingSpot(Vehicle vehicle, Integer entranceGate) {
        return parkingStrategy.findSpot(vehicle, entranceGate, parkingSpotList);
        //use parking strategy to find parking spot
    }
    public ParkingSpot parkVehicle(Vehicle vehicle, Integer entranceGate) {
        ParkingSpot parkingSpot = findParkingSpot(vehicle, entranceGate);
        if (parkingSpot != null) {
            parkingSpot.parkVehicle(vehicle);
            return parkingSpot;
        }
        return null;
    }
}
