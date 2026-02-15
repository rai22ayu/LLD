package parkinglot;

public class ExitGate {
    private final Ticket ticket;
    private final Calculator calculator;
    private final CostCalculatorFactory costCalculatorFactory;
    private final Payment payment;
    private final ParkingSpotManager parkingSpotManager;
    private final ParkingFactory parkingFactory;

    public ExitGate(Ticket ticket, CostCalculatorFactory costCalculatorFactory, Payment payment, ParkingFactory parkingFactory) {
        this.ticket = ticket;
        this.costCalculatorFactory = costCalculatorFactory;
        this.payment = payment;
        this.calculator = costCalculatorFactory.getCostCalculator(ticket);
        this.parkingFactory = parkingFactory;
        this.parkingSpotManager = parkingFactory.getParkingSpotManager(ticket.getVehicle());
    }

    public double calculatePrice() {
        return calculator.calculateCost(ticket);
    }
    public void pay(){
        payment.pay();
    }
    public void freeUpSpace(){
        parkingSpotManager.freeUpParkingSpot(ticket.getParkingSpot());
    }
}
