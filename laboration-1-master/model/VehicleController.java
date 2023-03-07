package model;

public class VehicleController implements ViewListener {
    private final CarModel model;

    public VehicleController(CarModel model){
        this.model = model;
    }

    @Override
    public void gasPerformed(int gasAmount) {
        model.gas(gasAmount);
    }

    @Override
    public void brakePerformed(int brakeAmount) {
        model.brake(brakeAmount);
    }

    @Override
    public void turboOnPerformed() {
        model.turboOn();
    }

    @Override
    public void turboOffPerformed() {
        model.turboOff();
    }

    @Override
    public void startPerformed() {
        model.startEngine();
    }

    @Override
    public void stopPerformed() {
        model.stopEngine();
    }

    @Override
    public void liftBedPerformed() {
        model.liftBed();
    }

    @Override
    public void lowerBedPerformed() {
        model.lowerBed();
    }
}
