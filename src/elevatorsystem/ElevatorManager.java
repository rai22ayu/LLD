package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
    static List<ElevatorController> elevatorList = new ArrayList<>();
    static {
        for(int i = 0 ; i < 5 ; i++) {
            elevatorList.add(new ElevatorController(new Elevator(i + 1, new InternalButton(InternalDispatcher.getInstance())), new ScanMovementStrategy()));
        }
    }
}
