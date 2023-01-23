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

    public AbstractMovable(double xPos, double yPos, Direction dir, double currentSpeed){
        this.xPos = xPos;
        this.yPos = yPos;
        this.dir = dir;
        this.currentSpeed = currentSpeed;
    }

    public double getxPos(){ return xPos; }

    public void setxPos(double x){ xPos = x; }

    public double getyPos(){
        return yPos;
    }

    public void setyPos(double y){
        yPos = y;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    void setCurrentSpeed(double amount){ currentSpeed = amount; }

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
}
