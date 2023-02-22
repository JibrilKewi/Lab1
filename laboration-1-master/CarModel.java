import java.util.ArrayList;

public class CarModel {

    ArrayList<Vehicle> cars = new ArrayList<>();

    public void addCar(Vehicle car) {
        if(cars.size() < 10) {
        cars.add(car);
        }
    }

    public void removeCar(){
        if(cars.size() > 0) {
        cars.remove(cars.size()-1);
        }
    }

    public void updateCars() {
        for (Vehicle vehicle : cars) {
            if (vehicle.getxPos() > 700 || vehicle.getxPos() < 0 || vehicle.getyPos() > 700 || vehicle.getyPos() < 0){
                vehicle.turnLeft();
                vehicle.turnLeft();
                vehicle.move();
            } else {
                vehicle.move();
            }
        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.brake(brake);
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : cars) {
            vehicle.stopEngine();
        }
    }

    void startEngine() {
        for (Vehicle vehicle : cars) {
            vehicle.startEngine();
        }
    }

    // Calls setTurboOn for all saab objects once
    void turboOn() {
        for (Vehicle car : cars) {
            if(car instanceof Saab95 saab95){
                saab95.setTurboOn();
            }
        }
    }

    // Calls setTurboOff for all saab objects once
    void turboOff() {
        for (Vehicle car : cars) {
            if(car instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }
    void liftBed() {
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.raiseTrailer();
            }
        }
    }
    void lowerBed() {
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.lowerTrailer();
            }
        }
    }

    public ArrayList<Vehicle> getCars(){
        return cars;
    }

}

