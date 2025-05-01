package elevatorsystem;

import java.util.List;

public class ExternalButton {
    private final ExternalDispatcher externalDispatcher;
    List<Integer> floorNumber = FloorId.getFloorNumbers();
    private FloorId currentFloorId;

    public ExternalButton(FloorId floorId, ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public void press(FloorId destinationFloor) {
        externalDispatcher.dispatch(destinationFloor, currentFloorId);
        // Logic to handle button press
        System.out.println("External button pressed on floor: " + currentFloorId);
    }
}
