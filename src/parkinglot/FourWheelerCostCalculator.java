package parkinglot;

public class FourWheelerCostCalculator extends Calculator{

    public FourWheelerCostCalculator() {
        super(new MinuteBasedStrategy());
    }
}
