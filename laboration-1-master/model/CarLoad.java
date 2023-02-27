package model;

import java.util.Deque;
import java.util.LinkedList;

public class CarLoad <T extends Car>{
    private static final int MAX_CARS = 10;
    private final Deque<T> cars;
    public CarLoad() {
        this.cars = new LinkedList<>();
    }

    /**
     * loadCar() loads a car to a car-transporter object if the ramp is down, the weight of the load does not exceed
     * a max value, the car is close enough to the transporter and the car-transporter-trailer is not full.
     * Also sets the cars coordinates to that of the car-transporter.
     * @param car The car that will be loaded.
     */

    public void loadCar(T car) {
        cars.push(car);
    }

    /**
     * unLoadCar() unloads a car from a car-transporter object and sets its coordinates to appropriate values.
     */
    public void unloadCar(){
        cars.pop();
    }


    /**
     * notFullTrailer() checks whether the car-transporters's load holds the maximum number of cars or not.
     * @return True if the trailer is not full otherwise false.
     */
    public boolean notFullLoad(){
        return cars.size() < MAX_CARS;
    }

    /**
     * getCarLoad() is a getter method for getting the loaded cars.
     * @return A deque containing all currently loaded cars.
     */
    public Deque<T> getCars() {
        return cars;
    }

    public static int getMaxCars() {
        return MAX_CARS;
    }
}