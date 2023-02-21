public class Trailer {
    private double angle;

    public Trailer() {
        this.angle = 0;
    }

    public void raise() {
        setAngle(0);
    }

    public void raise(double amount) {
        setAngle(angle - amount);
    }

    public void lower(double amount) {
        setAngle(angle + amount);
    }

    public void lower() {
        setAngle(70);
    }

    public void setAngle(double angle) {
        this.angle = HelperMethods.amountInterval(angle, 0, 70);
    }

    public double getAngle() {
        return angle;
    }
}