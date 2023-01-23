import java.awt.*;

/**
 * Car collects and handles all common traits of cars. It stores characteristics of a car such as: number of doors,
 * enginepower, color, model name. It also stores information about the cars position, direction and speed.
 * Car also contains methods for changing direction and moving.
 */
public abstract class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double currentSpeed; // The current speed of the car
    private double xPos; // x-coordinate of the car
    private double yPos; // y-coordinate of the car
    private Direction dir; // Direction of the car



    Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public abstract double speedFactor();
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    void setCurrentSpeed(double amount){ currentSpeed = amount; }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){ setCurrentSpeed(0.1); }

    public void stopEngine(){ setCurrentSpeed(0.0); }



    public double getxPos(){ return xPos; }

    public void setxPos(double x){ xPos = x; }

    public double getyPos(){
        return yPos;
    }

    public void setyPos(double y){
        yPos = y;
    }


    @Override
    public void move() {
        switch (dir) {
            case NORTH -> yPos -= currentSpeed;
            case SOUTH -> yPos += currentSpeed;
            case EAST -> xPos += currentSpeed;
            case WEST -> xPos -= currentSpeed;
        }
    }

    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = Direction.WEST;
            case SOUTH -> dir = Direction.EAST;
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
        }
    }

    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = Direction.EAST;
            case SOUTH -> dir = Direction.WEST;
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
        }
    }

    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    public void gas(double amount){
        incrementSpeed(HelperMethods.amountInterval(amount, 0, 1));
    }


    public void brake(double amount){
        decrementSpeed(HelperMethods.amountInterval(amount, 0, 1));
    }
}
