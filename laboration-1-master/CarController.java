import model.CarModel;
import model.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController{
    private final int delay = 50;
    TimeListener timeListener = new TimeListener();
    private final Timer timer = new Timer(delay, timeListener);

    public void start() {
        timer.start();
    }

}


