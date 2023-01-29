import java.awt.*;

/**
 * Car collects and handles all common traits of cars. It stores the characteristics of a car such as: number of doors,
 * engine power, color, model name.
 * It also contains methods for getting and setting these characteristics along with methods for incrementing and
 * decrementing speed.
 */
public abstract class Car extends Vehicle{

    private final double weight;

    Car(int nrDoors, double enginePower, Color color, String modelName,
        double xPos, double yPos, Direction dir, double currentSpeed, double weight){

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);

        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

