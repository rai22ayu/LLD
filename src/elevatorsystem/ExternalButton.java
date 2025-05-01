package elevatorsystem;

import java.util.List;

public class ExternalButton {
    private final ExternalDispatcher externalDispatcher;
    List<Integer> floorNumber = FloorId.getFloorNumbers();
    private final FloorId currentFloorId;

    public ExternalButton(ExternalDispatcher externalDispatcher, FloorId currentFloorId) {
        this.externalDispatcher = externalDispatcher;
        this.currentFloorId = currentFloorId;
    }

    public void press(FloorId destinationFloor) {
        if (!floorNumber.contains(destinationFloor.getFloorNumber())) {
            System.out.println("Invalid floor number");
            return;
        }
        externalDispatcher.dispatch(destinationFloor, currentFloorId);
        // Logic to handle button press
        System.out.println("External button pressed on floor: " + currentFloorId);
    }
}
