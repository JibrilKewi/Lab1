package model;

/**
 * The movable interface contains the blueprint for all methods necessary for movement. Implemented by model.AbstractMovable.
 * @see AbstractMovable
 */
public interface Movable {
    void move();
    void turnLeft();
    void turnRight();

}
