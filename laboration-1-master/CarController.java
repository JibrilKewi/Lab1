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

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private static CarModel model;
    private CarView view;


    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        CarController cc = new CarController();
        model = new CarModel();
        model.CarModelImpl();
        cc.view = new CarView("CarSim 2.0", cc);
        cc.view.addCar(new Saab95(0, 0, Direction.EAST));
        cc.view.addCar(new Scania(0, 0, Direction.EAST));
        cc.view.addCar(new Volvo240(0, 0, Direction.EAST));
        cc.timer.start();
    }



    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(Vehicle vehicle : model.getCars()){
                model.updateCars();
                int x = (int) Math.round(vehicle.getxPos());
                int y = (int) Math.round(vehicle.getyPos());
                int index = model.getCars().indexOf(vehicle);
                view.updateCarPosition(x, y, index);
            }
        }
    }


    public void addCar(Vehicle car) {
        model.addCar(car);
        view.addCar(car);
    }


    public void gas(int amount) {
        model.gas(amount);
    }

    public void brake(int amount) {
        model.brake(amount);
    }

    public void stopEngine() {
        model.stopEngine();
    }

    public void startEngine() {
        model.startEngine();
    }

    public void turboOn() {
        model.turboOn();
    }

    public void turboOff() {
        model.turboOff();
    }

    public void liftBed() {
        model.liftBed();
    }

    public void lowerBed() {
        model.lowerBed();
    }
}

