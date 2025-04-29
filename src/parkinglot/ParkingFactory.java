package parkinglot;

public class ParkingFactory {
    public ParkingSpotManager getParkingSpotManager(Vehicle vehicle){
        switch (vehicle.getVehicleType()){
            case TWO_WHEELER -> {
                return TwoWheelerSpotManager.getInstance();
            }
            case FOUR_WHEELER -> {
                return FourWheelerSpotManager.getInstance();
            }
            default -> {
                return null;
            }
        }
    }
}
