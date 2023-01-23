import java.awt.*;

/**
 * Car collects and handles all common traits of cars. It stores the characteristics of a car such as: number of doors,
 * engine power, color, model name.
 * It also contains methods for getting and setting these characteristics along with methods for incrementing and
 * decrementing speed.
 */
public abstract class Car extends AbstractMovable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public Color color; // Color of the car
    public String modelName; // The car model name


    Car(int nrDoors, double enginePower, Color color, String modelName,
        double xPos, double yPos, Direction dir, double currentSpeed){

        super(xPos, yPos, dir, currentSpeed);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public abstract double speedFactor();

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
