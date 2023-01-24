import java.awt.*;

/**
 * Volvo240 is used to create and initialize a Volvo object.
 * A Volvo contains all constructors from the super-class car.
 * The Volvo object is unique to a car since it's speedfactor is different and dependant upon it's trimfactor.
 */
public class Volvo240 extends Car {

    public double trimFactor;

    Volvo240(double xPos, double yPos, Direction dir, double currentSpeed) {

        super(2, 100, Color.BLACK, "Volvo240", xPos, yPos, dir, currentSpeed);
        this.trimFactor = 1.25;
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
