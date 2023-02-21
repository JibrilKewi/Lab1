public abstract class AbstractPositionable {


    public double xPos; // The x position of the car.
    public double yPos; // The y position of the car.



    AbstractPositionable(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    /**
     * getxPos() is a getter methd for x-coordinate.
     * @return Returns the x-coordinate
     */
    public double getxPos(){ return xPos; }

    /**
     * setxPos() sets a new x-coordinate.
     * @param x New x-coordinate.
     */
    public void setxPos(double x){ xPos = x; }

    /** getyPos() is a getter method for the y-coordinate.
     * @return Returns the y-coordinate.
     */
    public double getyPos(){
        return yPos;
    }

    /**
     * setyPos() sets a new y-coordinate.
     * @param y New y-coordinate.
     */
    public void setyPos(double y){
        yPos = y;
    }
}
