package parkinglot;

public class TwoWheelerCostCalculator extends Calculator{

    public TwoWheelerCostCalculator(){
        super(new HourlyBasedStrategy());
    }

}
