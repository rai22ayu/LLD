package elevatorsystem;

public interface MovementStrategy {
    void moveElevator(FloorId currentFloor, FloorId destinationFloor);
}
