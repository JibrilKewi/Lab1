import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();



    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Saab95(0,0, Direction.EAST));

        cc.cars.add(new Scania(0,0, Direction.EAST));

        cc.cars.add(new Volvo240(0,0, Direction.EAST));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : cars) {
                if (vehicle.getxPos() > 700 || vehicle.getxPos() < 0){
                    vehicle.turnLeft();
                    vehicle.turnLeft();
                    vehicle.move();
                    int x = (int) Math.round(vehicle.getxPos());
                    int y = (int) Math.round(vehicle.getyPos());
                    int index = cars.indexOf(vehicle);
                    frame.drawPanel.moveit(x, y, index);
                    frame.drawPanel.repaint();
                } else {
                    vehicle.move();
                    int x = (int) Math.round(vehicle.getxPos());
                    int y = (int) Math.round(vehicle.getyPos());
                    int index = cars.indexOf(vehicle);
                    frame.drawPanel.moveit(x, y, index);
                    // repaint() calls the paintComponent method of the panel
                    frame.drawPanel.repaint();

                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : cars) {
            vehicle.brake(brake);
        }
    }

    void stopEngine() {
        for (Vehicle vehicle : cars) {
            vehicle.stopEngine();
        }
    }

    void startEngine() {
        for (Vehicle vehicle : cars) {
            vehicle.startEngine();
        }
    }

    // Calls setTurboOn for all saab objects once
    void turboOn() {
        for (Vehicle car : cars) {
            if(car instanceof Saab95 saab95){
                saab95.setTurboOn();
            }
        }
    }

    // Calls setTurboOff for all saab objects once
    void turboOff() {
        for (Vehicle car : cars) {
            if(car instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }
    void liftBed() {
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.raiseTrailer();
            }
        }
    }
    void lowerBed() {
        for (Vehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.lowerTrailer();
            }
        }
    }
}
