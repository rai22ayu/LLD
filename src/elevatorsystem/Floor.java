package elevatorsystem;

public class Floor {
    private final FloorId floorId;
    private final ExternalButton externalButton;

    public Floor(FloorId floorId, ExternalButton externalButton) {
        this.floorId = floorId;
        this.externalButton = externalButton;
    }

    public void pressExternalButton(ExternalDispatcher externalDispatcher) {
        externalButton.press(floorId);
    }
}
