import java.awt.*;

/**
 * Volvo240 is used to create and initialize a Volvo object.
 * A Volvo contains all constructors from the super-class car.
 * The Volvo object is unique to a car since it's speedfactor is different and dependant upon it's trimfactor.
 */
public class Volvo240 extends Car {

    public double trimFactor;

    Volvo240(int nrDoors, double enginePower, Color color, String modelName, double trimFactor,
             double xPos, double yPos, Direction dir, double currentSpeed) {

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
