import java.awt.*;

/**
 * Volvo240 is used to create and initialize a Volvo object.
 * A Volvo contains all attributes from the super-class car, see {@link Car}.
 * A Volvo object is initialized with position along the x- and y-coordinate, all other characteristics
 * are set by default.
 */
public class Volvo240 extends Car {

    public double trimFactor;

    Volvo240(double xPos, double yPos, Direction dir) {

        super(2, 100, Color.BLACK, "Volvo240", xPos, yPos, dir, 0);
        this.trimFactor = 1.25;
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

}
