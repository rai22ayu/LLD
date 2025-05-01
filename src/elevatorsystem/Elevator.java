package elevatorsystem;

public class Elevator {
    private final Integer elevatorId;
    private final InternalButton internalButton;
    private FloorId currentFloorId;
    private Direction direction;
    private State state;

    public Elevator(Integer elevatorId, InternalButton internalButton) {
        this.elevatorId = elevatorId;
        this.internalButton = internalButton;
        this.currentFloorId = FloorId.FIRST;
        this.state = State.IDLE;
    }

    public Integer getElevatorId(){
        return elevatorId;
    }
    public FloorId getCurrentFloorId() {
        return currentFloorId;
    }
    public void setCurrentFloorId(FloorId currentFloorId) {
        this.currentFloorId = currentFloorId;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton(int destinationFloor) {
        if (internalButton != null) {
            internalButton.press(destinationFloor, this);
        } else {
            System.out.println("Internal button not initialized.");
        }
    }

}
