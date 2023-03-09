package model;

import java.awt.*;
import java.util.List;

/**
 * model.Volvo240 is used to create and initialize a Volvo object.
 * A Volvo object contains all attributes from the super-class car, see {@link Car}.
 * A Volvo object is initialized with position along the x- and y-coordinate, all other characteristics
 * are set by default.
 */
public class Volvo240 extends Car {

    private final double trimFactor; // Trim-factor of a volvo object.

    public Volvo240(double xPos, double yPos, Direction dir) {

        super(2, 100, Color.BLACK, "model.Volvo240", xPos, yPos, dir, 0, 1243);
        this.trimFactor = 1.25;
    }

    /**
     * Calculate the speed factor for the car based on the engine power and the trim factor.
     * @return speedFactor, a value that represents how much the speed of the car can change based on
     * enginePower and trimFactor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
