package model;

import java.util.ArrayList;
import java.util.List;

public class World implements VehicleModel {
    private final List<WorldListener> listeners = new ArrayList<>();
    private final CarModel c = new CarModel();

    @Override
    public void moveVehicles() {
        c.updatePos();
        notifyListeners();
    }

    @Override
    public void stopVehicles() {
        c.stopEngine();
    }

    @Override
    public void startVehicles() {
        c.startEngine();
    }

    @Override
    public void gasVehicles(int amount) {
        c.gas(amount);

    }

    @Override
    public void brakeVehicles(int amount) {
        c.brake(amount);

    }

    @Override
    public void lowerBeds() {
        c.lowerBed();

    }

    @Override
    public void liftBeds() {
        c.liftBed();

    }

    @Override
    public void turnOnTurbos() {
        c.turboOn();

    }

    @Override
    public void turnOffTurbos() {
        c.turboOff();

    }

    public void addCar(MotorizedVehicle v){
        c.addCar(v);
    }

    public void removeCar(){
        c.removeCar();
    }

    public void addListener(WorldListener listener){
        listeners.add(listener);
    }


    private void notifyListeners(){
        listeners.forEach(l -> l.actOnChange(c.getVehicles()));
    }
}
