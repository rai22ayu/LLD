package parkinglot;

public class MinuteBasedStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Ticket ticket) {
        long diff = (System.currentTimeMillis() - ticket.getEntryTime().getTime())/1000*60;
        return diff*ticket.getParkingSpot().getPrice();
    }
}
