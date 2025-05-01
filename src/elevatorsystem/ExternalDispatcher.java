package elevatorsystem;

import java.util.List;

public class ExternalDispatcher {
    private final List<ElevatorController> elevatorControllerList;
    private static ExternalDispatcher instance;

    private ExternalDispatcher() {
        this.elevatorControllerList = ElevatorManager.elevatorList;
    }
    public void dispatch(FloorId destinationFloor, FloorId currentFloor){
        ElevatorController ec = findOptimalElevatorController(currentFloor);
        ec.executeMovementStrategy(destinationFloor, currentFloor);
    }
    private ElevatorController findOptimalElevatorController(FloorId currentFloor){
        ElevatorController optimalElevatorController = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController elevatorController : elevatorControllerList) {
            int distance = Math.abs(currentFloor.getFloorNumber() - elevatorController.getElevator().getCurrentFloorId().getFloorNumber());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevatorController = elevatorController;
            }
        }

        return optimalElevatorController;
    }

    public static synchronized ExternalDispatcher getInstance(){
        if (instance == null){
            instance = new ExternalDispatcher();
        }
        return instance;
    }
}
