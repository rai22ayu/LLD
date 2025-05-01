package elevatorsystem;

import java.util.List;

public class InternalButton {
    private final InternalDispatcher internalDispatcher;
    List<Integer> floorNumber = FloorId.getFloorNumbers();

    public InternalButton(InternalDispatcher internalDispatcher) {
        this.internalDispatcher = internalDispatcher;
    }
    public void press(int destinationFloor, Elevator elevator){
        if(floorNumber.contains(destinationFloor)){
            internalDispatcher.dispatch(FloorId.fromFloorNumber(destinationFloor), elevator);
        } else {
            System.out.println("Invalid floor number");
        }
    }
}
