/**
 * AbstractMovable collects and handles all information about position and movement.
 * Also contains the necessary methods for changing this information by applying these methods.
 * Implements the interface {@link Movable}
 */
public abstract class AbstractMovable implements Movable {
    private double xPos; // x-coordinate of the car
    private double yPos; // y-coordinate of the car
    private Direction dir; // Direction of the car
    public double currentSpeed; // The current speed of the car

    /**
     * Constructor to initialize AbstractMovable
     * @param xPos x-coordinate for the object
     * @param yPos y-coordinate for the object
     * @param dir Direction of the object
     * @param currentSpeed The current speed of the object
     */
    public AbstractMovable(double xPos, double yPos, Direction dir, double currentSpeed){
        this.xPos = xPos;
        this.yPos = yPos;
        this.dir = dir;
        this.currentSpeed = currentSpeed;
    }

    /**
     * Returns xPos of the car
     * @return xPos
     */
    public double getxPos(){ return xPos; }

    /**
     * Sets xPos = x of the car
     * @param x
     */
    public void setxPos(double x){ xPos = x; }

    /**
     * Returns xPos of the car
     * @return yPos
     */
    public double getyPos(){
        return yPos;
    }

    /**
     * Sets yPos = y of the car
     * @param y
     */
    public void setyPos(double y){
        yPos = y;
    }

    /**
     * Returns the currentspeed of the car
     * @return currentSpeed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Sets currentspeed based on amount
     * @param amount
     */
    void setCurrentSpeed(double amount){ currentSpeed = amount; }

    /**
     * Returns direction dir of car
     * @return dir
     */
    public Direction getDir(){return dir;}

    /**
     * The move method moves the object in the direction specified by the dir variable.
     * The movement is based on the current speed of the object.
     */
    @Override
    public void move() {
        switch (dir) {
            case NORTH -> yPos += currentSpeed;
            case SOUTH -> yPos -= currentSpeed;
            case EAST -> xPos += currentSpeed;
            case WEST -> xPos -= currentSpeed;
        }
    }

    /**
     * The turnLeft method turns the object in the direction specified by the dir variable.
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
     * The turnRight method turns the object in the direction specified by the dir variable.
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
