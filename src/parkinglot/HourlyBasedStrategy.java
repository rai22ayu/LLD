package parkinglot;

public class HourlyBasedStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Ticket ticket) {
        long timeDiff = System.currentTimeMillis() - ticket.getEntryTime().getTime();
        long hours = timeDiff / (1000 * 60 * 60);
        return hours * ticket.getParkingSpot().getPrice() + 10;
    }
}
