package parkinglot;

public abstract class Calculator {
    private final PricingStrategy pricingStrategy;

    public  Calculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateCost(Ticket ticket){
        return pricingStrategy.calculatePrice(ticket);
    }
}
