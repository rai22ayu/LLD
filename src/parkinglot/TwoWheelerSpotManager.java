package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{
    private static TwoWheelerSpotManager instance;

    private TwoWheelerSpotManager() {
        super(createParkingSpotList(), new NearToEntranceStrategy());
    }

    public static synchronized TwoWheelerSpotManager getInstance(){
        if(instance == null){
            instance = new TwoWheelerSpotManager();
        }
        return instance;
    }
    private static List<ParkingSpot> createParkingSpotList() {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        // Add ParkingSpot objects to the list
        for(int i = 0; i < 10; i++){
            parkingSpotList.add(new TwoWheelerParkingSpot(i));
        }
        return parkingSpotList;
    }

}
