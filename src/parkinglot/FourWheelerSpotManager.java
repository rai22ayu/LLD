package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{
    private static FourWheelerSpotManager instance;

    private FourWheelerSpotManager() {
        super(createParkingSpotList(), new DefaultStrategy());
    }

    public static synchronized FourWheelerSpotManager getInstance(){
        if(instance == null){
            instance = new FourWheelerSpotManager();
        }
        return instance;
    }
    private static List<ParkingSpot> createParkingSpotList() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        // Add ParkingSpot objects to the list
        for(int i = 0; i < 20; i++){
            parkingSpotList.add(new TwoWheelerParkingSpot(i));
        }
        return parkingSpotList;
    }
}
