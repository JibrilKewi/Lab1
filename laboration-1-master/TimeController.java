import model.CarModel;

import javax.swing.*;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class TimeController {
    private final int delay = 50;
    private final Timer timer;

    public TimeController(CarModel model, VehicleView view) {
        this.timer = new Timer(delay, new VehicleController(model, view));
    }

    public void start() {
        timer.start();
    }
}




