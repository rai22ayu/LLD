package parkinglot;

public abstract class ParkingSpot {
    private long spotId;
    private Vehicle vehicle;
    private boolean isAvailable;
    protected int price = 0;

    public ParkingSpot(long spotId) {
        this.spotId = spotId;
        this.isAvailable = true;
    }
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public int getPrice() {
        return price;
    }
}
