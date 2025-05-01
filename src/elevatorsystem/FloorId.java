package elevatorsystem;

import java.util.List;

public enum FloorId {
    GROUND(0),
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    private final int floorNumber;

    FloorId(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public static FloorId fromFloorNumber(int floorNumber) {
        for (FloorId id : values()) {
            if (id.getFloorNumber() == floorNumber) {
                return id;
            }
        }
        throw new IllegalArgumentException("Invalid floor number: " + floorNumber);
    }

    public static List<Integer> getFloorNumbers(){
        return List.of(GROUND.getFloorNumber(), FIRST.getFloorNumber(), SECOND.getFloorNumber(),
                THIRD.getFloorNumber(), FOURTH.getFloorNumber(), FIFTH.getFloorNumber());
    }
}
