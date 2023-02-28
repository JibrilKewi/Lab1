package model;

import model.AbstractPositionable;
import model.Direction;
import model.Movable;

/**
 * model.AbstractMovable collects and handles all information about position and movement.
 * Also contains the necessary methods for changing this information by applying these methods.
 * Implements the interface {@link Movable}
 */
public abstract class AbstractMovable extends AbstractPositionable implements Movable {

    private Direction dir; // The direction of the car.
    public double currentSpeed; /** The current speed of the object. */

    AbstractMovable(double xPos, double yPos, Direction dir, double currentSpeed){
        super(xPos, yPos);
        this.dir = dir;
        this.currentSpeed = currentSpeed;
    }

    /**
     * getCurrentSpeed() is a getter method for currentspeed.
     * @return Returns the currentspeed.
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * setCurrentspeed() sets a new speed.
     * @param amount New currentspeed.
     */
    void setCurrentSpeed(double amount){ currentSpeed = amount; }

    /** gerDir() is a getter method for direction.
     @return Returns the direction.
     */
    public Direction getDir(){return dir;}

    void setDir(Direction nDir){
        dir = nDir;
    }

    /**
    The move() method updates the object's x and y position based on its current direction and speed.
    */
    @Override
    public void move() {
        switch (dir) {
            case NORTH -> yPos -= currentSpeed;
            case SOUTH -> yPos += currentSpeed;
            case EAST -> xPos += currentSpeed;
            case WEST -> xPos -= currentSpeed;
        }
    }

    /**
     The turnLeft() method changes the object's direction to the left.
     */
    @Override
    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = Direction.WEST;
            case SOUTH -> dir = Direction.EAST;
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
        }
    }

    /**
     The turnRight() method changes the object's direction to the right.
     */
    @Override
    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = Direction.EAST;
            case SOUTH -> dir = Direction.WEST;
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
        }
    }
}
