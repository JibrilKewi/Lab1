import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

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

    public void setRampDown(){
        if (!isMoving())
            isRampDown = true;
    }

    public void setRampUp(){
        if (!isMoving())
            isRampDown = false;
    }

    public void loadCar(Car car) {
        if (isRampDown && isSafeWeight(car) && isCloseEnough(car) && notFullTrailer()) {
            carLoad.push(car);
            car.setxPos(getxPos());
            car.setyPos(getyPos());
        }
    }

    public void unLoadCar(){
        if (isRampDown) {
            Car car = carLoad.pop();
            car.setxPos(getxPos() + minLoadDist);
            car.setyPos(getyPos() + minLoadDist);
            currentWeight -= car.getWeight();
        }
    }

    public int carLoadWeight(){
        for (Car car : carLoad) {
            currentWeight += car.getWeight();
        }return currentWeight;
    }

    public boolean isSafeWeight(Car car){
        return carLoadWeight() + car.getWeight() > maxWeight;
    }

    public boolean isCloseEnough(Car car){
       return getyPos() - car.getyPos() < minLoadDist && getxPos() - car.getxPos() < minLoadDist;
    }

    public boolean notFullTrailer(){
        return carLoad.size() < maxNrOfCars;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    private void updatePos(){
        for (Car car : carLoad) {
            car.setxPos(getxPos());
            car.setyPos(getyPos());
            car.setDir(getDir());
        }
    }
    @Override
    public void incrementSpeed(double amount) {
        if(!isRampDown)
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    @Override
    public void move(){
        super.move();
        updatePos();
    }

    public Deque<Car> getCarLoad() {
        return carLoad;
    }
}
