package parkinglot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(Vehicle vehicle, Integer entranceGate, List<ParkingSpot> parkingSpotList);
}
