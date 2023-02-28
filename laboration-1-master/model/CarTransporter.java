package model;

import model.Direction;
import model.TrailerMethods;
import model.TrailerTruck;

import java.awt.*;


/**
 * model.CarTransporter is used to initialize a model.CarTransporter-object.
 * A model.CarTransporter object contains all attributes from the super-class Truck, see {@link TrailerTruck}.
 * A model.CarTransporter object is initialized with position along the x- and y- coordinates.
 * The other characteristics are set by default.
 * A model.CarTransporter can load and transport model.Car objects, see {@link Car}.
 */


public class CarTransporter extends TrailerTruck implements TrailerMethods, CarLoadMethods {
    private boolean isRampUp;
    public CarLoad<Car> load;
    private final int MIN_LOAD_DIST = 20;
    private int currentWeight = 0;

    CarTransporter(double xPos, double yPos, Direction dir) {
        super(2, 300, Color.black, "model.CarTransporter", xPos, yPos, dir, 0);

        this.load = new CarLoad<>();
        this.isRampUp = false;
    }


    /**
     * lowerTrailer() sets isRampUp to false.
     */
    @Override
    public void lowerTrailer(){
        isRampUp = false;
    }

    /**
     * raiseTrailer() sets isRampUp to true.
     */
    @Override
    public void raiseTrailer(){
        isRampUp = true;
    }

    /**
     * getRampUp() returns the current state of the ramp.
     * @return The current state of the ramp.
     */
    public boolean getIsRampUp(){
        return isRampUp;
    }


    /**
     * updateLoadPos() updates the position of all cars on the car-transporter by setting iterating over all cars
     * in the carload and updating their coordinates and direction to that of the car-transporter.
     */
    private void updateLoadPos(){
        for (Car car : load.getCars()) {
            car.setxPos(getxPos());
            car.setyPos(getyPos());
            car.setDir(getDir());
        }
    }


    /**
     * isTrailerMovable checks if the trailer is movable by checking whether the ramp is up.
     * @return true if the ramp is up.
     */
    @Override
    public boolean isTrailerMovable() {
        return isRampUp;
    }


    /**
     * move() will move the car-transporter in the current direction it is facing based on its current speed and will
     * update the position and direction of all cars currently loaded on the car-transporter.
     */
    @Override
    public void move(){
        super.move();
        updateLoadPos();
    }


    public boolean canLoad(Car car){
        return !isRampUp && isSafeWeight(car) && isCloseEnough(car) && load.notFullLoad();
    }


    /**
     * loadCar() loads a car to a car-transporter object if the ramp is down, the weight of the load does not exceed
     * a max value, the car is close enough to the transporter and the car-transporter-trailer is not full.
     * Also sets the cars coordinates to that of the car-transporter.
     * @param car The car that will be loaded.
     */

    public void loadCar(Car car) {
        if (canLoad(car)) {
            load.getCars().push(car);
            car.setxPos(getxPos());
            car.setyPos(getyPos());
        }
    }

    /**
     * unLoadCar() unloads a car from a car-transporter object and sets its coordinates to appropriate values.
     */
    public void unloadCar(){
        if (!load.getCars().isEmpty() && !isRampUp) {
            Car car = load.getCars().pop();
            car.setxPos(getxPos() + MIN_LOAD_DIST);
            car.setyPos(getyPos() + MIN_LOAD_DIST);
            currentWeight -= car.getWeight();
        }

    }

    /**
     * carLoadWeight() iterates and applies the getWeight() on all cars in the carLoad and increments the
     * currentWeight with the weight of each car.
     * @return The current weight of the load.
     */
    private int carLoadWeight(){
        for (Car car : load.getCars()) {
            currentWeight += car.getWeight();}
        return currentWeight;
    }


    /**
     * isSafeWeight() check whether the weight of the car that is getting loaded does not add up to more than the
     * maximum amount of weight allowed on the car-transporter.
     * @param car the car that wants to get loaded
     * @return True if it does not exceed the maximum weight otherwise false.
     */
    private boolean isSafeWeight(Car car){
        int MAX_WEIGHT = 10_000;
        return carLoadWeight() + car.getWeight() < MAX_WEIGHT;
    }

    /**
     * isCloseEnough() check whether the car that is getting loaded in close enough to the car-transporter based on
     * the cars current coordinates and the car-transporters coordinates.
     * @param car the car that wants to get loaded
     * @return True if it is close enough to the transporter
     */
    private boolean isCloseEnough(Car car){
        return getyPos() - car.getyPos() < MIN_LOAD_DIST && getxPos() - car.getxPos() < MIN_LOAD_DIST;
    }


}