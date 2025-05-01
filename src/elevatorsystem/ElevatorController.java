package elevatorsystem;

public class ElevatorController {
    private final Elevator elevator;
    private final MovementStrategy movementStrategy;

    public ElevatorController(Elevator elevator, MovementStrategy movementStrategy) {
        this.elevator = elevator;
        this.movementStrategy = movementStrategy;
    }

    public Elevator getElevator() {
        return elevator;
    }
    public void executeMovementStrategy(FloorId destinationFloor, FloorId currentFloor) {
        movementStrategy.moveElevator(destinationFloor, currentFloor);
        elevator.setCurrentFloorId(destinationFloor);
    }
}
