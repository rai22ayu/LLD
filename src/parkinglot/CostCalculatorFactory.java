package parkinglot;

public class CostCalculatorFactory {

    public Calculator getCostCalculator(Ticket ticket){
        Vehicle vehicle = ticket.getVehicle();
        VehicleType vehicleType = vehicle.getVehicleType();
        if (vehicleType == VehicleType.TWO_WHEELER) {
            return new TwoWheelerCostCalculator();
        } else if (vehicleType == VehicleType.FOUR_WHEELER) {
            return new FourWheelerCostCalculator();
        }
        return null;
    }
}
