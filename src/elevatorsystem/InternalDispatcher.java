package elevatorsystem;

import java.util.List;

public class InternalDispatcher {
    private static InternalDispatcher instance = null;
    private final List<ElevatorController> elevatorControllerList;

    private InternalDispatcher() {
        this.elevatorControllerList = ElevatorManager.elevatorList;
    }

    public void dispatch(FloorId destinationFloor, Elevator elevator) {
        ElevatorController elevatorController = elevatorControllerList.stream().filter(ec -> ec.getElevator().getElevatorId()
                .equals(elevator.getElevatorId())).findFirst().get();
        elevatorController.executeMovementStrategy(destinationFloor, elevator.getCurrentFloorId());
    }

    public static synchronized InternalDispatcher getInstance(){
        if(instance == null){
            instance = new InternalDispatcher();
        }
        return instance;
    }
}
