import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * CarTransporter is used to initialize a CarTransporter-object.
 * A CarTransporter object contains all attributes from the super-class Truck, see {@link Truck}.
 * A CarTransporter object is initialized with position along the x- and y- coordinates.
 * The other characteristics are set by default.
 * A CarTransporter can load and transport Car objects, see {@link Car}.
 */


public class CarTransporter extends Truck {
    private boolean isRampDown;
    private static int maxWeight = 10_000;
    private static int maxNrOfCars = 10;
    private int currentWeight;
    private final int minLoadDist = 20;
    private final Deque<Car> carLoad = new LinkedList<>();

    CarTransporter(double xPos, double yPos, Direction dir) {
        super(2, 300, Color.black, "CarTransporter", xPos, yPos, dir, 0);

        this.isRampDown = false;
    }

    /**
     * setRampDown() sets isRampDown to true.
     */
    public void setRampDown(){
        if (!isMoving())
            isRampDown = true;
    }
    /**
     * setRampDown() sets isRampDown to false.
     */
    public void setRampUp(){
        if (!isMoving())
            isRampDown = false;
    }

    /**
     * getRampDown() returns the current state of the ramp.
     * @return The current state of the ramp.
     */
    public boolean getIsRampDown(){
        return isRampDown;
    }

    /**
     * loadCar() loads a car to a car-transporter object if the ramp is down, the weight of the load does not exceed
     * a max value, the car is close enough to the transporter and the car-transporter-trailer is not full.
     * Also sets the cars coordinates to that of the car-transporter.
     * @param car The car that will be loaded.
     */
    public void loadCar(Car car) {
        if (isRampDown && isSafeWeight(car) && isCloseEnough(car) && notFullTrailer()) {
            carLoad.push(car);
            car.setxPos(getxPos());
            car.setyPos(getyPos());
        }
    }

    /**
     * unLoadCar() unloads a car from a car-transporter object and sets its coordinates to appropriate values.
     * @return The unloaded car.
     */
    public Car unLoadCar(){
        Car car = carLoad.pop();
        if (isRampDown) {
            car.setxPos(getxPos() + minLoadDist);
            car.setyPos(getyPos() + minLoadDist);
            currentWeight -= car.getWeight();
        } return car;

    }

    /**
     * carLoadWeight() iterates and applies the getWeight() on all cars in the carLoad and increments the
     * currentWeight with the weight of each car.
     * @return The current weight of the load.
     */
    private int carLoadWeight(){
        for (Car car : carLoad) {
            currentWeight += car.getWeight();
        } return currentWeight;
    }

    /**
     * isSafeWeight() check whether the weight of the car that is getting loaded does not add up to more than the
     * maximum amount of weight allowed on the car-transporter.
     * @param car the car that wants to get loaded
     * @return True if it does not exceed the maximum weight otherwise false.
     */
    private boolean isSafeWeight(Car car){
        return carLoadWeight() + car.getWeight() < maxWeight;
    }

    /**
     * isCloseEnough() check whether the car that is getting loaded in close enough to the car-transporter based on
     * the cars current coordinates and the car-transporters coordinates.
     * @param car the car that wants to get loaded
     * @return True if it does not exceed the maximum weight otherwise false.
     */
    private boolean isCloseEnough(Car car){
       return getyPos() - car.getyPos() < minLoadDist && getxPos() - car.getxPos() < minLoadDist;
    }

    /**
     * notFullTrailer() checks whether the car-transporters's load holds the maximum number of cars or not.
     * @return True if the trailer is not full otherwise false.
     */
    public boolean notFullTrailer(){
        return carLoad.size() < maxNrOfCars;
    }

    /**
     * updateLoadPos() updates the position of all cars on the car-transporter by setting iterating over all cars
     * in the carload and updating their coordinates and direction to that of the car-transporter.
     */

    private void updateLoadPos(){
        for (Car car : carLoad) {
            car.setxPos(getxPos());
            car.setyPos(getyPos());
            car.setDir(getDir());
        }
    }

    /**
     * incrementSpeed() checks whether the ramp is up or down and if the ramp is up it will increment the speed
     * of the car-transporter.
     */
    @Override
    public void incrementSpeed(double amount) {
        if(!isRampDown)
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
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
    /**
     * getCarLoad() is a getter method for getting the loaded cars.
     * @return A deque containing all currently loaded cars.
     */
    public Deque<Car> getCarLoad() {
        return carLoad;
    }

}
