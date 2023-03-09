package Control;

import model.World;

public class VehicleController implements ViewListener {
    private final World model;

    public VehicleController(World model){
        this.model = model;
    }

    @Override
    public void gasPerformed(int gasAmount) {
        model.gasVehicles(gasAmount);
    }

    @Override
    public void brakePerformed(int brakeAmount) {
        model.brakeVehicles(brakeAmount);
    }

    @Override
    public void turboOnPerformed() {
        model.turnOnTurbos();
    }

    @Override
    public void turboOffPerformed() {
        model.turnOffTurbos();
    }

    @Override
    public void startPerformed() {
        model.startVehicles();
    }

    @Override
    public void stopPerformed() {
        model.stopVehicles();
    }

    @Override
    public void liftBedPerformed() {
        model.liftBeds();
    }

    @Override
    public void lowerBedPerformed() {
        model.lowerBeds();
    }
}
